create table Employees
(
  id int not null,
  age int not null,
  first varchar (255),
  last varchar (255),
  UNIQUE KEY (id)
);

INSERT INTO Employees VALUES (100, 8, 'Heinz', 'Karl');
INSERT INTO Employees VALUES (101, 25, 'Blumenkohl', 'Isa');
INSERT INTO Employees VALUES (102, 30, 'Erbse', 'Bruno');
INSERT INTO Employees VALUES (103, 28, 'Rose', 'Imke');
