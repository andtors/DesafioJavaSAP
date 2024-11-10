<h1>Desafio Java SAP</h1>
<p>Implementação de uma aplicação Java para o gerenciamento de uma plataforma de cursos online. A aplicação utiliza Hibernate para fazer o mapeamento objeto-relacional (ORM) com três tabelas</p>

<h1>Especificação e EndPoinst</h1>
<p>O projeto utiliza o banco h2 para armazenar os dados</p>
<p>Os endpoinst são:
<br>
POST - localhost:8080/alunos - Cadastro de alunos
<br>
POST - localhost:8080/cursos - Cadastro de cursos
<br>
GET - localhost:8080/alunos/{aluno_id} - Informações do aluno e cursos que o aluno está inscrito
<br>
GET - localhost:8080/cursos/{curso_id} - Informações do curso e alunos que estão inscritos no curso
<br>
PUT - localhost:8080/alunos/{aluno_id} - Inscrição do aluno ao curso desejado
<br>
obs1: necessario informar e-mail e nome do aluno e o id do curso a ser inscrito.
<br>
obs2: é possivel cadastrar o aluno em diversos cursos de uma vez só.
</p>
