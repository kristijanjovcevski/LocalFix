INSERT INTO public.country (id, name)
VALUES ('1', 'Macedonia');

INSERT INTO public.city (id, name, country_id)
VALUES ('1', 'Skopje', '1');
VALUES ('2','Bitola', '1');


select * from problem;
select * from problem_administrator;
select * from person_admin;
select * from city;
select * from country;
select * from institution;
select * from person;


insert into institution(id,name)
values ('1','Park and greenery');



INSERT INTO public.institution(id, name)
VALUES ('1', 'Ministry of Interior Affairs'),
       ('2', 'Environment Ministry'),
       ('3', 'Ministry of Local Self-Government'),
       ('4', 'Ministry of Labour and Social Policy'),
       ('5', 'Ministry of Culture'),
       ('6', 'Park and Greenery');




INSERT INTO public.person(id, email, password, username,role)
VALUES ('2', 'admin@mail.com', 'Admin=1', 'Admin','ROLE_ADMIN');
       /*('2', 'filip@mail.com', '123', 'Filip Kraljevski');*/


INSERT INTO public.person_admin(id, person_id)
VALUES ('1', '2');

INSERT INTO public.person_users(id, person_id)
VALUES ('1', '2');
