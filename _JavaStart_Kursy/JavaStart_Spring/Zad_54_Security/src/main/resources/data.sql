INSERT INTO
    application_user(first_name, last_name, email, password)
VALUES
    -- superadmin@example.com / password: hard
    ('Jan', 'Kowalski', 'superadmin@example.com', '{bcrypt}$2a$10$0ov01uvgr.hLdc/oUHq9Jutf7TKZtf/L6TiiBTOSbmypdxrKeoonu'),
    -- john@example.com / password: johny
    ('John', 'Smith', 'john@example.com', '{MD5}{GyLInLoX03MajRVheXYIzg1fsn14SKMEM8TcyyBp//U=}5e5142cb3af6fa042ca66fe29b1b1b43'),
    -- lover@example.com / password: pass
    ('Lover', 'Big', 'big_lover@example.com', '{argon2}$argon2id$v=19$m=16384,t=2,p=1$jQvZNs3K2YQFk3rJcc9R2A$n+KdsDGVUAu7SPnwktvd+K7M4FVOFPCdScSmH4jScAk');

INSERT INTO
    user_role(name, description)
VALUES
    ('ADMIN', 'Ma dostêp do wszystkiego'),
    ('USER', 'Dostêp do odczytu');

INSERT INTO
    user_role(user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);