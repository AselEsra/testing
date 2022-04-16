INSERT INTO roles VALUES(1, 'USER', 'This user has access to the site only');
INSERT INTO roles VALUES(2, 'ADMIN', 'This user has access to do administrative work');
INSERT INTO roles VALUES(3,'SUPER_ADMIN','This user has access to do anything');

INSERT INTO users VALUES(1, 'aselesra', '12345');

INSERT INTO user_roles VALUES(1, 1);
INSERT INTO user_roles VALUES(1, 2);
INSERT INTO user_roles VALUES(1, 3);