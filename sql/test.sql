select * from users;
SELECT * from texts;
SELECT * from users_texts;
SELECT author, title 
from texts
order BY title;

SELECT user_id, username, email
FROM users
WHERE username = 'Ari' AND password = '1234'; 


	insert into users (username, email, password) values
	('Pippo', 'pippo@pippoloandia.it', '46987');

INSERT INTO entries (entry_word, description, class_id, user_id) VALUES ('Cane', 'Un cane è un animale.', (SELECT class_id FROM gramm_class WHERE class_entry = 'nome'), (SELECT user_id FROM users WHERE username = 'Ari'));


SELECT text_id, fragment, author, title
            from texts
            where contains(fragment, 'a');

SELECT *
FROM texts;

INSERT INTO entries (entry_word, description, class_id, user_id)
VALUES ('Prova', 'prova', 4, 5);

SELECT *
FROM entries;