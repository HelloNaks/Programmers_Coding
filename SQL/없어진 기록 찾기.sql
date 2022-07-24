select o.animal_id, o.name
from animal_outs o
where not exists
(select i.animal_id
 from animal_ins i
 where i.animal_id = o.animal_id);