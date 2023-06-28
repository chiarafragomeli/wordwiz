drop table if exists entries;
drop table if exists users_texts;
drop table if exists messages;
drop table if exists users;
drop table if exists texts;
drop table if exists gramm_class;


create TABLE texts (
    text_id serial primary key,
    fragment varchar (10000),
    author varchar(100),
    title varchar(100)
);


INSERT into texts(fragment,author,title) values
    ('La speranza, tuttavia, s’era annidata ormai dentro di me come un parassita, che non lascia volentieri il suo nido.','Elsa Morante','L’isola di Arturo'),
    ('Una di quelle mattine Ida, con due grosse sporte al braccio, tornava dalla spesa tenendo per mano Useppe.','Elsa Morante','La storia'),
    ('Intanto, era cominciato il suono delle sirene.','Dacia Maraini','Bagheria');


create table users(
  user_id serial primary key,
  username varchar (20) unique not null,
  email varchar (20) unique not null,
  password varchar(20) not null
);


insert into users (username, email, password) values 
  ('admin', 'admin@wordwiz.com', 'password'),
  ('Ari', 'ari@gmail.com', '1234'),
  ('Ri', 'ri@gmail.com', '5678'),
  ('Flora', 'flora@gmail.com', '9101112');


CREATE table users_texts (
  text_id INTEGER,
  user_id INTEGER,
  foreign key (text_id) references texts (text_id),
  foreign key (user_id) references users (user_id)
);

INSERT into users_texts (text_id,user_id) values
  (1,3),
  (2,3),
  (1,1);


CREATE table gramm_class (
	class_id serial primary key,
	name varchar (20)
	);


INSERT into gramm_class (name) values
	('nome'),
	('aggettivo'),
	('verbo'),
	('avverbio'),
	('pronome'),
	('articolo'),
	('preposizione'),
	('congiunzione'),
	('interiezione');
	
	
CREATE table entries (
	entry_id serial primary key,
	entry_word varchar (50) not null,
	description varchar(10000),
	class_id integer,
	user_id integer,
	foreign key (class_id) references gramm_class (class_id),
	foreign key (user_id) references users (user_id)
	);

  CREATE table messages (
	message_id serial primary key,
	message varchar (10000) not null,
  time timestamp not null DEFAULT CURRENT_TIMESTAMP,
  sender_id integer not null,
  recipient_id integer not null,
	foreign key (sender_id) references users (user_id),
	foreign key (recipient_id) references users (user_id)
	);

  insert into messages (message, time, sender_id, recipient_id) values 
 ('login problems', '2023-05-12 12:03:00', 2, 1),
 ('new entry problems', '2023-05-13 09:40:00', 3, 1);

  insert into messages (message, sender_id, recipient_id) values 
  ('forgot password', 3, 1),
  ('I would like to send messages to other users', 4, 1);