INSERT INTO user.user_detail(user_name) values ('Hand Solo');
INSERT INTO user.user_detail(user_name) values ('Ho Solan');
INSERT INTO user.user_detail(user_name) values ('Juja Blaka');

INSERT INTO user.user_group(user_id, group_id) values (1,1);
INSERT INTO user.user_group(user_id, group_id) values (2,2);
INSERT INTO user.user_group(user_id, group_id) values (3,3);

INSERT INTO ccwp.group_function(group_id, function_code) values (1,'10100');
INSERT INTO ccwp.group_function(group_id, function_code) values (1,'10101');
INSERT INTO ccwp.group_function(group_id, function_code) values (1,'10102');
INSERT INTO ccwp.group_function(group_id, function_code) values (2,'20100');

INSERT INTO ccwp.app_function(app_code,function_name,function_code) values ('CCWP', 'User Manage','10100');
INSERT INTO ccwp.app_function(app_code, function_name,function_code) values ('CCWP', 'User Manage - add','10101');
INSERT INTO ccwp.app_function(app_code, function_name,function_code) values ('CCWP', 'User Manage - delete','10102');
INSERT INTO ccwp.app_function(app_code,function_name,function_code) values ('AIR', 'Calling','20100');

INSERT INTO ccwp.app_detail(app_name, app_code) values ('CCWP','CCWP');
INSERT INTO ccwp.app_detail(app_name, app_code) values ('AIR','AIR web center');