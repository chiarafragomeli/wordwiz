select * from users;
SELECT * from texts;
SELECT * from users_texts;

SELECT user_id, first_name, last_name, username
FROM users
WHERE username = 'Ari' AND password = '1234'; 