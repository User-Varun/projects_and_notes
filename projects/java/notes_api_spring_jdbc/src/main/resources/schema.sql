CREATE TABLE notes(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title varchar(255),
    description varchar(1000)
);

ALTER TABLE notes ADD COLUMN deleted BOOLEAN DEFAULT FALSE;