USE northwind;

-- Question 1:

SELECT products.productid, products.ProductName, products.UnitPrice, categories.CategoryID, categories.CategoryName
FROM products
INNER JOIN categories
on products.CategoryID = categories.CategoryID
ORDER BY categories.CategoryName, products.productname;

-- Question 2:

Select products.ProductID, products.ProductName, products.SupplierID, products.UnitPrice, suppliers.CompanyName
FROM products
INNER JOIN suppliers
ON products.SupplierID = suppliers.SupplierID
WHERE UnitPrice > 75
ORDER BY productname;

-- Question 3:

SELECT products.ProductID, products.ProductName, products.UnitPrice, products.CategoryID, suppliers.CompanyName 
FROM products
INNER JOIN suppliers
ON products.SupplierID = suppliers.SupplierID
ORDER BY products.ProductName;

-- Question 4: 

SELECT products.ProductName, categories.CategoryName
FROM products
INNER JOIN categories
ON products.CategoryID = categories.CategoryID;

-- Question 5:
SELECT orders.OrderID, orders.OrderDate, orders.ShipAddress, orders.ShipName, products.ProductName, orders.
FROM orders
INNER JOIN suppliers
ON orders.SupplierID = suppliers.SupplierID
INNER JOIN products
ON products.SupplierID = suppliers.SupplierID
where products.ProductName = "Sasquatch Ale";