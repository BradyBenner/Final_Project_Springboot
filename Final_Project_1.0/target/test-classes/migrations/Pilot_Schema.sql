DROP TABLE IF EXISTS shipmissions;
DROP TABLE IF EXISTS ships;
DROP TABLE IF EXISTS pilots;

DROP TABLE IF EXISTS missions;



CREATE TABLE pilots (
  pilot_id int  NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  license varchar(20),
  PRIMARY KEY (pilot_id)
);

CREATE TABLE ships (
  ship_id int  NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  pilot_id int,
  FOREIGN KEY (pilot_id) REFERENCES pilots (pilot_id),
  PRIMARY KEY (ship_id)
);

CREATE TABLE missions (
  mission_id int  NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  location varchar(20),
  PRIMARY KEY (mission_id)
);

CREATE TABLE shipmissions (
  shipmission_id int  NOT NULL AUTO_INCREMENT,
  ship_id int,
  mission_id int,
  FOREIGN KEY (ship_id) REFERENCES ships (ship_id),
  FOREIGN KEY (mission_id) REFERENCES missions (mission_id),
 
  PRIMARY KEY (shipmission_id)
);
