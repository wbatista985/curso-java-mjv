--DDL - Data Definition Language (Linguagem de Definição de dados)
--CREATE, ALTER e DROP

--criação tabela tab_ficha_profissional

create table tab_ficha_profissional(
	id serial primary key,
	nome varchar(50),
	email varchar(50),
	telefone varchar(18),
	logradouro varchar(100),
	numero varchar(5),
	bairro varchar(50),
	cidade varchar(80),
	estado char(2),
	salario_minimo numeric(8,2),
	salario_maximo numeric(8,2),
	estrangeiro char(1)
);

--------------------------------------------------------------------------------------------------------------

--DML - Data Manipulation Language (Linguagem de Manipulação de Dados)
--INSERT, UPDATE e DELETE
--adionando valores dos campos da tabela

-- o valor do id é autoincrement usamos default
insert into tab_ficha_profissional values( 
default,
'Wagner dos Santos', 'wbatista985@gmail.com', '5511942601853', 'Estrada do carneiro', '6',
'Maria eneide', 'Maua', 'Sp', 2000.00, 5000.00, '0'
);

-- inserindo estrangeiro para mostrar a exclusão
insert into tab_ficha_profissional values( 
default,
'marcelo santos', 'quim@gmail.com', '35122998741569', 'Rua Branco de assis', '15',
'Centro', 'Paraiba', 'PB', 2567.80, 5000.0, '1'
);
-- inserindo outro registro para entrar no id 3
insert into tab_ficha_profissional values( 
default,
'Registro de id 3', 't@gmail.com', '55011994741569', 'Rua manuel lopes', '1567',
'Centro', 'Rio de Janeiro', 'RJ', 2000.80, 3000.0, '0','designer'
);

insert into tab_ficha_profissional values( 
default,
'MARCOS BRITO', 'marcosPbritoS@gmail.com', '55022998741569', 'Rua Rio Branco', '1567',
'Centro', 'Rio de Janeiro', 'RJ', 1000.80, 2000.0, '0', 'Designer Gráfico'
);

insert into tab_ficha_profissional values( 
default,
'MARCOS PAULO', 'marcosPbritoS@gmail.com', '55022998741569', 'Rua Rio Branco', '1567',
'Centro', 'Rio de Janeiro', 'RJ', 1000.80, 2000.0, '0', 'Designer Gráfico'
);

--alterar tabela para inclusãodo campo profissão
alter table tab_ficha_profissional add column profissao varchar(50);

--alterar coluna email para que possa suportar 100 caracteres
alter table tab_ficha_profissional alter column email type varchar(100);

--defenindo profissoões via update
update tab_ficha_profissional set profissao = 'Desenvolvedor de Sistemas' where id = 1;

update tab_ficha_profissional set email = 'wbatista985@gmail.com' where id = 1;

update tab_ficha_profissional set profissao = 'operador Sistemas' where id = 2;


-- deletando tabela estrangeiro igual a verdadeiro 1 = verdadeiro
delete from tab_ficha_profissional where estrangeiro = '1';

--update cadastro id =3
update tab_ficha_profissional set logradouro = 'PRACA DA SE', numero = 'S/N', bairro = 'CENTRO',
cidade = 'SAO PAULO' where id = 3;

--------------------------------------------------------------------------------------------------------


--DQL - Data Query Language - Linguagem de consulta de dados
--SELECT
--mostrando toda a tabela 
select * from tab_ficha_profissional;

--Retornar uma lista contendo os campos: Nome, Email, Profissao e Faixa Salarial ordenado por Profissão, Nome;
select nome, email, profissao, salario_minimo, salario_maximo from tab_ficha_profissional
order by  profissao, nome;

--Retornar uma lista contendo os campos: Nome, Email, Profissao e Faixa Salarial ordenado por Profissão, Salario Máximo do maior para o menor;
select nome, email, profissao, salario_minimo, salario_maximo from tab_ficha_profissional
order by profissao, salario_maximo desc;

--Retornar uma lista com a seguinte informação concatenada e apelidada de nome_profissao: NOME + ' - ' + PROFISSAO;
select nome || ' - ' || profissao as nome_profissao from tab_ficha_profissional;

-- Retornar uma lista contendo o nome da profissão e a quantidade de registros da profissão.
select profissao, count(profissao) as quantidade from tab_ficha_profissional group by profissao;

--Retornar o registro com menor salário mínimo;
select min(salario_minimo) as menor_salario from tab_ficha_profissional;

--Retornar se existir o registro com a seguinte condição: Nome parecido com 'MARCOS PAULO' e Salario Maximo maior que 1200
-- e Salario Maximo menor ou igual que 2000 e que o Estado esteja entre SP, RJ, SC.

select * from tab_ficha_profissional where
nome like 'MARCOS PAULO%'
and salario_maximo > 1200.0
and salario_maximo <= 2000.0
and estado = 'RJ' or estado = 'SC' or estado = 'SP';













