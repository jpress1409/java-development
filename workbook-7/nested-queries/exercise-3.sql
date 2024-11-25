-- Question 1:

SELECT productName
FROM products
where unitPrice = (
	SELECT MAX(unitprice)
    FROM products
    );
    
-- Question 2: 

SELECT OrderID, ShipName, ORders.ShipAddress
FROM Orders
where ShipVia =(
	SELECT ShipperID
    FROM Shippers
    WHERE CompanyName = "Federal Shipping");

-- Question 3: 

SELECT OrderId
FROM "Order Details"
WHERE ProductID =(
	ProductID);
    
SELECT firstname, lastname
FROM employees
where employeeID = (
	SELECT EmployeeID);
    
SELECT companyname
FROM Customers
where customerID = (
	SELECT CustomerID
    FROM orders
    WHERE OrderID = )
    
