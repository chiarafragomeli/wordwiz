drop table if exists users_texts;
drop table if exists users;
drop table if exists texts;

create TABLE texts (
    text_id serial primary key,
    fragment varchar (10000),
    author varchar(100),
    title varchar(100)
);

begin;
INSERT into texts(fragment,author,title) values
    ('La speranza, tuttavia, s’era annidata ormai dentro di me come un parassita, che non lascia volentieri il suo nido.','Elsa Morante','L’isola di Arturo'),
    ('Una di quelle mattine Ida, con due grosse sporte al braccio, tornava dalla spesa tenendo per mano Useppe.','Elsa Morante','La storia'),
    ('Intanto, era cominciato il suono delle sirene.','Dacia Maraini','Bagheria');
commit;

create table users(
  user_id serial primary key,
  first_name varchar (20),
  last_name varchar (20),
  username varchar (20) unique not null
);

begin;
insert into users (first_name, last_name, username) values 
  ('Arianna', 'Muti', 'Ari'),
  ('Rita', 'Casesa', 'Ri'),
  ('Florenza', 'Martello', 'Flora');
commit;

CREATE table users_texts (
  text_id INTEGER,
  user_id INTEGER,
  foreign key (text_id) references texts (text_id),
  foreign key (user_id) references users (user_id)
);

begin;
INSERT into users_texts (text_id,user_id) values
  (1,3),
  (2,3),
  (1,1);
commit;



