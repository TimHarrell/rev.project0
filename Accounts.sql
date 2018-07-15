DROP TABLE ACCOUNTS;
CREATE TABLE ACCOUNTS (
    userID VARCHAR2(20) PRIMARY KEY,
    firstname VARCHAR2(20),
    lastname VARCHAR2(30),
    passwrd VARCHAR2(20)
);


INSERT INTO ACCOUNTS (userID, firstname, lastname, passwrd) VALUES ('theDude', 'Samuel', 'Clemens', 'TomSawyer');
SELECT * FROM ACCOUNTS;

COMMIT;