create table countries (
    id INTEGER PRIMARY KEY,
    name VARCHAR2(50)
);

create table DAY_OF_WEEK_DICTIONARY (
    id varchar2(36) primary key,
    alias varchar2(20) not null,
    day_of_week varchar2(9) not null
);

create table REPEATE_TYPE_DICTIONARY (
    id varchar2(36) primary key,
    alias varchar2(30) not null,
    type varchar2(20) not null
);

create table USER_INFO (
    id varchar2(36) primary key,
    username varchar2(40),
    first_name varchar2(40),
    last_name varchar2(40)
);

create table NOTIFICATION_SCHEDULE (
    id varchar2(36) primary key,
    user_info_id varchar2(36) not null,
    day_id varchar2(36) not null,
    repeate_id varchar2(36) not null,
    constraint user_info_id_fk foreign key (user_info_id) references USER_INFO (id),
    constraint day_id_fk foreign key (day_id) references DAY_OF_WEEK_DICTIONARY (id),
    constraint repeate_id_fk foreign key (repeate_id) references REPEATE_TYPE_DICTIONARY(id)
);

INSERT INTO countries (id, name) VALUES (1, 'USA');
INSERT INTO countries (id, name) VALUES (2, 'France');
INSERT INTO countries (id, name) VALUES (3, 'Brazil');
INSERT INTO countries (id, name) VALUES (4, 'Italy');
INSERT INTO countries (id, name) VALUES (5, 'Canada');