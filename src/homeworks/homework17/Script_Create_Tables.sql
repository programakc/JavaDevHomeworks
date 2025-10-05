create table if not exists "buyers"
(
	id bigserial primary key,
	name varchar
);

create table if not exists "order"
(
	id bigserial primary key,
	buyer_id bigint references buyers(id),
	order_date timestamp,
	count_orders bigint,
	discount smallint
);