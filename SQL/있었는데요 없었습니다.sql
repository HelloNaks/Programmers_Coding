select o.animal_id, o.name
from animal_outs o, animal_ins i
where o.datetime < i.datetime and o.animal_id = i.animal_id
order by i.datetime;