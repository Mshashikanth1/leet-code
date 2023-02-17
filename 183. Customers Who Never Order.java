183. Customers Who Never Order.java
Problem:https://leetcode.com/problems/customers-who-never-order/
# Write your MySQL query statement below

select name as 'Customers' 
from Customers 
where 
id not in (select distinct customerId from Orders)
