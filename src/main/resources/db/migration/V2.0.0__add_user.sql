insert into app_user (app_user_id, username, email, password, active, role)
values (nextval(pg_get_serial_sequence('app_user', 'app_user_id')), 'ezeHumar', 'eze@example.com', '123456', true, 'USER');

insert into app_user (app_user_id, username, email, password, active, role)
values (nextval(pg_get_serial_sequence('app_user', 'app_user_id')), 'ezeHumar2', 'eze2@example.com', '123456', true, 'USER');