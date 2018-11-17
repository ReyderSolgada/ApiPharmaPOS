USE Pharmacy;

CREATE TRIGGER TG_UPDATE_STOCK
	AFTER INSERT ON SalesOrderItem
	FOR EACH ROW
	UPDATE Product SET Product.Stock = Product.Stock - NEW.Quantiy
	WHERE Product.ProductId = NEW.ProductId;
  
INSERT INTO Supplier (Name, Address, Email, Phone) VALUES 
('Bayer1','Av.test1','Email test1','594984984'),
('Bayer2','Av.test2','Email test2','894895217'),
('Bayer3','Av.test3','Email test3','748798418'),
('Bayer4','Av.test4','Email test4','848189848'),
('Bayer5','Av.test5','Email test5','489489478'),
('Bayer6','Av.test6','Email test6','198789923'),
('Bayer7','Av.test7','Email test7','397456789');

SELECT 
    *
FROM
    Supplier;

 INSERT INTO Category (Name) VALUES 
('Analgésicos'),
('Antiinflamatorios'),
('Aines'),
('Antibióticos'),
('Amoxicilina'),
('Cefalosporina'),
('Eritromicina'),
('Quinolona'),
('Ampicilina'),
('Vancomicina'),
('Azitromicina'),
('Penicilinas');

SELECT 
    *
FROM
    Category;
    
 INSERT INTO JobTitle (Name) VALUES 
('Cajero'),
('Vendedor'),
('Administrador'),
('Almacenero');

SELECT 
    *
FROM
    JobTitle;
    
 INSERT INTO District (Name) VALUES 
('Callao'),
('Bellavista'),	
('Carmen de La Legua'),	
('La Perla'),	
('La Punta'),	
('Mi Perú'),
('Ventanilla'),
('Lima'),	
('Ancón'),	
('Ate'),	
('Barranco'),	
('Breña'),	
('Carabayllo'),	
('Cieneguilla'),	
('Chaclacayo'),	
('Chorrillos'),	
('Comas'),	
('El Agustino'),	
('Independencia'),	
('Jesús María'),
('La Molina'),
('La Victoria'),	
('Lince'),
('Los Olivos'),	
('Lurigancho'),	
('Lurín'),
('Magdalena del Mar'),
('Miraflores'),
('Pachacámac'),	
('Pucusana'),
('Pueblo Libre'),
('Puente Piedra'),	
('Punta Hermosa'),
('Punta Negra'),
('Rímac'),	
('San Bartolo'),
('San Borja'),	
('San Isidro'),
('San Juan de Lurigancho'),	
('San Juan de Miraflores'),	
('San Luis'),
('San Martín de Porres'),	
('San Miguel'),	
('Santa Anita'),	
('Santa María del Mar'),
('Santa Rosa'),
('Santiago de Surco'),
('Surquillo'),
('Villa El Salvador'),
('Villa María del Triunfo');

SELECT 
    *
FROM
    District;

 INSERT INTO Customer (FirstName, MiddleName, LastName, Sex, RUC, DNI, Address, DistrictId, Type) VALUES 
('Renato','John','Suarez','M','12345678125','12345678','Av. Lima 4898',1,'N'),
('Emilio','Luis','Paredes','M','22345612578','22345678','Av. Lima 7898',2,'J'),
('Estrella','Jimena','Loza','F','32341255678','32345678','Av. Lima 1534',3,'N'),
('Luis','Victor','Durán','M','42345612578','42345678','Av. Lima 1245',4,'N'),
('Katia','Paola','Vásques','F','52345125678','52345678','Av. Lima 8979',5,'N'),
('Judith','Mercedes','Armando','F','62312545678','62345678','Av. Lima 1984',6,'N'),
('Hector','Patroclo','Tirado','M','72312545678','72345678','Av. Lima 1568',7,'N'),
('Mauricio','Walter','Garcia','M','82345125678','82345678','Av. Lima 2848',8,'N');

SELECT 
    *
FROM
    Customer;

 INSERT INTO Employee (FirstName, MiddleName, LastName, DNI, Sex, Phone, Address, DistrictId, Salary, JobTitleId) VALUES 
