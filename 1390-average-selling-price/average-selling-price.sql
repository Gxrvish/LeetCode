
select p.product_id , ifnull (round(sum(p.price*s.units)/sum(units),2),0) as average_price
from Prices p left join UnitsSold s
on p.product_id =s.product_id
and s.purchase_date  between  p.start_date and p.end_date  
group by p.product_id