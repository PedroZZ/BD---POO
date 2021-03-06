create database ludpet
go
use ludpet

create table tipo(
id int identity not null,
descricao varchar(50) not null
primary key(id)) 

--EXECUTAR ANTES DE RODAR O PROJETO
INSERT INTO tipo (descricao) VALUES 
('Administrador'),      --1
('Atendente'),          --2
('Tosador/Banhista'),   --3
('Fornecedor'),         --4
('Cliente')             --5

create table pessoa(
idPessoa int identity not null,
idTipo int not null
primary key(idPessoa),
foreign key(idTipo) references tipo(id))

create table cliente(
id int not null,
nome varchar(60) not null,
cpf varchar(11) not null,
logradouro varchar(100) not null,
numero int not null,
bairro varchar(60) not null,
telefone int not null
primary key(id),
foreign key(id) references pessoa(idPessoa))

create table funcionario(
id int not null,
cpf varchar(11) not null,
nome varchar(50) not null,
salario decimal (7,2) not null,
telefone int not null
primary key (id),
foreign key(id) references pessoa(idPessoa))

CREATE TABLE usuario(
id int not null,
username varchar(10) unique,
passwor varchar(10),
primary key(username),
foreign key(id) references funcionario(id))

create table fornecedor(
id int not null,
nome varchar(60) not null,
telefone int not null,
primary key(id),
foreign key(id) references pessoa(idPessoa))

create table animal(
id int identity not null,
id_cliente int not null,
rga int not null,
nome varchar(60) not null,
raca varchar(50) not null,
especie varchar(50) not null,
sexo varchar(1) check(sexo='M' or sexo='F') not null,
cor varchar(50) null
primary key (id, id_cliente),
foreign key (id_cliente) references cliente(id) on delete cascade)

create table lote(
id int identity not null,
data_validade datetime not null
 primary key(id)
)

create table produto(
id int identity not null,
nome varchar(60) not null,
descricao varchar(60),
id_fornecedor int not null,
valor_venda int not null,
valor_compra int not null,
quantidade int not null,
primary key(id) ,
foreign key(id_fornecedor) references fornecedor(id)
)

create table lote_produto(
idProduto int not null,
idLote int not null,
primary key(idProduto, idLote),
foreign key(idProduto)references produto (id) ON DELETE CASCADE,
foreign key(idLote)references lote (id) ON DELETE CASCADE)

create table venda(
id int identity not null,
id_cliente int null,
id_funcionario int not null,
total money not null
primary key(id),
foreign key(id_cliente) references cliente(id),
foreign key(id_funcionario) references funcionario(id))

create table venda_produto(
id_venda int not null,
id_produto int not null,
data_venda datetime not null,
quantidade int not null,
check(data_venda <= getdate()),
primary key(data_venda, id_venda, id_produto),
foreign key(id_venda) references venda(id) ON DELETE CASCADE,
foreign key(id_produto) references produto(id) ON DELETE CASCADE)

create table servico(
id int not null,
nome varchar(15) not null,
valor int null,
id_animal int not null,
id_cliente_servico int not null
primary key(id),
foreign key(id_animal, id_cliente_servico) references animal(id, id_cliente) on delete cascade)

create table agenda(
hora time not null,
disponibilidade int null check(disponibilidade = 1 or disponibilidade = 0),
id_servico int null
primary key(hora),
foreign key (id_servico) references servico(id))

--EXECUTAR ANTES DE RODAR O PROJETO
insert into agenda(hora, disponibilidade) values
('10:00',0),
('10:30',0),
('11:00',0),
('11:30',0),
('12:00',0),
('12:30',0),
('13:00',0),
('13:30',0),
('14:00',0),
('14:30',0),
('15:00',0),
('15:30',0),
('16:00',0),
('16:30',0),
('17:00',0),
('17:30',0),
('18:00',0),
('18:30',0),
('19:00',0)

INSERT INTO pessoa (idTipo) VALUES
(1), --1 adm
(2), --2 atend
(3), --3 func
(4), --4 forn
(5), --5 cli
(1), --6 adm
(2), --7 atend
(3), --8 func
(4), --9 forn 
(5), --10 cli
(5), --11 cli
(5), --12 cli
(5), --13 cli
(5), --14 cli
(5)  --15 cli

INSERT INTO funcionario (id,cpf,nome,salario,telefone) VALUES
(1,11111111111,'Hury Gabriel',99999.99,11111111), --adm
(2,22222222222,'Pedro ZUZI',1200.00,11111111), -- cli
(10,33333333333,'Pedro Afonso',850.00,11111111)   -- cli

INSERT INTO usuario(id,username,passwor) VALUES
(1,'adm','123'),
(2,'pedrozz','10'),
(10,'pepeu','20')

INSERT INTO fornecedor (id,nome,telefone) VALUES
(4,'burns',11111111),
(9,'aang',22222222)

INSERT INTO cliente (id,nome,logradouro,numero,bairro,telefone,cpf) VALUES
(5,'Oscar Alho','av 23',157,'se',11111111,11111111111)--,
--(25,'Paula Tejando','rua cachueira',420,'cracolandia',11111111,11111111111),
--(26,'Pedro','rua chua',4,'cracolandia',222222,222222),
--(27,'Oscar','rua eira',500,'cracolandia',333333,333333),
--(28,'Alho','rua cac',600,'cracolandia',4444444,4444444),
--(29,'Cebola','rua c',800,'cracolandia',5555555,5555555),
--(30,'Suzi','rua',150,'cracolandia',666666,6666666)

INSERT INTO produto (nome,descricao,id_fornecedor,valor_venda,valor_compra,quantidade) VALUES
('Petimax','ração para cachorro',4,10.00,5.00,5),
('bonix','ossinhos para cachorro',9,2.00,1.00,50)

INSERT INTO lote (data_validade) VALUES
('20-06-15'),
('20-07-15'),
('10-08-15'),
('10-09-15')

INSERT INTO lote_produto(idProduto,idLote) VALUES
(1,1),
(1,2),
(2,3),
(2,4)

insert into venda (id_cliente,id_funcionario,total)
 values (5,1,50.00)

 insert into venda_produto(id_venda,id_produto,data_venda,quantidade)
 values(1,1,'10-06-15',10)

------------------------

use master
drop database ludpet

insert into cliente (id, nome, logradouro, numero, bairro, telefone) values
	(5, 'Pedro', 'Rua da boa vista', 400, 'mooca', 12122334)

insert into animal (id_cliente, rga, nome, raca, especie, sexo, cor) values
	(5, 1223344, 'logan', 'husky', 'cachorro', 'M', 'Branco')
	
select nome as nome, logradouro + ', ' + cast(numero as varchar(9))
	+ ', ' + bairro as endereço_completo, telefone
	from cliente
	order by nome

select lot.data_validade, lot.id as id_lote
from lote lot
inner join lote_produto lp
on lot.id = lp.idLote
inner join produto prod
on prod.id = lp.idProduto
where prod.id = 1
order by prod.id

	
--Nome do cliente e Quantos produtos cada um comprou ordenado pela quantidade

Select cli.nome, COUNT(prod.codigo) as qtde
from cliente cli
inner join venda ven
on cli.cpf = ven.cliente
inner join produto prod
on ven.produto = prod.codigo
group by cli.nome
order by qtde

	
