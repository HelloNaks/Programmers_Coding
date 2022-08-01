Select P1.id, P1.name, P1.host_id
from places P1, (Select count(id) as COUNTS, host_id from places group by host_id) P2
where P2.host_id = P1.host_id and P2.COUNTS>=2;