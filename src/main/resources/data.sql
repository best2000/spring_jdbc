INSERT INTO user.user_detail(user_name) values ('Hand Solo'); --g1 g2 f1 f2 f3
INSERT INTO user.user_detail(user_name) values ('Ho Solan'); --g1 f1 f2
INSERT INTO user.user_detail(user_name) values ('Juja Blaka'); --none

INSERT INTO user.user_group(user_id, group_id) values (1,2);
INSERT INTO user.user_group(user_id, group_id) values (1,1);
INSERT INTO user.user_group(user_id, group_id) values (2,1);

INSERT INTO ccwp.group_function(group_id, function_id) values (1,1);
INSERT INTO ccwp.group_function(group_id, function_id) values (1,2);
INSERT INTO ccwp.group_function(group_id, function_id) values (2,3);

INSERT INTO ccwp.app_function(app_id,function_name) values (1, 'func1-app1');
INSERT INTO ccwp.app_function(app_id, function_name) values (1, 'func2-app1');
INSERT INTO ccwp.app_function(app_id, function_name) values (2, 'func1-app2');

INSERT INTO ccwp.app_detail(app_name) values ('First-App');
INSERT INTO ccwp.app_detail(app_name) values ('Second-App');