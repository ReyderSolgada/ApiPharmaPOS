DROP SCHEMA IF EXISTS Pharmacy;
CREATE SCHEMA Pharmacy;
USE Pharmacy;

CREATE TABLE IF NOT EXISTS Supplier (
    SupplierId SMALLINT UNSIGNED AUTO_INCREMENT,
    Name VARCHAR(48) NOT NULL,
    Address VARCHAR(64) NOT NULL,
    Email VARCHAR(64) NOT NULL,
    Phone VARCHAR(15) NOT NULL,
    PRIMARY KEY (SupplierId)
);
	
CREATE TABLE IF NOT EXISTS Category (
    CategoryId SMALLINT UNSIGNED AUTO_INCREMENT,
    Name VARCHAR(24) NOT NULL,
    PRIMARY KEY (CategoryId)
);

CREATE TABLE IF NOT EXISTS District (
    DistrictId TINYINT UNSIGNED AUTO_INCREMENT,
    Name VARCHAR(48) NOT NULL,
    PRIMARY KEY (DistrictId)
);

CREATE TABLE IF NOT EXISTS Customer (
    CustomerId MEDIUMINT UNSIGNED AUTO_INCREMENT,
    FirstName VARCHAR(24) NULL,
    MiddleName VARCHAR(24) NULL,
    LastName VARCHAR(24) NULL,
    Sex ENUM('M', 'F') NULL,
    RUC CHAR(11) UNIQUE NULL,
    DNI CHAR(11) UNIQUE NOT NULL,
    Address VARCHAR(64) NULL,
    DistrictId TINYINT UNSIGNED,
    RegisterDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Type ENUM('J', 'N') NOT NULL,
    PRIMARY KEY (CustomerId),
    CONSTRAINT FK_Customer_District FOREIGN KEY (DistrictId)
        REFERENCES District (DistrictId),
    INDEX FK_Customer_District_Idx (DistrictId ASC)
);

CREATE TABLE IF NOT EXISTS JobTitle (
    JobTitleId TINYINT UNSIGNED AUTO_INCREMENT,
    Name VARCHAR(24) UNIQUE NOT NULL,
    PRIMARY KEY (JobTitleId)
);

CREATE TABLE IF NOT EXISTS User (
    UserId SMALLINT UNSIGNED AUTO_INCREMENT,
    Username VARCHAR(32) NOT NULL,
    Password VARCHAR(60) NOT NULL,
	Level ENUM('ADMINISTRADOR', 'VENDEDOR', 'ALMACENERO'),
    PRIMARY KEY (UserId)
);



CREATE TABLE IF NOT EXISTS Employee (
    EmployeeId SMALLINT UNSIGNED AUTO_INCREMENT,
    FirstName VARCHAR(24) NOT NULL,
    MiddleName VARCHAR(24) NULL,
    LastName VARCHAR(24) NOT NULL,
    HireDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    DNI CHAR(9) UNIQUE NOT NULL,
    Sex ENUM('M', 'F') NOT NULL,
    Phone CHAR(9) NULL,
    Address VARCHAR(64) NULL,
    DistrictId TINYINT UNSIGNED,
    Salary DECIMAL(6 , 2 ) NOT NULL,
    JobTitleId TINYINT UNSIGNED NOT NULL,
    UserId SMALLINT UNSIGNED NULL,
    PRIMARY KEY (EmployeeId),
    CONSTRAINT FK_Employee_JobTitle FOREIGN KEY (JobTitleId)
        REFERENCES JobTitle (JobTitleId),
    INDEX FK_Employee_JobTitle_Idx (JobTitleId ASC),
    CONSTRAINT FK_Employee_District FOREIGN KEY (DistrictId)
        REFERENCES District (DistrictId),
    INDEX FK_Employee_District_Idx (DistrictId ASC),
	CONSTRAINT FK_Employee_User FOREIGN KEY (UserId)
        REFERENCES User (UserId),
    INDEX FK_Employee_User_Idx (UserId ASC)
);

CREATE TABLE IF NOT EXISTS Laboratory (
    LaboratoryId SMALLINT UNSIGNED AUTO_INCREMENT,
    Name VARCHAR(48) UNIQUE NOT NULL,
    PRIMARY KEY (LaboratoryId)
);

CREATE TABLE IF NOT EXISTS Product (
    ProductId INT UNSIGNED AUTO_INCREMENT,
    Description VARCHAR(100) NOT NULL,
    Price DECIMAL(5 , 2 ) NOT NULL,
    Stock MEDIUMINT UNSIGNED NOT NULL,
    CategoryId SMALLINT UNSIGNED NOT NULL,
    SupplierId SMALLINT UNSIGNED NOT NULL,
    LaboratoryId SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (ProductId),
    CONSTRAINT FK_Product_Supplier FOREIGN KEY (SupplierId)
        REFERENCES Supplier (SupplierId),
    INDEX FK_Producto_Supplier_Idx (SupplierId ASC),
    CONSTRAINT FK_Product_Category FOREIGN KEY (CategoryId)
        REFERENCES Category (CategoryId),
    INDEX FK_Product_Category_Idx (CategoryId ASC),
    CONSTRAINT FK_Product_Laboratory FOREIGN KEY (LaboratoryId)
        REFERENCES Laboratory (LaboratoryId),
    INDEX FK_Product_Laboratory_Idx (LaboratoryId ASC)
);
  
CREATE TABLE IF NOT EXISTS SalesOrder (
    SalesOrderId INT UNSIGNED,
    Serial CHAR(4) NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    CustomerId MEDIUMINT UNSIGNED NULL,
    EmployeeId SMALLINT UNSIGNED NOT NULL,
    State ENUM('PAGADO', 'ANULADO', 'PENDIENTE') NOT NULL,
    PRIMARY KEY (SalesOrderId),
    CONSTRAINT FK_SalesOrder_Customer FOREIGN KEY (CustomerId)
        REFERENCES Customer (CustomerId),
    INDEX FK_SalesOrder_Customer_Idx (CustomerId ASC),
    CONSTRAINT FK_SalesOrder_Employee FOREIGN KEY (EmployeeId)
        REFERENCES Employee (EmployeeId),
    INDEX FK_SalesOrder_Employee_Idx (EmployeeId ASC)
);

CREATE TABLE IF NOT EXISTS SalesOrderItem (
    SalesOrderItemId INT UNSIGNED,
    ProductId INT UNSIGNED NOT NULL,
    Quantiy INT UNSIGNED NOT NULL,
    UnitPrice DECIMAL(7 , 2 ) NOT NULL,
    PRIMARY KEY (SalesOrderItemId , ProductId),
    CONSTRAINT FK_SalesOrderItem_SalesOrder FOREIGN KEY (SalesOrderItemId)
        REFERENCES SalesOrder (SalesOrderId),
    CONSTRAINT FK_SalesOrderItemId_Product FOREIGN KEY (ProductId)
        REFERENCES Product (ProductId),
    INDEX FK_SalesOrderItem_Product_Idx (ProductId ASC)
);
