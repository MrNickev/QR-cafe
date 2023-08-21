insert into users (id, email, password, username) values ('1489e5b6-e930-4bf8-a273-a45d01553db2'::UUID, 'kthurber0@elpais.com', '$2a$12$9NgWbkRFm1cOU5Che3yiKe9isFd1L8s84hd56Ftgb62AADfPjQspi', 'admin');
insert into users (id, email, password, username) values ('274fea66-fc6b-41f1-a444-7807452afcda'::UUID, 'hchadbourne1@goodreads.com', '$2a$12$Qa730Yk9CZSV1MI6IEs8.uM1Yl3NH9tSItZy5GEe27V4fdo.J6Lya', 'bigboss');
insert into users (id, email, password, username) values ('69d0db91-e371-4276-8a6c-b4f056115a58'::UUID, 'pendle2@slideshare.net', '$2a$12$Q2H4zLWqPXQFSnR/RR9u8u1NbkiynAGth3xQAM0Wh4kTVODLfVvqK', 'manager');
insert into users (id, email, password, username) values ('d4929bc5-2951-4d86-b4cb-485c25813eaf'::UUID, 'ffeare3@live.com', '$2a$12$8P8wJc7gGSKDG6R1xHYXaevgqYI5o1DpKKd8WETJY/JAxiOzV7z3G', 'director');
insert into users (id, email, password, username) values ('c0ef8d4c-48bd-43da-943f-034148963e95'::UUID, 'bforo4@netscape.com', '$2a$12$uJPi1WnH1EBasMFv3g/IDePDGp125DDqdlVYqDIA0hxH9UVOBpwQG', 'waiter');

insert into roles (id, name) values (1, 'ADMIN');
insert into roles (id, name) values (2, 'WAITER');
insert into roles (id, name) values (3, 'MANAGER');
insert into roles (id, name) values (4, 'DECISION_MAKER');
insert into roles (id, name) values (5, 'GENERAL_MANAGER');

insert into users_roles(user_id, role_id) values ('1489e5b6-e930-4bf8-a273-a45d01553db2'::UUID, 1);
insert into users_roles(user_id, role_id) values ('c0ef8d4c-48bd-43da-943f-034148963e95'::UUID, 2);
insert into users_roles(user_id, role_id) values ('69d0db91-e371-4276-8a6c-b4f056115a58'::UUID, 3);
insert into users_roles(user_id, role_id) values ('274fea66-fc6b-41f1-a444-7807452afcda'::UUID, 4);
insert into users_roles(user_id, role_id) values ('d4929bc5-2951-4d86-b4cb-485c25813eaf'::UUID, 5);

