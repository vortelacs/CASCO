create table country_block
(
    id         varchar(36) not null
        primary key,
    block_name varchar(80) not null
);

create table age_category
(
    id            varchar(36)  not null
        primary key,
    category_name varchar(255) null,
    max_age       int          not null,
    min_age       int          not null
);


create table vehicle_type
(
    id        varchar(36)  not null
        primary key,
    type_name varchar(255) not null
);


create table insurer
(
    id           varchar(36)  not null
        primary key,
    company_name varchar(40)  not null,
    img          varchar(100) not null
);

create table person
(
    id           varchar(36)  not null
        primary key,
    first_name   varchar(30)  not null,
    last_name    varchar(30)  not null,
    phone        varchar(20)  not null,
    idnp         varchar(20)  not null
);

create table role
(
    id        varchar(36) not null
        primary key,
    role_name varchar(50) not null
);

create table insurance_type
(
    id        varchar(36) not null
        primary key,
    type_name varchar(50) not null
);


create table tariff
(
    id           varchar(36)  not null
        primary key,
    value           float       not null,
    vehicle_type_id varchar(36) not null,
    age_category_id varchar(36)    not null,
    insurer_id varchar(36) not null,
    is_franchise      bit         not null,
    insurance_type_id varchar(36) not null,
    constraint tariff_vehicle_type
        foreign key (vehicle_type_id) references vehicle_type (id)
);

create index FK44rnel21uy0otjrybwimfdbql
    on tariff (vehicle_type_id, age_category_id, insurer_id, is_franchise, insurance_type_id);

create table user
(
    id        varchar(36)  not null
        primary key,
    email     varchar(20)  not null,
    person_id varchar(36)  null,
    password  varchar(255) null,
    constraint email
        unique (email),
    constraint user_person_fk
        foreign key (person_id) references person (id)
);

create table report
(
    id             varchar(36) not null
        primary key,
    address        varchar(70) not null,
    contact_number int         not null,
    user           varchar(36) not null,
    constraint report_user_fk
        foreign key (user) references user (id)
);
create table vehicle
(
    id                              varchar(36) not null
        primary key,
    registration_number varchar(50)         not null,
    certificate_number varchar(50)         not null,
    price                           int         null,
    make                            varchar(50) null comment '20',
    model                           varchar(50) not null,
    year                            int         not null,
    type_id                         varchar(36) not null,
    constraint vehicle_pk
        unique (registration_number),
    constraint vehicle_type_fk
        foreign key (type_id) references vehicle_type (id)
);

create table insurance
(
    id               varchar(36) not null
        primary key,
    insurance_type_id   varchar(36) not null,
    vehicle_id       varchar(36) not null,
    user_id          varchar(36) not null,
    insurer_id       varchar(36) not null,
    country_block_id varchar(36) null,
    effective_date   date        not null,
    expire_date      date        not null,
    price float not null,
    constraint insurance_country_block_fk
        foreign key (country_block_id) references country_block (id),
    constraint insurance_insurer_fk
        foreign key (insurance_type_id) references insurance_type (id),
    constraint insurance_insurance_type_fk
        foreign key (insurer_id) references insurer (id),
    constraint insurance_user_fk
        foreign key (user_id) references user (id),
    constraint insurance_vehicle_fk
        foreign key (vehicle_id) references vehicle (id)
);

create table person_insurance
(
    insurance_id varchar(36) not null,
    person_id    varchar(36) not null,
    constraint person_insurance_insurance_fk
        foreign key (insurance_id) references insurance (id),
    constraint person_insurance_person_fk2
        foreign key (person_id) references person (id)
);

create table user_roles
(
    user_id varchar(36) not null,
    role_id    varchar(36) not null,
    constraint user_roles_user_fk
        foreign key (user_id) references user (id),
    constraint user_roles_role_fk
        foreign key (role_id) references role (id)
);

