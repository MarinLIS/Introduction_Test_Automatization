CREATE TABLE IF NOT EXISTS request_type
(id integer PRIMARY KEY,
request_name text NOT NULL,
weight integer NOT NULL,
description text NOT NULL,
status integer NOT NULL,
FOREIGN KEY (status) REFERENCES status(id));

