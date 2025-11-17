create table if not exists "users"
(
    id bigserial primary key,
    nickname varchar,
    password varchar,
    fio varchar,
    age bigint,
    email varchar,
    regdate date,
    is_deleted boolean default false
);

create table if not exists "films"
(
    id bigserial primary key,
    title varchar,
    genre varchar,
    release bigint,
    content varchar
);