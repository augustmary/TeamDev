DROP TABLE IF EXISTS statuses;

CREATE TYPE status AS ENUM ('NEW', 'WORK', 'SUSPENDED', 'TEST', 'DONE', 'REJECTION', 'CLOSED');

CREATE TABLE statuses (
  id          INT NOT NULL,
  title       status,
  description TEXT DEFAULT NULL
);
ALTER TABLE statuses OWNER TO postgres;
-----------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks
(
  id BIGSERIAL PRIMARY KEY,
  title TEXT,
  content TEXT,
  number TEXT,
  crtdate timestamp without time zone,
  author BIGSERIAL,
  status_id INT NOT NULL
);
ALTER TABLE tasks OWNER TO postgres;
-----------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id BIGSERIAL PRIMARY KEY,
  username TEXT,
  password TEXT,
  email TEXT
);
ALTER TABLE users OWNER TO postgres;
-----------------------------------------------------------------------------------------------------------------------------
CREATE TABLE roles (
  id  BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);
-----------------------------------------------------------------------------------------------------------------------------
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);


