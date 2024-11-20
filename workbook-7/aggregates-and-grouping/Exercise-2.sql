USE northwind;
-- Question 1: How many suppliers: 29
SELECT COUNT(SupplierID)
FROM suppliers;

-- Question 2: Sum of all salaries: 20362.929931640625
SELECT SUM(Salary)
FROM employees;

-- Question 3: Cheapest product: Geitost

SELECT UnitPrice, productname
FROM products
ORDER BY UnitPrice;

-- Question 4: Avg price: 28.86636364

SELECT AVG(UnitPRice)
FROM products;

-- Question 5: Most Expensive: Cte de Blayne
SELECT UnitPrice, productname
FROM products
ORDER BY UnitPrice desc;

-- Question 6: Distinct suppliers: 29, 1-29

SELECT supplierID, companyname 
FROM suppliers
ORDER BY supplierID;

-- Question 7:
-- Category IDs:
SELECT CategoryID, CategoryName
FROM categories;

-- Avg prices:
SELECT CategoryID, avg(unitprice) AS average_price
FROM products
GROUP BY categoryid
ORDER BY categoryid;

-- Question 8: 

SELECT SupplierID
FROM products
GROUP BY supplierID
HAVING COUNT(*) > 4;

-- 5
SELECT count(supplierID)
FROM products
WHERE SupplierID = 7;

-- 5
SELECT count(supplierID)
FROM products
WHERE SupplierID = 12;

-- Question 9:
SELECT productid, productname, UnitPrice * UnitsInStock AS total_value
FROM products
order by total_value desc, ProductName; 