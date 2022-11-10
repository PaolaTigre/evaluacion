CREATE TABLE IF NOT EXISTS attendee(
    id SERIAL,
    name VARCHAR (60) NOT NULL,
    email VARCHAR (100) UNIQUE,
    institution VARCHAR (100),
    posicion VARCHAR (100),
    PRIMARY KEY (id),
    UNIQUE (email)
    );


