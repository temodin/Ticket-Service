insert into user (user_id, name, email)
values (1000, 'Teszt Aladár', 'teszt.aladar@otpmobil.com'),
       (2000, 'Teszt Benedek', 'teszt.benedek@otpmobil.com'),
       (3000, 'Teszt Cecília', 'teszt.cecilia@otpmobil.com');

insert into user_device (device_hash, user_id)
values ('F67C2BCBFCFA30FCCB36F72DCA22A817', 1000),
       ('0F1674BD19D3BBDD4C39E14734FFB876', 1000),
       ('3AE5E9658FBD7D4048BD40820B7D227D', 1000),
       ('FADDFEA562F3C914DCC81956682DB0FC', 2000),
       ('E68560872BDB2DF2FFE7ADC091755378', 3000);

insert into user_token (token, user_id)
values ('dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJkY2N0MyQkNCRkNGQTMwRkNDQjM2RjcyRENBMjJBODE3', 1000),
       ('dGVzenQuYmVuZWRla0BvdHBtb2JpbC5jb20mMjAwMCZGQURERkVBNTYyRjNDOTE0RENDODE5NTY2ODJEQjBGQw==', 2000),
       ('dGVzenQuY2VjaWxpYUBvdHBtb2JpbC5jb20mMzAwMCZFNjg1NjA4NzJCREIyREYyRkZFN0FEQzA5MTc1NTM3OA==', 3000),
       ('dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJjBGMTY3NEJEMTlEM0JCREQ0QzM5RTE0NzM0RkZCODc2', 1000),
       ('dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJjNBRTVFOTY1OEZCRDdENDA0OEJENDA4MjBCN0QyMjdE', 1000);

insert into user_bank_card (card_id, card_number, cvc, name, amount, currency, user_id)
values
    ('C0001', 5299706965433676, 123, 'Teszt Aladár', 1000, 0, 1000),
    ('C0002', 5390508354245119, 456, 'Teszt Benedek', 2000, 0, 2000),
    ('C0003', 4929088924014470, 789, 'Teszt Cecília', 3000, 0, 3000);






