INSERT INTO tv (name, manufacture_country, manufacturer, possibility_ordering_online, payment_by_instalments)
VALUES ('Sber', 'Беларусь', 'Витязь', true, true),
        ('Samsung', 'Россия', 'Samsung Electronics', true, true),
       ('Haier', 'Россия', 'Хайер Фридж РУС', true, true);

INSERT INTO tvmodel (name, serial_number, color, length, width, thickness, price, availability, category, technology,
    tv_id)
VALUES ('SDX-43U4128', 'Line S', 'Черный', 59.8, 95.7, 8.4, 15799, true, 'Цифровой', 'LED', 1),
       ('SDX-43U4130', 'Line S', 'Черный', 66.4, 96, 9, 68000, false, 'Цифровой', 'LED', 1),
       ('Smart TV S2', 'Smart TV S2', 'Черный', 59.8, 95.7, 8.4, 29999, true, 'Цифровой', 'LED', 2),
       ('SDX-43U4128', 'Smart TV S2', 'Черный', 59.8, 95.7, 8.4, 68000, true, 'Цифровой', 'LED', 2),
       ('Smart TV S2', 'Haier S2', 'Черный', 61, 96.1, 23, 44999, false, 'Цифровой', 'LED', 3),
       ('Smart TV S3', 'Haier S2', 'Черный', 59.8, 95.7, 8.4, 78999, true, 'Цифровой', 'LED', 3);
