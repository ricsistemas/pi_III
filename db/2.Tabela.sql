CREATE TABLE usuarios
(
	id  int  AUTO_INCREMENT  NOT NULL ,
	email  varchar(30)  NOT NULL ,
	senha  varchar(10)  NOT NULL ,
	isdelete  integer  not NULL ,
	user_delete  integer  NULL ,
	dt_delete  datetime  NULL,
   primary key(id));
   
      
CREATE TABLE clientes
(
	id  int  AUTO_INCREMENT  NOT NULL ,
	nome_completo  varchar(60)  NOT NULL ,
	cpf  varchar(15)  NOT NULL ,
	rg  varchar(15)   NULL ,
	celular  varchar(11)  NULL ,
	telefone  varchar(11)  NULL ,
	dt_nascimento  datetime  NULL ,
	isdelete  integer  NULL ,
	usuario_id  integer  NULL ,
	dt_delete  datetime  NULL ,
	user_delete  integer  NULL ,
	genero  varchar(1)  NULL ,
	primary key(id),
	    
	CONSTRAINT  PK_usuarios 
	   FOREIGN KEY (usuario_id)
	   REFERENCES Usuarios(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE enderecos
(
	id  int  AUTO_INCREMENT  NOT NULL ,
	Cep  varchar(10)  NOT NULL ,
	logradouro  varchar(60)  NOT NULL ,
	Estado  varchar(20)  NOT NULL ,
	Cidade  varchar(20)  NOT NULL ,
	Bairro  varchar(20)  NOT NULL ,
	Complemento  varchar(15)  NOT NULL ,
	Local_Descricao  varchar(15)  NOT NULL ,
	isdelete  integer  NULL ,
	cliente_id  int NULL ,
	user_delete  integer  NULL ,
	dt_delete  datetime  NULL ,
	principal  integer  NULL ,
	numero  integer  NULL ,
	primary key(id),
  	CONSTRAINT  PK_enderecos 
	   FOREIGN KEY (cliente_id)
	  REFERENCES clientes(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE grupos
(
	id  int  AUTO_INCREMENT  NOT NULL ,
	Descricao  varchar(15)  NOT NULL ,
	user_delete  integer  NULL ,
	dt_delete  datetime  NULL ,
	isdelete  integer  NOT NULL, 
		primary key(id));	
	
CREATE TABLE Produtos
(
	id  int AUTO_INCREMENT  NOT NULL ,
	Descricao  varchar(60)  NULL ,
	Qtd  integer  NULL ,
	Custo  decimal(14,2)  NULL ,
	Preco  decimal(14,2)  NULL ,
	isdelete  integer not NULL ,
	grupo_id  int not  NULL ,
	dt_delete  datetime  NULL ,
	user_delete  integer  NULL ,
	primary key(id),
	CONSTRAINT  PK_grupos 
	FOREIGN KEY (grupo_id)
	REFERENCES grupos(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE Pedidos
(
	id  int  AUTO_INCREMENT  NOT NULL ,
	dt_pedido  integer not  NULL ,
	dat_entrega  integer  NULL ,
	status  integer not  NULL ,
	dt_baixa  datetime  NULL ,
	baixa  integer not NULL ,
	user_baixa  integer  NULL ,
	cliente_id  int not  NULL ,
	isdelete  integer  NULL ,
	user_delete  integer  NULL ,
	dt_delete  datetime  NULL ,
	vl_pedido  decimal(14,2)  NULL ,
	form_pag  varchar(1) not NULL,
    primary key(id),
	INDEX fk_pedidos_cliente_idx (cliente_id),
	CONSTRAINT  PK_pedidos
	FOREIGN KEY (cliente_id)
	REFERENCES Clientes(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




   