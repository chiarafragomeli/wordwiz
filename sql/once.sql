drop schema if exists wordwiz cascade;
drop user if exists wordwiz;

create user wordwiz with password 'password';
create schema authorization wordwiz;