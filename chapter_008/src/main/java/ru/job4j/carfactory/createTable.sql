--Create table
DROP TABLE IF EXISTS transmission CASCADE;
DROP TABLE IF EXISTS engine CASCADE;
DROP TABLE IF EXISTS body CASCADE;
DROP TABLE IF EXISTS car CASCADE;

CREATE TABLE transmission (
	id serial primary key,
	type varchar(50) NOT NULL
);

CREATE TABLE engine (
	id serial primary key,
	type varchar(50) NOT NULL
);

CREATE TABLE body (
	id serial primary key,
	type varchar(50) NOT NULL
);

CREATE TABLE car (
	id serial primary key,
	name varchar(50) NOT NULL,
	transmission integer references transmission(id) NOT NULL,
	engine integer references engine(id) NOT NULL,
	body integer references body(id) NOT NULL
);
