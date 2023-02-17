182. Duplicate Emails.sql
Problem:https://leetcode.com/problems/duplicate-emails/description/
# Write your MySQL query statement below

select email from (
select email,count(*) as count from Person group by email) as main where main.count>1
