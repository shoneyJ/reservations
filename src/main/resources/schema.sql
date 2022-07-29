CREATE TABLE MYHOTEL(
  HOTEL_ID INT PRIMARY KEY,
  HOTEL_NAME VARCHAR(16) NOT NULL,
  HOTEL_SIZE INT NOT NULL
);


CREATE TABLE RESERVATION(
  RESERVATION_ID BIGSERIAL PRIMARY KEY,
  ROOM_NUMBER INT NOT NULL,
  START_DAY INT NOT NULL,
  END_DAY INT NOT NULL
);