CREATE SCHEMA user AUTHORIZATION sa;
CREATE SCHEMA ccwp AUTHORIZATION sa;

CREATE TABLE user.user_detail (
    user_id integer identity NOT NULL,
    user_name varchar(80) NOT NULL,
    CONSTRAINT pk_app_detail_id PRIMARY KEY (user_id)
);

CREATE TABLE user.user_group (
    id integer identity NOT NULL,
    user_id integer NOT NULL,
    group_id integer NOT NULL,
    CONSTRAINT pk_user_group_id PRIMARY KEY (id)
);

CREATE TABLE ccwp.group_function (
    id integer identity NOT NULL,
    group_id integer NOT NULL,
    function_code varchar(80) NOT NULL,
    CONSTRAINT pk_group_function_id PRIMARY KEY (id)
);

CREATE TABLE ccwp.app_function (
    function_id integer identity NOT NULL,
    app_code varchar(80) NOT NULL,
    function_name varchar(80) NOT NULL,
    function_code varchar(80) NOT NULL,
    CONSTRAINT pk_app_function_id PRIMARY KEY (function_id)
);

CREATE TABLE ccwp.app_detail (
    app_id integer identity NOT NULL,
    app_name varchar(80) NOT NULL,
    app_code varchar(80) NOT NULL,
    CONSTRAINT pk_app_detail_id PRIMARY KEY (app_id)
);

