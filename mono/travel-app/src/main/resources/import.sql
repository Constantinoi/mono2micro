-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

create sequence travelorder_sequence start with 1 increment by 1;
INSERT INTO travelorder (id) VALUES (nextval('travelorder_sequence'));
INSERT INTO travelorder (id) VALUES (nextval('travelorder_sequence'));
INSERT INTO travelorder (id) VALUES (nextval('travelorder_sequence'));
INSERT INTO travelorder (id) VALUES (nextval('travelorder_sequence'));
INSERT INTO travelorder (id) VALUES (nextval('travelorder_sequence'));


create sequence flight_sequence start with 1 increment by 1;
INSERT INTO flight (id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),1,'BVB','CWB');
INSERT INTO flight (id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),2,'BVB','CWB');
INSERT INTO flight (id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),3,'BVB','CWB');
INSERT INTO flight (id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),4,'BVB','CWB');
INSERT INTO flight (id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),5,'BVB','CWB');

create sequence hotel_sequence start with 1 increment by 1;
INSERT INTO hotel (id,travelOrderId,nights) VALUES (nextval('hotel_sequence'),1,2);
INSERT INTO hotel (id,travelOrderId,nights) VALUES (nextval('hotel_sequence'),2,6);
INSERT INTO hotel (id,travelOrderId,nights) VALUES (nextval('hotel_sequence'),3,7);
INSERT INTO hotel (id,travelOrderId,nights) VALUES (nextval('hotel_sequence'),4,30);
INSERT INTO hotel (id,travelOrderId,nights) VALUES (nextval('hotel_sequence'),5,15);
