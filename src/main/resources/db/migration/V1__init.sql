Drop table if exists account;
Drop sequence if exists hibernate_sequence;

Create sequence hibernate_sequence start with 1 increment by 1;

Create table account (
    id bigint not null,
    name varchar(255) not null,
    primary key (id)
);

ALTER TABLE account ALTER COLUMN id SET DEFAULT nextval('hibernate_sequence');