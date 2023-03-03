
DROP TABLE IF EXISTS USERS;

 CREATE TABLE IF NOT EXISTS USERS (
    id INT auto_increment primary key,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    password VARCHAR(50)
 )

 DROP TABLE IF EXISTS STUDENTS;

CREATE TABLE IF NOT EXISTS STUDENTS (
   id INT auto_increment primary key,
   id_user INT NOT NULL,
   name VARCHAR(50) NOT NULL UNIQUE,
   age INT NOT NULL,
   join_at DATE,
   FOREIGN KEY (id_user) REFERENCES USERS(id)
);
