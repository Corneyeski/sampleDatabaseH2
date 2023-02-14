DROP TABLE IF EXISTS STUDENTS;

CREATE TABLE IF NOT EXISTS STUDENTS (
   id INT auto_increment primary key,
   name VARCHAR(50) NOT NULL UNIQUE,
   age INT NOT NULL,
   join_at DATE
)

DROP TABLE IF EXISTS USERS;

 CREATE TABLE IF NOT EXISTS USER (
    id INT auto_increment primary key,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    password VARCHAR(50)
 )