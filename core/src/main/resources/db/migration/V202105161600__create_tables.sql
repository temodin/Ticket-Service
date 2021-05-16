create table user
(
    user_id               bigint not null auto_increment,
    name         varchar(255),
    email            varchar(255),
    primary key (id)
);

create table user_device
(
    device_hash           bigint       not null auto_increment,
    user_id        bigint,
    primary key (device_hash)
);

create table user_token
(
    token bigint       not null auto_increment,
    user_id bigint,
    primary key (token)
);

create table user_bank_card
(
    card_id varchar(10)      not null auto_increment,
    card_number bigint,
    cvc integer,
    name varchar(255),
    amount integer,
    currency integer,
    user_id bigint,
    primary key (card_id)
);

