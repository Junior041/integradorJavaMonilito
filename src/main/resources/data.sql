INSERT INTO Store (name, responsible_Person, street, zip_Code, neighborhood, city, date_Insert) VALUES
('Junior Cars','Ismael Junior', 'Rua daniel Barni, n 40', '8835490', 'Souza Cruz', 'Brusque',  CURRENT_TIMESTAMP);

INSERT INTO Category (category, date_Insert) VALUES ('Sedan', CURRENT_TIMESTAMP);
INSERT INTO Category (category, date_Insert) VALUES ('SUV', CURRENT_TIMESTAMP);

INSERT INTO Brand (brand, date_Insert) VALUES ('Toyota', CURRENT_TIMESTAMP);
INSERT INTO Brand (brand, date_Insert) VALUES ('Honda', CURRENT_TIMESTAMP);

INSERT INTO Vehicle (category_id, brand_id, price, description, date_Insert, store_id)
VALUES ((SELECT Id FROM Category WHERE category = 'Sedan'), (SELECT id FROM Brand WHERE brand = 'Toyota'), '25000', 'Toyota Sedan', CURRENT_TIMESTAMP, 1);

INSERT INTO Vehicle (category_id, brand_id, price, description, date_Insert, store_id)
VALUES ((SELECT Id FROM Category WHERE category = 'SUV'), (SELECT id FROM Brand WHERE brand = 'Honda'), '30000', 'Honda SUV', CURRENT_TIMESTAMP, 1);
