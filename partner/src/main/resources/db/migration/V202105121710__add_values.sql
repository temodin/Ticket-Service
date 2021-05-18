insert into event (id, title, location, start_time_stamp, end_time_stamp)
values (1, 'Szilveszteri zártkörű rendezvény', 'Greenwich', 1577836800, 1577844000),
       (2, 'Májusi mulatság', 'Budapest', 1588334400, 1588348800),
       (3, 'Necc party', 'Debrecen', 1622324218084, 1622334218084);

insert into seat (id, seat_id, price, currency, reserved, event_id)
values (1,'S1', 1000, 0, true, 1),
       (2,'S2', 1000, 0, false, 1),
       (3,'S3', 1000, 0, false, 1),
       (4,'S4', 1000, 0, false, 1),
       (5,'S5', 1000, 0, false, 1),
       (6,'S6', 1000, 0, true, 1),
       (7,'S7', 1000, 0, true, 1),
       (8,'S8', 1000, 0, true, 1),
       (9,'S9', 1000, 0, true, 1),
       (10,'S10', 1000, 0, true, 1),

       (11,'S1', 1000, 0, false, 2),
       (12,'S2', 1000, 0, true, 2),
       (13,'S3', 1000, 0, false, 2),
       (14,'S4', 1000, 0, false, 2),
       (15,'S5', 1000, 0, false, 2),
       (16,'S6', 1000, 0, true, 2),
       (17,'S7', 1000, 0, true, 2),
       (18,'S8', 1000, 0, true, 2),
       (19,'S9', 1000, 0, true, 2),
       (20,'S10', 1000, 0, true, 2),

       (21,'S1', 1000, 0, false, 3),
       (22,'S2', 1000, 0, false,3),
       (23,'S3', 1000, 0, true, 3),
       (24,'S4', 1000, 0, false, 3),
       (25,'S5', 1000, 0, false, 3),
       (26,'S6', 1000, 0, true, 3),
       (27,'S7', 1000, 0, true, 3),
       (28,'S8', 1000, 0, true, 3),
       (29,'S9', 1000, 0, true, 3),
       (30,'S10', 1000, 0, true, 3);



