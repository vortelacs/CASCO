create table report
(
    id             varchar(36) not null
        primary key,
    address        varchar(70) null,
    contact_number int         null,
    user           varchar(36) null,
    constraint report_user_fk
        foreign key (user) references casco.user (id)
);

