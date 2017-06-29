DELETE FROM users;
INSERT INTO users (username, password) VALUES
  ('Sergey', 'Sergey'),
  ('Iegor', 'Iegor'),
  ('Maria', 'Maria');
/*--------------------------------------------------------------------------------------------------*/
DELETE FROM roles;
INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
/*--------------------------------------------------------------------------------------------------*/
DELETE FROM user_roles;
INSERT INTO user_roles VALUES (1, 1);
INSERT INTO user_roles VALUES (2, 1);
INSERT INTO user_roles VALUES (3, 1);
INSERT INTO user_roles VALUES (3, 2);
/*--------------------------------------------------------------------------------------------------*/
DELETE FROM tasks;
INSERT INTO tasks (title, crtdate, author) VALUES
  ('task1', NULL, 1),
  ('task2', NULL, 1),
  ('task3', NULL, 2),
  ('task4', NULL, 3);
