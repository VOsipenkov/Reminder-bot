create table USER_INFO (
    id varchar2(36) primary key,
    username varchar2(40),
    first_name varchar2(40),
    last_name varchar2(40)
);

create table TASK (
    id varchar2(36) primary key,
    day_of_year DATE not null,
    day_of_week varchar2(9) not null,
    action varchar2(100) not null,
    repeate_type varchar2(36),
    is_repeatable boolean not null,
    user_info_id varchar2(36) not null,
    constraint user_info_id_fk foreign key (user_info_id) references USER_INFO (id)
);