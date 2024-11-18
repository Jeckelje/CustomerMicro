-- Удаляем таблицу, если она существует
DROP TABLE IF EXISTS customers;

-- Создаем новую таблицу customers
CREATE TABLE customers (
                           id SERIAL PRIMARY KEY,
                           customer_name VARCHAR(100) NOT NULL,
                           legal_address VARCHAR(255) NOT NULL,
                           total_projects INTEGER NOT NULL DEFAULT 0,
                           completed_projects INTEGER NOT NULL DEFAULT 0
);

-- Вставляем 10 строк тестовых данных
INSERT INTO customers (customer_name, legal_address, total_projects, completed_projects) VALUES
                                                                                    ('Tech Solutions Inc.', '1234 Elm St, Springfield', 15, 10),
                                                                                    ('Future Vision', '5678 Oak St, Metropolis', 20, 18),
                                                                                    ('Global Innovations', '910 Maple Ave, Gotham', 25, 23),
                                                                                    ('Creative Minds', '321 Pine Rd, Star City', 5, 2),
                                                                                    ('NextGen Solutions', '213 Cedar Ln, Central City', 12, 8),
                                                                                    ('Skyline Systems', '415 Birch Blvd, Coast City', 30, 30),
                                                                                    ('InnoTech Co.', '678 Willow St, Smallville', 8, 4),
                                                                                    ('Alpha Dynamics', '810 Poplar Ave, Bludhaven', 10, 5),
                                                                                    ('Quantum Leap', '1350 Aspen Ct, Riverdale', 17, 16),
                                                                                    ('Blue Horizon', '456 Cedar St, National City', 22, 20);
