CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    order_date DATETIME,
    total_amount DOUBLE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

