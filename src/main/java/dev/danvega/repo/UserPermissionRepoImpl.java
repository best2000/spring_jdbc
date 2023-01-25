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
    public Integer checkUserPermission(String userLogin, String appCode, String functionCode) {
        String sql = "SELECT COUNT(*)\n" +
                "FROM ccwp.group_function gf\n" +
                "INNER JOIN user.user_group ug\n" +
                "ON gf.group_id = ug.group_id\n" +
                "INNER JOIN ccwp.app_function af\n" +
                "ON af.function_code = gf.function_code\n" +
                "WHERE ug.user_login = ?\n" +
                "AND af.app_code = ?\n" +
                "AND CASE\n" +
                "WHEN SUBSTRING(?, 4, 2) = '00'\n" +
                "THEN gf.function_code LIKE SUBSTRING(?, 1, 3) || '%'\n" +
                "ELSE gf.function_code = ?\n" +
                "END";
         Integer permissionCount = jdbcTemplate.queryForObject(sql, new Object[]{
                 userLogin,
                 appCode,
                 functionCode,
                 functionCode,
                 functionCode
         }, Integer.class);
        return permissionCount;
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
