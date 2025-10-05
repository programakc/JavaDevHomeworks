insert into buyers (name) values ('Максим'), ('Юлия'), ('Ева'), ('Алиса'); 

select * from buyers

insert into "order" (buyer_id, order_date, count_orders, discount)
	values (2, CURRENT_TIMESTAMP, 3, 10), (4, CURRENT_TIMESTAMP, 1, 0), (1, CURRENT_TIMESTAMP, 10, 25);

select * from "order"

select * from "order", buyers
	where "order".buyer_id = buyers.id 

