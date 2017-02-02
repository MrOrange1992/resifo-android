DROP TABLE IF EXISTS person;
CREATE TABLE person
(
    id INT PRIMARY KEY,
    firstname TEXT NOT NULL,
    lastname TEXT NOT NULL,
    akaGrade TEXT,
    birthdate DATE NOT NULL,
    gender TEXT NOT NULL,
    religion TEXT,
    birthplace TEXT NOT NULL,
    maritalstatus TEXT NOT NULL,
    nationality TEXT NOT NULL,
    residence INT CONSTRAINT fk_residence REFERENCES residence (id) NOT NULL,
    zmr DECIMAL (0),
    docType TEXT,
    docDate DATE,
    docNumber INT,
    docState TEXT
);
