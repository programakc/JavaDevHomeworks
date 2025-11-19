create table if not exists "televisions"
(
    id bigserial primary key,
    company varchar,
    model varchar,
    release bigint,
    price real,
    in_stock bigint
);