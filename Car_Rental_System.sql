create database car_rental_system;
use car_rental_system;

CREATE TABLE IF NOT EXISTS Customer (
	customer_id VARCHAR(20) NOT NULL ,
	customer_name VARCHAR(20) not null,
	driving_license varchar(20) not null,
	address VARCHAR(40) not null,
	email VARCHAR(20) not null,
	pass VARCHAR(20) not null,
	PRIMARY KEY (customer_id )
);

CREATE TABLE IF NOT EXISTS Owner (
	owner_id varchar(20) NOT NULL,
	owner_name varchar(20) NOT NULL,
	address varchar(40) NOT NULL,
	email varchar(30) NOT NULL,
	pass varchar(30) NOT NULL,
	joining_date varchar(10) NOT NULL,
	PRIMARY KEY (owner_id) 
);

CREATE TABLE   Vehicle(
	vehicle_id INT NOT NULL auto_increment,
	owner_id varchar(20) not null,
	model VARCHAR(20) not null,
	plate_no VARCHAR(20) not null,
	mileage INT not null,
	rent_price INT not null,
	`condition` VARCHAR(20),
    reservation VARCHAR(5) DEFAULT 'NR',
	PRIMARY KEY (vehicle_id),
	FOREIGN KEY (owner_id) REFERENCES Owner(owner_id) ON UPDATE CASCADE
);

CREATE TABLE reservation_table(
	reserve_id INT NOT NULL AUTO_INCREMENT,
    vehicle_id INT NOT NULL,
    customer_id VARCHAR (20) NOT NULL,
	rental_date VARCHAR(20) NOT NULL,
	pickup_date VARCHAR(20) NOT NULL,
	return_date VARCHAR(20) NOT NULL,
	no_of_days INT NOT NULL,
	pickup_place VARCHAR(20),
	PRIMARY KEY (reserve_id),
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id) ON UPDATE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON UPDATE CASCADE
);
