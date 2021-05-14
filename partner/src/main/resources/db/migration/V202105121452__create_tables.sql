create table event
(
    id               bigint not null auto_increment,
    end_time_stamp   bigint,
    location         varchar(255),
    start_time_stamp bigint,
    title            varchar(255),
    primary key (id)
);

create table seat
(
    id             bigint       not null auto_increment,
    seat_id        varchar(255) not null,
    currency       integer,
    price          integer      not null,
    reserved       boolean      not null,
    reservation_id varchar(255),
    event_id       bigint,
    primary key (id)
);