('Lucia','Miranda','Torres','991120078','F','48977977','Av. Brasil 4898',12,1500.00,1),
('Mercedes','Violeta','Espinoza','991210077','F','4898977','Av. Brasil 4898',12,1600.00,2),
('Raúl','Pedro','López','991542077','M','48148977','Av. Brasil 4898',12,1350.00,3),
('Wendy','Bárbara','Salazar','991298977','F','48216977','Av. Brasil 4898',12,1400.00,4),
('Patricio','Marco','Díaz','991898889','M','48914977','Av. Brasil 4898',12,1400.00,2);

SELECT 
    *
FROM
    Employee;

 INSERT INTO Laboratory(Name) VALUES
('Lab 1'),
('Lab 2'),
('Lab 3'),
('Lab 4'),
('Lab 5'),
('Lab 6'),
('Lab 7'),
('Lab 8'),
('Lab 9'),
('Lab 10');

SELECT 
    *
FROM
    Laboratory;
    
 INSERT INTO Product (Description, Price, Stock, CategoryId, SupplierId, LaboratoryId) VALUES 
('Asgesic 10mg',2,80,11,5,10),
('Asgesic 20mg',3.5,95,11,1,9),
('Asgesic 30mg',5,74,7,2,8),
('Asgesic 60mg',8.50,65,12,4,7),
('Dolalgial',3.20,76,9,5,6),
('Naclodil',5.00,43,8,6,5),
('Dolostop 20mg',6.00,54,10,6,4),
('Aspirina',1.00,99,7,1,4),
('Cafiaspirina',1.00,65,5,3,5),
('Dolpiret cmp',2.00,54,5,3,8),
('Dolpiret ssp',3.00,64,4,3,3),
('Dontoflamon cmp',2.50,3,10,3,2),
('Dontoflamon ssp',3.50,5,10,3,2),
('Ibuflamar',6.50,75,1,2,1),
('Piredol',5.00,48,1,1,5),
('Flamadin',3.00,46,2,1,8),
('Diprofen cmp',6.00,84,2,2,8),
('Diprofen ssp',7.50,46,1,1,1),
('Ibupronal forte',10.00,64,4,1,5),
('Ceflex 200mg',4.50,76,8,4,2);

SELECT 
    *
FROM
    Product;
    
    /*
 INSERT INTO User (State, Email, Password) VALUES
(TRUE,'user1@mail.com','$2a$10$KssILxWNR6k62B7yiX0GAe2Q7wwHlrzhF3LqtVvpyvHZf0MwvNfV1'),
(TRUE,'user2@mail.com','$2a$10$KssILxWNR6k62B7yQX0GAe2Q7wwHlrzhF3LqtVvpyvHZf0MwvNfV2'),
(FALSE,'user3@mail.com','$2a$10$KssILxWNR6k62B7yDX0GAe2Q7wwHlrzhF3LqtVvpyvHZf0MwvNfV3'),
(TRUE,'user4@mail.com','$2a$10$KssILxWNR6k62B7yFX0GAe2Q7wwHlrzhF3LqtVvpyvHZf0MwvNfV4'),
(TRUE,'user5@mail.com','$2a$10$KssILxWNR6k62B7yGX0GAe2Q7wwHlrzhF3LqtVvpyvHZf0MwvNfV5');
    */
SELECT 
    *
FROM
    User;


 INSERT INTO SalesOrder (SalesOrderId, Serial, CustomerId, EmployeeId, State) VALUES
(00001,'E001',1,3,'PAGADO'),
(00002,'E001',2,2,'ANULADO'),
(00003,'E001',3,4,'PAGADO'),
(00004,'E001',NULL,1,'PENDIENTE');

SELECT 
    *
FROM
    SalesOrder;

 INSERT INTO SalesOrderItem (SalesOrderItemId, ProductId, Quantiy, UnitPrice) VALUES
(00001,1,7,6.30),
(00001,2,3,3.40),
(00001,3,6,5.50),
(00003,4,7,5.50),
(00002,5,10,1.50),
(00002,6,4,5.30),
(00003,7,6,3.50);

SELECT 
    *
FROM
    SalesOrderItem;
