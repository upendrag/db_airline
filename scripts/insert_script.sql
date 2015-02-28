USE AIRLINE;

-- Insert Airports;
insert into AIRPORT VALUES('0AK', 'Pilot Station Airport', 'Pilot Station', 'AK');
insert into AIRPORT VALUES('16A', 'Nunapitchuk Airport', 'Nunapitchuk', 'AK');
insert into AIRPORT VALUES('1G4', 'Grand Canyon West Airport', 'Peach Springs', 'AZ');
insert into AIRPORT VALUES('2A3', 'Larsen Bay Airport', 'Larsen Bay', 'AK');
insert into AIRPORT VALUES('2A9', 'Kotlik Airport', 'Kotlik', 'AK');
insert into AIRPORT VALUES('3A5', 'Marshall Don Hunter Sr', 'Marshall', 'AK');

-- Insert Flights;
insert into FLIGHT VALUES('BDGT78','American Airlines', 42);
insert into FLIGHT VALUES('AJDK23','Southwest Airlines', 42);
insert into FLIGHT VALUES('KSLE35','United Airlines', 42);

-- Insert Flight Legs;
insert into FLIGHT_LEG VALUES('BDGT78', 1, '0AK', '09:35:00', '16A', '11:55:00'); 
insert into FLIGHT_LEG VALUES('BDGT78', 2, '16A', '12:40:00', '1G4', '15:15:00'); 
insert into FLIGHT_LEG VALUES('BDGT78', 3, '1G4', '16:30:00', '2A3', '20:05:00'); 
insert into FLIGHT_LEG VALUES('AJDK23', 1, '0AK', '11:35:00', '2A9', '15:55:00'); 
insert into FLIGHT_LEG VALUES('AJDK23', 2, '2A9', '16:45:00', '2A3', '19:55:00'); 
