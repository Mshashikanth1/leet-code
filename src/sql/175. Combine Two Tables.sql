175. Combine Two Tables.sql
Problem:https://leetcode.com/problems/combine-two-tables/

# Write your MySQL query statement below

select Person.firstName,Person.lastName,Address.city,Address.state 
from Person  left join  Address on Person.PersonId=Address.PersonId
