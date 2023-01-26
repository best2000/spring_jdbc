INSERT INTO user.user_detail(user_login) values ('user1');
INSERT INTO user.user_detail(user_login) values ('user2');
INSERT INTO user.user_detail(user_login) values ('user3');

INSERT INTO user.user_group(user_login, group_id) values ('user1',1);
INSERT INTO user.user_group(user_login, group_id) values ('user2',2);
INSERT INTO user.user_group(user_login, group_id) values ('user3',3);

INSERT INTO ccwp.group_function(group_id, function_code) values (1,'10100');
INSERT INTO ccwp.group_function(group_id, function_code) values (1,'10101');
INSERT INTO ccwp.group_function(group_id, function_code) values (1,'10102');
INSERT INTO ccwp.group_function(group_id, function_code) values (2,'20100');

INSERT INTO ccwp.app_function(app_code,function_name,function_code) values ('CCWP', 'User Manage','10100');
INSERT INTO ccwp.app_function(app_code, function_name,function_code) values ('CCWP', 'User Manage - add','10101');
INSERT INTO ccwp.app_function(app_code, function_name,function_code) values ('CCWP', 'User Manage - delete','10102');
INSERT INTO ccwp.app_function(app_code,function_name,function_code) values ('AIR', 'Calling','20100');

INSERT INTO ccwp.app_detail(app_code, app_name ) values ('CCWP','CCWP');
INSERT INTO ccwp.app_detail(app_code, app_name) values ('AIR','AIR web center');