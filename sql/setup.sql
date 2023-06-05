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

select * from users;
SELECT * from texts;

