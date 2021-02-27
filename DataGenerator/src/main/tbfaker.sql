CREATE TABLE fakerTB(
   id VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   firstname VARCHAR(255) NOT NULL,
   surname VARCHAR(255) NOT NULL,
   phnumber INT(20) NOT NULL,
   address TEXT(500) NOT NULL,
   PRIMARY KEY ( id )
);
INSERT INTO fakerTB(id, email, firstname, surname, phnumber, address) VALUES (populatedatabase.id);