-- we don't know how to generate root <with-no-name> (class Root) :(
grant audit_abort_exempt, firewall_exempt, select, system_user on *.* to 'mysql.infoschema'@localhost;

grant audit_abort_exempt, authentication_policy_admin, backup_admin, clone_admin, connection_admin, firewall_exempt, persist_ro_variables_admin, session_variables_admin, shutdown, super, system_user, system_variables_admin on *.* to 'mysql.session'@localhost;

grant audit_abort_exempt, firewall_exempt, system_user on *.* to 'mysql.sys'@localhost;

grant alter, alter routine, application_password_admin, audit_abort_exempt, audit_admin, authentication_policy_admin, backup_admin, binlog_admin, binlog_encryption_admin, clone_admin, connection_admin, create, create role, create routine, create tablespace, create temporary tables, create user, create view, delete, drop, drop role, encryption_key_admin, event, execute, file, firewall_exempt, flush_optimizer_costs, flush_status, flush_tables, flush_user_resources, group_replication_admin, group_replication_stream, index, innodb_redo_log_archive, innodb_redo_log_enable, insert, lock tables, passwordless_user_admin, persist_ro_variables_admin, process, references, reload, replication client, replication slave, replication_applier, replication_slave_admin, resource_group_admin, resource_group_user, role_admin, select, sensitive_variables_observer, service_connection_admin, session_variables_admin, set_user_id, show databases, show view, show_routine, shutdown, super, system_user, system_variables_admin, table_encryption_admin, trigger, update, xa_recover_admin, grant option on *.* to root@localhost;

create table age_category
(
    id            varchar(36)  not null
        primary key,
    category_name varchar(100) null
);

create table country_block
(
    id         varchar(36) not null
        primary key,
    block_name varchar(80) not null
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
    last_name    varchar(30)  null,
    phone        varchar(10)  null,
    idnp         varchar(20)  not null,
    phone_number varchar(255) null
);

create table role
(
    id        varchar(36) not null
        primary key,
    role_name varchar(50) not null
);

create table user
(
    id        varchar(36)  not null
        primary key,
    email     varchar(20)  not null,
    person_id varchar(36)  null,
    role_id   varchar(36)  null,
    password  varchar(255) null,
    username  varchar(255) null,
    constraint email
        unique (email),
    constraint user_person_fk
        foreign key (person_id) references person (id),
    constraint user_role_fk
        foreign key (role_id) references role (id)
);

create table report
(
    id             varchar(36) not null
        primary key,
    address        varchar(70) null,
    contact_number int         null,
    user           varchar(36) null,
    constraint report_user_fk
        foreign key (user) references user (id)
);

create table user_roles
(
    user_id  varchar(11) not null,
    roles_id varchar(36) not null,
    constraint FK55itppkw3i07do3h7qoclqd4k
        foreign key (user_id) references user (id),
    constraint FKj9553ass9uctjrmh0gkqsmv0d
        foreign key (roles_id) references role (id)
);

create table vehicle_type
(
    id        varchar(36)  not null
        primary key,
    type_name varchar(255) null
);

create table tariff
(
    value           float       null,
    vehicle_type_id varchar(36) not null
        primary key,
    age_category_id varchar(36) null,
    constraint FK44rnelr1uy0otjrybwimfdbql
        foreign key (age_category_id) references age_category (id),
    constraint FKgjbjebi2svqkxlv94d3yqgnl1
        foreign key (vehicle_type_id) references vehicle_type (id)
);

create table vehicle
(
    id                              varchar(36) not null
        primary key,
    registration_certificate_number int         not null,
    price                           int         null,
    make                            varchar(50) null comment '20',
    model                           varchar(50) not null,
    year                            int         null,
    type_id                         varchar(36) null,
    constraint vehicle_pk
        unique (registration_certificate_number),
    constraint vehicle_type_fk
        foreign key (type_id) references vehicle_type (id)
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

