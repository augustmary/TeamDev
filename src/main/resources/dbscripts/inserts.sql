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
INSERT INTO statuses (id, title, description) VALUES
  (1, 'NEW', 'new'),
  (2, 'WORK', 'in work'),
  (3, 'SUSPENDED', 'suspended'),
  (4, 'TEST', 'in testing'),
  (5, 'DONE', 'is done'),
  (6, 'REJECTION', 'will not be done'),
  (7, 'CLOSED', 'closed');
/*--------------------------------------------------------------------------------------------------*/
/*INSERT INTO tasks (title, crtdate, author, status_id) VALUES
  ('task1', NULL, 1),
  ('task2', NULL, 1),
  ('task3', NULL, 2),
  ('task4', NULL, 3);
*/
