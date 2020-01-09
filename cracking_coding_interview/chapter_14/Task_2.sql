-- Open Requests
--
-- Write a SQL query to get a list of all buildings and the number of open requests
-- (Requests in which status equals'Open').

-- Using window function (PostgreSQL Syntax)
SELECT b.*, b.BuildingName, count(*) FILTER (WHERE r.Status = 'Open')
from Buildings b
JOIN Apartmens a on a.BuildingID = b.BuildingID
JOIN Requests r on r.AptId = a.AptId
GROUP by b.BuildingID, b.BuildingName

-- Inner requests
select b.*, IFNULL(stats.count, 0) as requestsCount
from Building b1
LEFT JOIN (
    SELECT b.BuildingID, count(*)
    from Buildings b
    JOIN Apartmens a on a.BuildingID = b.BuildingID
    JOIN Requests r on r.AptId = a.AptId
    WHERE r.Status = 'Open'
    GROUP by b.BuildingID, r.Status
) stats ON stats.BuildingID = b1.BuildingID
