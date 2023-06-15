create table age_category
(
    id            varchar(255) not null
        primary key,
    category_name varchar(255) null
);

create table country_block
(
    id         varchar(36) not null
        primary key,
    block_name varchar(80) not null
);

create table flyway_schema_history
(
    installed_rank int                                 not null
        primary key,
    version        varchar(50)                         null,
    description    varchar(200)                        not null,
    type           varchar(20)                         not null,
    script         varchar(1000)                       not null,
    checksum       int                                 null,
    installed_by   varchar(100)                        not null,
    installed_on   timestamp default CURRENT_TIMESTAMP not null,
    execution_time int                                 not null,
    success        tinyint(1)                          not null
);

create index flyway_schema_history_s_idx
    on flyway_schema_history (success);

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
    last_name    varchar(30)  null,
    phone        varchar(10)  null,
    IDNP         varchar(20)  not null,
    phone_number varchar(255) null
);

create table role
(
    id        varchar(36) not null
        primary key,
    role_name varchar(50) null
);

create table user
(
    id        varchar(36)  not null
        primary key,
    email     varchar(20)  not null,
    person_id varchar(36)  null,
    role_id   varchar(36)  null,
    internid  int          not null,
    password  varchar(255) null,
    constraint email
        unique (email),
    constraint user_person_fk
        foreign key (person_id) references person (id),
    constraint user_role_fk
        foreign key (role_id) references role (id)
);

create table vehicle
(
    id                              varchar(36) not null
        primary key,
    registration_certificate_number int         not null,
    price                           int         null,
    make                            varchar(50) null comment '20',
    model                           varchar(20) not null,
    year                            int         null,
    type_id                         varchar(36) null,
    internid                        varchar(36) not null,
    constraint vehicle_pk
        unique (registration_certificate_number),
    constraint vehicle_type_fk
        foreign key (type_id) references tariff.vehicle_type (id)
);

create table insurance
(
    id               varchar(36) not null
        primary key,
    type             varchar(30) not null,
    vehicle_id       varchar(36) not null,
    user_id          varchar(36) not null,
    insurer_id       varchar(36) null,
    country_block_id varchar(36) null,
    effective_date   date        not null,
    expire_date      date        null,
    vehicle_internid varchar(36) null,
    constraint insurance_country_block_fk
        foreign key (country_block_id) references country_block (id),
    constraint insurance_insurer_fk
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

create table vehicle_type
(
    id        varchar(255) not null
        primary key,
    type_name varchar(255) null
);

create table tariff
(
    value           float        null,
    vehicle_type_id varchar(255) not null
        primary key,
    age_category_id varchar(255) null,
    constraint FK44rnelr1uy0otjrybwimfdbql
        foreign key (age_category_id) references age_category (id),
    constraint FKgjbjebi2svqkxlv94d3yqgnl1
        foreign key (vehicle_type_id) references vehicle_type (id)
);