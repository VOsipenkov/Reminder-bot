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
    constraint user_info_id_fk foreign key (user_info_id) references USER_INFO (id)
);