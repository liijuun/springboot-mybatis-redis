

CREATE TABLE user (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  uid CHAR(10) NOT NULL UNIQUE ,
  name CHAR(20),
  u_gender CHAR(10)
);

DROP TABLE user;

INSERT INTO user VALUES (0,'61442533', 'j23li');
INSERT INTO user VALUES (0,'61442538', 'yyy');

ALTER TABLE user ADD COLUMN gender CHAR(10);

SELECT * FROM user;