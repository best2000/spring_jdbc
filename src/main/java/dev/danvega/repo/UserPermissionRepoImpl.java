package dev.danvega.repo;

import dev.danvega.model.*;
import dev.danvega.model.Menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserPermissionRepoImpl implements UserPermissionRepo{

    private static final Logger log = LoggerFactory.getLogger(UserPermissionRepo.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Permission checkPermission(Permission permission) {
        //input 3 search 3
        //result = 2 then permission granted
        //result = 1 then error one of the function_code wrong
        //result = 0 then error permission not exist
//        SELECT (*)
//        FROM ccwp.group_function gf
//        INNER JOIN user.user_group ug
//        ON gf.group_id = ug.group_id
//        INNER JOIN ccwp.app_function af
//        ON af.function_code = gf.function_code
//        WHERE ug.user_id = 1
//        AND af.app_code = {app_code}
//        AND (gf.function_code = {operation_function_code} OR gf.function_code = {function_code})
//        AND (SUBSTRING({function_code}, 1, 3) = SUBSTRING({operation_function_code}, 1, 3))
//        AND substring({function_code}, 4, 2) LIKE '00'
//        AND substring({operation_function_code}, 4, 2) NOT LIKE '00'
//        LIMIT 2

        //input 2 search 2 but check if it shoud be 3 ?
        //result = 0 then permission denied
        //result = 1 then permission granted
        //result = 2 then error incorrect operation_function_code
//        SELECT COUNT(*)
//        FROM ccwp.group_function gf
//        INNER JOIN user.user_group ug
//          ON gf.group_id = ug.group_id
//        INNER JOIN ccwp.app_function af
//          ON af.function_code = gf.function_code
//        WHERE ug.user_id = {user_login}
//          AND af.app_code = {app_code}
//          AND CASE
//                  WHEN SUBSTRING({function_code}, 4, 2) = '00'
//                      THEN gf.function_code LIKE SUBSTRING({function_code}, 1, 3) || '%'
//                  ELSE gf.function_code = {function_code}
//              END
//        LIMIT 2

        String sql = "SELECT EXISTS( \n"+
                "SELECT 1 FROM ccwp.group_function gf \n"+
                "INNER JOIN user.user_group ug \n"+
                    "ON gf.group_id = ug.group_id \n"+
                "WHERE ug.user_id = ? \n"+
                    "AND gf.function_id = ? \n"+
                ")";
         Boolean permissionChecked = jdbcTemplate.queryForObject(sql, new Object[]{
                permission.getUser().getId(),
                permission.getAppFunctionId()
         }, Boolean.class);
        if (permissionChecked == true) {
            permission.setStatus(Permission.verificationStatus.PASSED);
        } else {
            permission.setStatus(Permission.verificationStatus.FAILED);
        }
        return permission;
    }

    @Override
    public List<Menu> getPermission(User user) {
        String sql = "SELECT ad.app_name, af.app_id, af.function_id, af.function_name\n" +
                "FROM ccwp.group_function gf \n" +
                "INNER JOIN user.user_group ug \n" +
                "    ON ug.group_id = gf.group_id\n" +
                "INNER JOIN ccwp.app_function af \n" +
                "    ON af.function_id = gf.function_id \n" +
                "INNER JOIN ccwp.app_detail ad \n" +
                "    ON ad.app_id = af.app_id\n" +
                "WHERE ug.user_id = ?\n"+
                "ORDER BY ad.app_name ASC, af.function_name ASC";


//        SELECT ad.app_name, af.app_code, af.function_code, af.function_name
//        FROM ccwp.group_function gf
//        INNER JOIN user.user_group ug
//        ON ug.group_id = gf.group_id
//        INNER JOIN ccwp.app_function af
//        ON af.function_code = gf.function_code
//        INNER JOIN ccwp.app_detail ad
//        ON ad.app_code = af.app_code
//        WHERE ug.user_id = 1
//        ORDER BY af.function_code ASC

//        List <Menu> menus = jdbcTemplate.query(sql,new Object[]{user.getId()},(rs, rowNum) ->
//                new Menu( rs.getString("app_name"),
//                        rs.getInt("app_id"),
//                        rs.getString("function_name"),
//                        rs.getInt("function_id"))
//        );
        return null;
    }
}
