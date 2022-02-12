-- Pilots
INSERT INTO pilots (first_name,last_name, license) VALUES ('Brady', 'Benner','ALL');
INSERT INTO pilots (first_name,last_name, license) VALUES ('Jon', 'Hero','ALL');
INSERT INTO pilots (first_name,last_name, license) VALUES ('Liara', 'Telemundo','2ND');

-- ships
INSERT INTO ships (name, pilot_id) VALUES ('Aegis', 1);
INSERT INTO ships (name, pilot_id) VALUES ('Jupiter',2);
INSERT INTO ships (name, pilot_id) VALUES ('Killmonger',3);

-- missions

INSERT INTO missions (name, location) VALUES ('ProtectAida', 'Blackhole');
INSERT INTO missions (name, location) VALUES ('KillKing', 'Saturn');

-- shipmissions

INSERT INTO shipmissions (ship_id, mission_id) VALUES (2, 2);
INSERT INTO shipmissions (ship_id, mission_id) VALUES (1, 2);
INSERT INTO shipmissions (ship_id, mission_id) VALUES (1, 1);
