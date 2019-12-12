INSERT INTO lab12test.flight (id, capacity, departure_date, name) VALUES (1, 1, '12-12-2019', 'flight to Rio from Belarus reserved only for a big companies');
INSERT INTO lab12test.flight (id, capacity, departure_date, name) VALUES (2, 5, '05-12-2019', 'flight to Russia from Belarus reserved only for a big companies');
INSERT INTO lab12test.flight (id, capacity, departure_date, name) VALUES (3, 10, '12-11-2019', 'flight to US from Belarus reserved only for a big companies');
INSERT INTO lab12test.flight (id, capacity, departure_date, name) VALUES (4, 5, '25-11-2019', 'flight to Canada from Belarus reserved only for a big companies');

INSERT INTO lab12test.ticket (id, cost, flight_id, title) VALUES (1, 500, 1, 'extra class');
INSERT INTO lab12test.ticket (id, cost, flight_id, title) VALUES (2, 400, 2, 'extra class');
INSERT INTO lab12test.ticket (id, cost, flight_id, title) VALUES (3, 250, 2, 'default class');
INSERT INTO lab12test.ticket (id, cost, flight_id, title) VALUES (4, 250, 1, 'default class');

INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (1, '1111@gmail.com', 'mr1111', 'last1111', '1111', 2);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (2, '2222@gmail.com', 'mr22222', 'last2222', '2222', 2);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (3, '3333@gmail.com', 'mr3333', 'last3333', '3333', 3);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (4, '4444@gmail.com', 'mr4444', 'last4444', '4444', 1);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (5, '5555@gmail.com', 'mr5555', 'last5555', '5555', 2);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (6, '6666@gmail.com', 'mr6666', 'last6666', '6666', 2);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (7, '7777@gmail.com', 'mr7777', 'last7777', '7777', 3);
INSERT INTO lab12test.user (id, email, first_name, last_name, phone, ticket_id) VALUES (8, '8888@gmail.com', 'mr8888', 'last8888', '8888', 4);