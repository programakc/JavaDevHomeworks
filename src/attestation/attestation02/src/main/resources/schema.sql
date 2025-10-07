create table if not exists "product"
(
	id bigserial primary key,
	description varchar,
	cost int,
	count int
);

create table if not exists "buyer"
(
	id bigserial primary key,
	name varchar
);

create table if not exists "order"
(
	product_id int references "product"(id),
	buyer_id int references "buyer"(id),
	order_date timestamp,
	count_orders int
);

comment on table "product" is 'Product table';
comment on table "buyer" is 'Buyers table';
comment on table "order" is 'Orders table';