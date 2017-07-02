DELETE FROM user_roles;
DELETE FROM tasks;
DELETE FROM users;
DELETE FROM roles;


INSERT INTO users (id, username, password) VALUES
  (1,'Sergey', 'Sergey'),
  (2, 'Iegor', 'Iegor'),
  (3, 'Maria', 'Maria');
/*--------------------------------------------------------------------------------------------------*/

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
/*--------------------------------------------------------------------------------------------------*/
INSERT INTO user_roles VALUES (1, 1);
INSERT INTO user_roles VALUES (2, 1);
INSERT INTO user_roles VALUES (3, 1);
INSERT INTO user_roles VALUES (3, 2);
/*--------------------------------------------------------------------------------------------------*/
INSERT INTO tasks (title, crtdate, author) VALUES
  ('task1', NULL, 1),
  ('task2', NULL, 1),
  ('task3', NULL, 2),
  ('task4', NULL, 3);

