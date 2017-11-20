DROP TABLE IF EXISTS role_permissions CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS statuses CASCADE;
DROP TABLE IF EXISTS comments CASCADE;
DROP TABLE IF EXISTS files CASCADE;

CREATE TABLE role_permissions (
	Id serial primary key,
	name varchar(16) NOT NULL
);

CREATE TABLE roles (
	id serial primary key,
	role_name varchar(16) NOT NULL,
	permission integer references role_permissions(id)
);

CREATE TABLE users (
	id serial primary key,
	login varchar(16) NOT NULL,
	role integer references roles(id),
	password varchar(16) NOT NULL
);

CREATE TABLE categories (
	id serial primary key,
	name varchar(16) NOT NULL
);

CREATE TABLE statuses (
	id serial primary key,
	name varchar(16) NOT NULL
);

CREATE TABLE comments (
	id serial primary key,
	description text NOT NULL
);

CREATE TABLE files (
	id serial primary key,
	filepath text NOT NULL
);

CREATE TABLE items (
	id serial primary key,
	status integer references statuses(id),
	category integer references categories(id),
	create_date timestamp,
	comment integer references comments(id),
	file integer references files(id),
	creator integer references users(id)
);

