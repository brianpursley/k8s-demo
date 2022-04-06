INSERT INTO product (id, name, description, price)
VALUES (1, 'Product A', 'Description for Product A', 10.00)
ON CONFLICT DO NOTHING;

INSERT INTO product (id, name, description, price)
VALUES (2, 'Product B', 'Description for Product B', 15.00)
ON CONFLICT DO NOTHING;

INSERT INTO product (id, name, description, price)
VALUES (3, 'Product C', 'Description for Product C', 25.00)
ON CONFLICT DO NOTHING;

INSERT INTO product (id, name, description, price)
VALUES (4, 'Product D', 'Description for Product D', 50.00)
ON CONFLICT DO NOTHING;