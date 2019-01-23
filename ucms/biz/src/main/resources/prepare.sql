

CREATE TABLE sys_user (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  uid CHAR(10) NOT NULL UNIQUE ,
  name CHAR(20) NOT NULL UNIQUE ,
  password CHAR(20) NOT NULL ,
  gender CHAR(10)
);

CREATE TABLE sys_role (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name CHAR(20) NOT NULL UNIQUE ,
  description CHAR(100),
  wight INT
);

CREATE TABLE sys_user_role(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL ,
  role_id INT NOT NULL
);

CREATE TABLE sys_goods (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name CHAR(20) NOT NULL ,
  description CHAR(100) ,
  price FLOAT NOT NULL ,
  stock INT NOT NULL
);

CREATE TABLE sys_order (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  order_id CHAR(20) NOT NULL ,
  user_id INT NOT NULL ,
  goods_id INT NOT NULL ,
  count INT NOT NULL
);

CREATE TABLE sys_math_score (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL ,
  math FLOAT
);

CREATE TABLE sys_english_score (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL ,
  english FLOAT
);



TRUNCATE  sys_order;

DROP TABLE sys_user;
DROP TABLE sys_role;



DELETE FROM sys_user where uid like "%61%";
INSERT INTO sys_user VALUES (0,'61442533', 'j23li', 'xx', null);
INSERT INTO sys_user VALUES (0,'61442500', 'test', 'test', null);
INSERT INTO sys_user VALUES (0,'61442501', 'test1', 'test', null);
INSERT INTO sys_user VALUES (0,'61442502', 'test2', 'test', null);
INSERT INTO sys_user VALUES (0,'61442503', 'test3', 'test', null);
INSERT INTO sys_user VALUES (0,'61442504', 'test4', 'test', null);
INSERT INTO sys_user VALUES (0,'61442505', 'test5', 'test', null);
INSERT INTO sys_user VALUES (0,'61442506', 'test6', 'test', null);
INSERT INTO sys_user VALUES (0,'61442507', 'test7', 'test', null);


INSERT INTO sys_role VALUES (0, "admin", "administrator", 7);
INSERT INTO sys_role VALUES (0, "anonimous", "anonimous", 4);

INSERT INTO sys_role VALUES (0, "common", "common user", 6);

INSERT INTO sys_role VALUES (0, "test", "test user", 7);









SELECT * FROM sys_user;