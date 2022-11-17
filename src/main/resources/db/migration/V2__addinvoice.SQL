CREATE TABLE IF NOT EXISTS attendee(
    id SERIAL,
    code VARCHAR (60) NOT NULL,
    create_at DATE NOT NULL,
    total DECIMAL (8,2),
    client_id INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (code),
    FOREIGN KEY (attendee_id) REFERENCES attendee ()
    );
