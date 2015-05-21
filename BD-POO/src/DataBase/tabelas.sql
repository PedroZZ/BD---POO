create database ludpet

use ludpet

create table tipo(
id int identity not null,
descricao varchar(50) not null
primary key(id)) 

create table pessoa(
idPessoa int identity not null,
idTipo int not null
primary key(idPessoa),
foreign key(idTipo) references tipo(id))

create table telefone(
numero varchar(9) not null,
idPessoa int not null,
idTipo int not null 
primary key(numero, idPessoa, idTipo)
foreign key(idPessoa) references pessoa(idPessoa),
foreign key(idTipo) references tipo(id))

create table cliente(
id int identity not null,
nome varchar(60) not null,
logradouro varchar(100) not null,
numero int not null,
bairro varchar(60) not null,
senha int null
primary key(id),
foreign key(id) references pessoa(idPessoa))

create table funcionario(
id int identity not null,
cpf varchar(11) not null,
nome varchar(50) not null,
cargo varchar(50) not null,
salario decimal (7,2) not null
primary key (id),
foreign key(id) references pessoa(idPessoa))

create table fornecedor(
id int identity not null,
nome varchar(60) not null 
primary key(id),
foreign key(id) references pessoa(idPessoa))

create table venda(
id int identity not null,
id_cliente int not null,
id_funcionario int not null
primary key(id, id_cliente),
foreign key(id_cliente) references cliente(id),
foreign key(id_funcionario) references funcionario(id),
)

create table animal(
id int identity not null,
id_cliente int not null,
rga int not null,
nome varchar(60) not null,
raca varchar(50) not null,
especie varchar(50) null,
cor varchar(50) null
primary key (id, id_cliente),
foreign key (id_cliente) references cliente(id))

create table lote(
id int identity not null,
data_validade datetime not null
primary key(id))

create table produto(
id int identity not null,
nome varchar(60) not null,
descricao varchar(60),
id_fornecedor int not null,
valor_venda int not null,
valor_compra int not null,
id_lote int not null
primary key(id)
foreign key(id_fornecedor) references fornecedor(id),
)

create table lote_produto(
idProduto int not null,
idLote int not null,
primary key(idProduto, idLote),
foreign key(idLote)references lote(id),
foreign key(idProduto)references produto(id))


create table venda_produto(
data_venda datetime not null,
id_venda int not null,
id_cliente int not null,
id_produto int not null,
quantidade int not null,
total int not null,
check(data_venda <= getdate()),
primary key(data_venda, id_venda, id_cliente, id_produto),
foreign key(id_venda, id_cliente) references venda(id, id_cliente),
foreign key(id_produto) references produto(id))

create table compra(
id int identity not null,
id_funcionario int not null,
quantidade int not null,
total int not null
primary key(id, id_funcionario),
foreign key(id_funcionario) references funcionario(id))

create table compra_produto(
data_compra datetime not null,
id_compra int not null,
id_funcionario int not null,
id_produto int not null,
quantidade int not null,
total int not null,
check(data_compra <= getdate()),
primary key(data_compra, id_compra, id_funcionario, id_produto),
foreign key(id_compra, id_funcionario) references compra(id, id_funcionario),
foreign key(id_produto) references produto(id))


