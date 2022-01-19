CREATE TABLE book (
  id serial PRIMARY KEY,
  author varchar(255),
  launch_date date NOT NULL,
  price numeric(65,2) NOT NULL,
  title varchar(255)
);