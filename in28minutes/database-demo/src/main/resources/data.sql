create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

insert into PERSON (id, name, location, birth_date) values (10001, 'Jose', 'Sao Paulo', sysdate());
insert into PERSON (id, name, location, birth_date) values (10002, 'Pedro', 'New York', sysdate());
insert into PERSON (id, name, location, birth_date) values (10003, 'Joao', 'Tokio', sysdate());