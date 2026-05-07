CREATE DATABASE IF NOT EXISTS ParaBankATF;
USE ParaBankATF;

CREATE TABLE IF NOT EXISTS register_data (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    phone VARCHAR(20),
    ssn VARCHAR(20),
    password VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS bill_pay_data (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             payee_name VARCHAR(100),
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    phone VARCHAR(20),
    account_number VARCHAR(20),
    verify_account VARCHAR(20),
    amount VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS loan_data (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         loan_amount VARCHAR(20),
    down_payment VARCHAR(20),
    approved_status VARCHAR(20),
    denied_status VARCHAR(20)
    );

INSERT INTO register_data (first_name, last_name, address, city, state, zip_code, phone, ssn, password)
VALUES ('Oana', 'Topan', 'Republicii', 'Baia Mare', 'Romania', '123456', '0722000000', '123-45-678', 'Parola123!');

INSERT INTO bill_pay_data (payee_name, address, city, state, zip_code, phone, account_number, verify_account, amount)
VALUES ('Electrica SA', 'Str. Energiei 10', 'Baia Mare', 'Maramures', '430001', '0744111222', '12345', '12345', '50');

INSERT INTO loan_data (loan_amount, down_payment, approved_status, denied_status)
VALUES ('100', '10', 'Approved', 'Denied');