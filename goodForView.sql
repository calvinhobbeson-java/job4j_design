select s.name, count(a.name), a.name, b.name from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
	where s.name  is  not null
	and b.name like '%н%'
	or  s.name like '%а%'
    group by (s.name, a.name, b.name) having count(a.name) <= 2;