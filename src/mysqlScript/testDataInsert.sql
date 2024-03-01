-- Inserting sample data into foodMenu table
use orderingsystem;

INSERT INTO foodMenu (foodName, foodPrice) VALUES
('Burger', 9.99),
('Pizza', 12.50),
('Pasta', 8.75),
('Salad', 6.99);

-- Inserting sample data into drinkMenu table
INSERT INTO drinkMenu (drinkName, drinkPrice) VALUES
('Cola', 1.99),
('Orange Juice', 2.50),
('Coffee', 2.25),
('Iced Tea', 1.75);

-- Inserting sample data into customers table
INSERT INTO customers (telephoneNumber, address, postCodes, notes) VALUES
('123-456-7890', '123 Main St', '12345', 'Regular customer'),
('987-654-3210', '456 Oak St', '54321', 'VIP customer');

-- Inserting sample data into orderHistory table
INSERT INTO orderHistory (customerID, orderDate, orderTime, totalAmount, itemsOrdered, notes) VALUES
(1, '2024-03-01', '12:30:00', 18.98, 'Burger, Cola', 'Lunch order'),
(2, '2024-03-01', '18:45:00', 28.50, 'Pizza, Orange Juice, Coffee', 'Dinner order');


-- Insert a login detail with an encrypted password
INSERT INTO loginDetails (loginUsername, loginPassword)
VALUES ('user1', PBKDF2_HMAC_SHA256('qq529879477', 'your_salt_here', 10000, 32)); -- Use a unique salt per password

-- Retrieve and decrypt the password
SELECT
    loginUsername,
    AES_DECRYPT(loginPassword, UNHEX(SHA2(CONCAT('salt', 'password1'), 256))) AS decryptedPassword
FROM loginDetails;loginUsername