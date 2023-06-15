create table age_category
(
    id            varchar(36) not null
        primary key,
    category_name varchar(30) not null
);

create table vehicle_type
(
    id        varchar(36) not null
        primary key,
    type_name varchar(30) null
);

create table tariff
(
    age_fk          varchar(36) not null,
    vehicle_type_fk varchar(36) not null,
    tariff_value    int         not null,
    constraint tariff_age_fk
        foreign key (age_fk) references age_category (id),
    constraint tariff_vehicle_type_fk
        foreign key (vehicle_type_fk) references vehicle_type (id)
);

