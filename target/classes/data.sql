INSERT INTO ROLES(id,name)VALUES(1,'ROLE_USER');
INSERT INTO ROLES(id,name)VALUES(2,'ROLE_ROOT');
INSERT INTO ROLES(id,name)VALUES(3,'ROLE_ADMIN');


INSERT INTO USERS(id, email, enabled, password, username) values (1, 'martinez@alumno.uacm.edu.mx', 'true', '$2a$10$dRwKHIXpoG020RU9tn6JHeBUHFNGTNrVtyROBHwjCX7PVo2OSKJ5m', 'martinez');
INSERT INTO USER_ROLES(user_id, role_id) values (1, 1);
INSERT INTO USER_ROLES(user_id, role_id) values (1, 2);
INSERT INTO USER_ROLES(user_id, role_id) values (1, 3);
INSERT INTO TOKEN(id, expiry_date, token, user_id) values (1, null, '15bcd698-a41c-4f67-9b65-49fa93f09850', 1);
