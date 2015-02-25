USE AIRLINE;

CREATE TABLE AIRPORT (
    Airport_code NVARCHAR(10) PRIMARY KEY,
    Name NVARCHAR(25) NOT NULL,
    City NVARCHAR(25) NOT NULL,
    State NVARCHAR(25) NOT NULL 
);

CREATE TABLE FLIGHT (
    Flight_number NVARCHAR(15) PRIMARY KEY,
    Airline NVARCHAR(25) NOT NULL,
    Weekdays NVARCHAR(10) NOT NULL
);

CREATE TABLE FLIGHT_LEG (
    Flight_number NVARCHAR(15) NOT NULL,
    Leg_number INTEGER NOT NULL,
    Departure_airport_code NVARCHAR(10) NOT NULL,
    Scheduled_departure_time TIME NOT NULL,
    Arrival_airport_code NVARCHAR(10) NOT NULL,
    Scheduled_arrival_time TIME NOT NULL,
    CONSTRAINT PRIMARY KEY 
        Pk_Flight_Leg (Flight_number, Leg_number),
    CONSTRAINT FOREIGN KEY 
        Fk_Flight_Leg_Flight (Flight_number)
    REFERENCES
        FLIGHT (Flight_number)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE FARE (
    Flight_number NVARCHAR(15) NOT NULL,
    Fare_code NVARCHAR(15) NOT NULL,
    Amount DECIMAL(10,2) NOT NULL,
    Restrictions NVARCHAR(50),
    CONSTRAINT PRIMARY KEY
        Pk_Fare (Flight_number, Fare_code),
    CONSTRAINT FOREIGN KEY
        Fk_Fare_Flight (Flight_number)
    REFERENCES
        FLIGHT (Flight_number)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE AIRPLANE_TYPE (
    Airplane_type_name NVARCHAR(25) PRIMARY KEY,
    Max_seats INTEGER NOT NULL,
    Company NVARCHAR(25)
);

CREATE TABLE AIRPLANE (
    Airplane_id NVARCHAR(25) PRIMARY KEY,
    Total_number_of_seats INTEGER NOT NULL,
    Airplane_type NVARCHAR(25) NOT NULL,
    CONSTRAINT FOREIGN KEY
        Fk_Airplane_Airplane_Type (Airplane_type)
    REFERENCES
        AIRPLANE_TYPE (Airplane_type_name)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE LEG_INSTANCE (
    Flight_number NVARCHAR(15) NOT NULL,
    Leg_number INTEGER NOT NULL,
    Leg_instance_date Date NOT NULL,
    Number_of_available_seats INTEGER,
    Airplane_id NVARCHAR(25) NOT NULL,
    Departure_airport_code NVARCHAR(10) NOT NULL,
    Departure_time TIME NOT NULL,
    Arrival_airport_code NVARCHAR(10) NOT NULL,
    Arrival_time TIME NOT NULL,
    CONSTRAINT PRIMARY KEY
        Pk_Leg_Instance (Flight_number, Leg_number, Leg_instance_date),
    CONSTRAINT FOREIGN KEY
        Fk_Leg_Instance_Flight_Leg (Flight_number, Leg_number)
    REFERENCES
        FLIGHT_LEG (Flight_number, Leg_number)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY
        Fk_Leg_Instance_Airplane (Airplane_id)
    REFERENCES
        AIRPLANE (Airplane_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE CAN_LAND (
    Airplane_type_name NVARCHAR(25) NOT NULL,
    Airport_code NVARCHAR(10) NOT NULL,
    CONSTRAINT PRIMARY KEY
        Pk_Can_Land (Airplane_type_name, Airport_code),
    CONSTRAINT FOREIGN KEY
        Fk_Can_Land_Airplane_Type (Airplane_type_name)
    REFERENCES
        AIRPLANE_TYPE (Airplane_type_name)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY
        Fk_Can_Land_Airport (Airport_code)
    REFERENCES
        AIRPORT (Airport_code)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE SEAT_RESERVATION (
    Flight_number NVARCHAR(15) NOT NULL,
    Leg_number INTEGER NOT NULL,
    Leg_instance_date Date NOT NULL,
    Seat_number INTEGER NOT NULL,
    Customer_name NVARCHAR(50) NOT NULL,
    Customer_phone NVARCHAR(20),
    CONSTRAINT PRIMARY KEY
        Pk_Seat_Reservation (Flight_number, Leg_number, Leg_instance_date, Seat_number),
    CONSTRAINT FOREIGN KEY
        Fk_Seat_Reservation_Leg_Instance (Flight_number, Leg_number, Leg_instance_date)
    REFERENCES
        LEG_INSTANCE (Flight_number, Leg_number, Leg_instance_date)        
);
