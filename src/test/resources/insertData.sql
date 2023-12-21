INSERT INTO testdb.product (product_code, product_name, category, price, quantity, date_added)
    VALUES
        ("P2","Prod2", "Cat2", "132.2", 12, CURRENT_DATE + INTERVAL 1 DAY),
        ("P3","Prod3", "Cat3", "12.2", 7, CURRENT_DATE),
        ("P7","Prod7", "Cat2", "0", 14, CURRENT_DATE),
        ("P8","Prod8", "Cat2", "70", 14, CURRENT_DATE - INTERVAL 2 DAY);