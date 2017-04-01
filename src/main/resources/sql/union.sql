#创建数据库
create database db_union;
use db_union;

#创建数据表

#管理员表

CREATE TABLE tb_manage (
  manage_id   VARCHAR(5),
  manage_pass VARCHAR(5)
);

#用户表

CREATE TABLE tb_user (
  user_id   VARCHAR(7) PRIMARY KEY,
  user_pass VARCHAR(18) DEFAULT '123456',
  user_name VARCHAR(20) DEFAULT ''
);

#提案表

CREATE TABLE tb_advice (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title   VARCHAR(50),
  content TEXT,
  date    TIMESTAMP,
  state SMALLINT DEFAULT 0,# 0:待审核 1:已通过审核 -1:未通过审核
  user_id VARCHAR(7)
);
