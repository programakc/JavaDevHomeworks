select * from buyer;

select description, cost from product;

select * from buyer, "order"
	where "order".buyer_id = buyer.id;


update buyer set name = 'Гордеев Максим' where name = 'Максим';

update product set cost = cost + 10 where cost < 500;

update "order" set order_date = CURRENT_TIMESTAMP;


delete from buyer where "name" = 'Светлана';

delete from product where "count" < 2;

delete from "order";
	