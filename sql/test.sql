select * from users;
SELECT * from texts;
SELECT * from users_texts;

SELECT user_id, username, email
FROM users
WHERE username = 'Ari' AND password = '1234'; 


	insert into users (username, email, password) values
	('Pippo', 'pippo@pippoloandia.it', '46987');
	