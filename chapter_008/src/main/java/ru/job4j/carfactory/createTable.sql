DROP TABLE IF EXISTS transmission CASCADE;
DROP TABLE IF EXISTS engine CASCADE;
DROP TABLE IF EXISTS body CASCADE;
DROP TABLE IF EXISTS car CASCADE;

CREATE TABLE transmission (
	id serial primary key,
	type varchar(50)
);

CREATE TABLE engine (
	id serial primary key,
	type varchar(50)
);

CREATE TABLE body (
	id serial primary key,
	type varchar(50)
);

CREATE TABLE car (
	id serial primary key,
	name varchar(50),
	transmission integer references transmission(id),
	engine integer references engine(id),
	body integer references body(id)
);
