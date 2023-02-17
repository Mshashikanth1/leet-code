181. Employees Earning More Than Their Managers.sql
problem:https://leetcode.com/problems/employees-earning-more-than-their-managers/
# Write your MySQL query statement below

select name as 'Employee' from Employee emp 
where salary>(select salary from Employee where id=emp.managerId) 
