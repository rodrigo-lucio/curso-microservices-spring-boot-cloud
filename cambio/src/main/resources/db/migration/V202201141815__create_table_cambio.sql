CREATE TABLE cambio (
   id serial PRIMARY KEY,
   from_currency CHAR(3) NOT NULL,
   to_currency CHAR(3) NOT NULL,
   conversion_factor NUMERIC(65,2) NOT NULL
);

CREATE INDEX cambio_id on cambio (id);