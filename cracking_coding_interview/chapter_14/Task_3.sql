-- Close All Requests
--
-- Building #11 is undergoing a major renovation.
-- Implement a query to close all requests from apartments in this building.

UPDATE Requests r
SET r.Status = 'Closed'
FROM (
    SELECT * from Requests r
    JOIN Apartments a ON a.AptID = r.AptID
    JOIN Buildings b ON b.BuilidingID = a.BuildingID
    where b.buildingID = 11
)

