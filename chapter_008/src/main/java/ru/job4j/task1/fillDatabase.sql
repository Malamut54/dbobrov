INSERT INTO role_permissions (name) VALUES ('can_read');
INSERT INTO role_permissions (name) VALUES ('can_write');
INSERT INTO role_permissions (name) VALUES ('can_delete');

INSERT INTO roles (role_name, permission) VALUES ('user', 1);
INSERT INTO roles (role_name, permission) VALUES ('suport', 2);
INSERT INTO roles (role_name, permission) VALUES ('admin', 3);

INSERT INTO users (login, role, password) VALUES ('Alice', 1, '12345678');
INSERT INTO users (login, role, password) VALUES ('Bob', 2, '12345678');
INSERT INTO users (login, role, password) VALUES ('Creator', 3, '12345678');

INSERT INTO categories (name) VALUES ('Bug');
INSERT INTO categories (name) VALUES ('Feature request');
INSERT INTO categories (name) VALUES ('How to');
INSERT INTO categories (name) VALUES ('Technical issue');

INSERT INTO statuses(name) VALUES ('New');
INSERT INTO statuses(name) VALUES ('Pending');
INSERT INTO statuses(name) VALUES ('Resolved');
INSERT INTO statuses(name) VALUES ('Closed');

INSERT INTO comments (description) VALUES ('Bla-bla-bla');
INSERT INTO comments (description) VALUES ('Some text');

INSERT INTO files (filepath) VALUES ('\\tech\\files\\problem1');
INSERT INTO files (filepath) VALUES ('\\tech\\files\\problem2');

INSERT INTO items (status, category, create_date, comment, file, creator) VALUES (1, 1, '2017-11-20 12:20:00', 1, 1, 1);
INSERT INTO items (status, category, create_date, comment, file, creator) VALUES (4, 3, '2017-11-20 12:21:00', 2, 2, 3);
