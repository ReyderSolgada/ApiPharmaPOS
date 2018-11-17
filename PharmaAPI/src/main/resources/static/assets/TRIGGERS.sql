 USE Pharmacy;
 
 CREATE TRIGGER TG_UPDATE_STOCK
	AFTER INSERT ON SalesOrderItem
	FOR EACH ROW
		UPDATE Product SET Product.Stock = Product.Stock - NEW.Quantiy
        WHERE Product.ProductId = NEW.ProductId;
        
DELIMITER $$
CREATE TRIGGER TG_INSERT_USER
after insert ON employee 
FOR each row  
begin  
		IF (NEW.JobTitleId=2) OR (NEW.JobTitleId=1) then
		INSERT INTO User(EmployeeId,UserName,password) 
        VALUES (NEW.EmployeeId,NEW.MiddleName,concat(SUBSTRING(NEW.DNI,2,1),UPPER(SUBSTRING(NEW.LastName,-3,2)),SUBSTRING(NEW.DNI,-3,2),SUBSTRING(NEW.FirstName,3,2),NEW.JobTitleId));
        END IF;
end; $$