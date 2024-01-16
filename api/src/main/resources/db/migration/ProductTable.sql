CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE,
    stock_quantity INT,
    created_at DATETIME,
    updated_at DATETIME
);
