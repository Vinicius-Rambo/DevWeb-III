SELECT p.*, c.nome as curso_nome
FROM professores as p 
JOIN cursos as c 
ON p.curso_id = c.curso_id  

ORDER BY p.nome 
LIMIT 5
OFFSET 10 