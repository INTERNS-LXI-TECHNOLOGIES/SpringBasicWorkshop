create schema carshowroom;
use carshowroom;

create table CAR (
    car_id int not null auto_increment, 
    manufacturer varchar(100) not null,
    model varchar(100) not null,
    variant varchar(10) not null,
    year int not null,
    total_kilometers int not null,
	expected_price int not null,
    other_details varchar(500),
    primary key (car_id)
);

create table users (
  username varchar(15) not null primary key,
  password varchar(15) not null
);
INSERT INTO `carshowroom`.`users` VALUES ('admin', 'admin');
INSERT INTO `carshowroom`.`users` VALUES ('user', 'user');

create table roles (
  role_name varchar(15) not null primary key
);
INSERT INTO roles VALUES ('admin');
INSERT INTO roles VALUES ('user');

create table users_roles (
  username varchar(15) not null,
  role_name varchar(15) not null,
  primary key (username, role_name),

  FOREIGN KEY (username)
    REFERENCES users (username)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  FOREIGN KEY (role_name)
    REFERENCES roles (role_name)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
INSERT INTO users_roles VALUES ('admin', 'admin');
INSERT INTO users_roles VALUES ('user', 'user');
