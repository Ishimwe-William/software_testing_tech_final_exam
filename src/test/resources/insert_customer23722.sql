

INSERT INTO testdb.warehouse (customerid, first_name, last_name, email, phone_number, date_of_birth)
    VALUES
        ('Cust2','Bunsen', 'plus', 'customer2@gmail.com', '0929423434', CURRENT_DATE - INTERVAL 10 YEAR ),
        ('Cust3','Bunsen', 'plus', 'customer3@gmail.com', '0929423434', CURRENT_DATE - INTERVAL 20 YEAR ),
        ('Cust4','Bunsen', 'plus', 'customer4@gmail.com', '0929423434', CURRENT_DATE - INTERVAL 14 YEAR ),
        ('Cust5','Bunsen', 'plus', 'customer5@gmail.com', '0929423434', CURRENT_DATE - INTERVAL 60 YEAR ),
        ('Cust7','Bunsen', 'plus', 'customer7@gmail.com', '0929423434', CURRENT_DATE - INTERVAL 16 YEAR );