DROP TABLE IF EXISTS route;

CREATE TABLE route (
     id INT NOT NULL AUTO_INCREMENT,
     city VARCHAR(30) NOT NULL,
     destiny VARCHAR(30) NOT NULL,
     departure_time      TIME NOT NULL,
     duration        INT NOT NULL,
     PRIMARY KEY (id)
);