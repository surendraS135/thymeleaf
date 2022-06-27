create sequence person_sequence start with 1 increment by 1;
create table person (id bigint not null, age integer, name varchar(255), primary key (id));
create sequence persond_sequence start with 1 increment by 1;
create table person_details (id bigint not null, hobby varchar(255), profession varchar(255), person_id bigint not null, primary key (id));
alter table person_details add constraint FKqts0oarflbht37ghuvtpu1ty4 foreign key (person_id) references person;