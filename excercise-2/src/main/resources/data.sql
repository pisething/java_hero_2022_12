-- By default, the data.sql script executes before Hibernate initialization.
-- This aligns the script-based initialization with other database migration tools such as Flyway and Liquibase.

insert into subject (id, name) values
(1, 'Mathematics'),
(2, 'Physics'),
(3, 'Chemistry'),
(4, 'Khmer'),
(5, 'English');

insert into student (name, gender, dob) values
('SOK San', 'MALE', '1999-10-10'),
('MEAS Sovan', 'MALE', '2000-11-30'),
('CHAN Thida', 'FEMALE', '1998-07-10'),
('LIM Huy', 'FEMALE', '1999-09-15'),
('KAN Kakada', 'FEMALE', '2000-01-22'),
('LOK Veasna', 'MALE', '2001-04-16');
