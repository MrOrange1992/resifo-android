DROP TABLE IF EXISTS residence;
CREATE TABLE residence
(
    id INT PRIMARY KEY NOT NULL,
    street TEXT NOT NULL,
    house INT NOT NULL,
    stair INT NOT NULL,
    door INT NOT NULL,
    plz INT NOT NULL,
    city TEXT NOT NULL,
    state TEXT NOT NULL
);
