-- 코드를 입력하세요

-- SELECT * FROM FOOD_PRODUCT A, FOOD_ORDER B WHERE A.PRODUCT_ID = B.PRODUCT_ID;

-- select o.product_id, p.product_name, sum(o.amount)*p.price total_sales
-- from food_order o inner join food_product p
--     on o.product_id = p.product_id
-- where to_char(o.produce_date, 'yyyy-mm') = '2022-05'
-- group by o.product_id, p.product_name, p.price
-- order by total_sales desc, o.product_id;

select p.product_id,p.product_name,avg(price)*sum(amount) total_sales
from food_product p inner join food_order o
    on p.product_id = o.product_id
where to_char(o.produce_date, 'yyyy-mm') like '2022-05%'
group by p.product_id,p.product_name
order by total_sales desc, p.product_id;