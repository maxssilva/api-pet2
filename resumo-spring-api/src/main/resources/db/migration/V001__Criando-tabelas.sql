create table cliente(
	 id_cliente bigint(11) not null AUTO_INCREMENT,
     nome varchar(255) not null,
     cpf varchar(11) not null unique,
     telefone varchar(12) not null,
     senha varchar(60) not null,

     primary key (id_cliente)
    );
create table produto(
	id_produto bigint(11) not null auto_increment,
    nome varchar(255) not null,
    quantidade integer(10) not null,

     primary key (id_produto)
);
create table pedido(
	id_pedido bigint(11) not null auto_increment,
    data_venda datetime not null,
    produto bigint(11) not null,
    pedido_por bigint(11) not null,

     primary key (id_pedido),

    foreign key (produto) references produto(id_produto),
    foreign key(pedido_por) references cliente(id_cliente)
    )