create database shop;
 CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'adm102030';
 use shop;
 GRANT ALL PRIVILEGES ON * . * TO 'app_user'@'localhost';
 FLUSH PRIVILEGES;
 

