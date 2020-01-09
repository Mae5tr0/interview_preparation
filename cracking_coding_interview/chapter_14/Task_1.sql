-- Multiple Apartments
--
-- Write a SQL query to get a list of tenants who are renting more than one apartment.

SELECT t.tenantName FROM tenants t
JOIN AptTenants apt ON apt.tenantId = t.TenantID
GROUP BY t.TenantID, t.tenantName
HAVING count(*) > 1

