
JSP / Spring Boot / native query template


<set db>
create database tweaksense;
use mysql;
create user 'testuser1'@'localhost' identified by 'testpw1';
grant all privileges on tweaksense.* to 'testuser1'@'localhost';
GRANT DELETE, INSERT, SELECT, UPDATE ON tweaksense.* to 'testuser1'@'localhost';
flush privileges;

CREATE TABLE tweaksense.test1
(
	`test1_id`             INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '시퀀스 넘버',
	`test_data`            VARCHAR(30) NOT NULL COMMENT '테스트 데이터',
	`reg_time`             TIMESTAMP NOT NULL COMMENT '등록 시간',
	PRIMARY KEY (`test1_id`)
) COLLATE='utf8mb4_general_ci' ENGINE=InnoDB;

