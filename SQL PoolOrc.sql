/*Codigo SQL Para Oracle do DB PoolOrc*/

CREATE USER PoolOrc IDENTIFIED BY PoolOrcNWK;
GRANT CONNECT, RESOURCE TO PoolOrc;

CREATE TABLE Cliente(
id_cliente INT NOT NULL,
tipo_cliente VARCHAR(45)NULL,
nome_cliente VARCHAR(255) NULL,
cpf_cnpj_cliente VARCHAR(18) NULL,
rua_cliente VARCHAR(100) NULL,
bairro_cliente VARCHAR(50) NULL,
numero_end_cliente VARCHAR(8) NULL,
complemento_cliente VARCHAR(100) NULL,
cep_cliente CHAR(8) NULL,
cidade_cliente VARCHAR(45) NULL,
estado_cliente CHAR(2) NULL,
telefone_cliente VARCHAR(15) NULL,
celular_cliente VARCHAR(15) NULL,
email_cliente VARCHAR(50) NULL,
ativo_cliente CHAR(1) NOT NULL,
observacoes_cliente VARCHAR(500) NULL,
CONSTRAINT PK_Cliente_ID PRIMARY KEY(ID_Cliente));

CREATE TABLE Funcionario(
id_funcionario INT NOT NULL,
nome_funcionario VARCHAR(100) NULL,
cpf_funcionario VARCHAR(12) NULL,
datanasc_funcionario DATE NULL,
telefone_funcionario VARCHAR(15) NULL,
celular_funcionario VARCHAR(15) NULL,
email_funcionario VARCHAR(50) NULL,
rua_funcionario VARCHAR(100) NULL,
numero_funcionario VARCHAR(8) NULL,
bairro_funcionario VARCHAR(100) NULL,
complemento_funcionario VARCHAR(100) NULL,
cidade_funcionario VARCHAR(100) NULL,
estado_funcionario CHAR(2) NULL,
cep_funcionario CHAR(8) NULL,
numcarteiratrab_funcionario VARCHAR(7) NULL,
seriecarteiratrab_funcionario VARCHAR(7) NULL,
datacontra_funcionario DATE NULL,
datademiss_funcionario DATE NULL,
observacoes_funcionario VARCHAR(500) NULL,
CONSTRAINT PK_Funcionario_ID PRIMARY KEY(ID_Funcionario));

CREATE TABLE Produto(
cod_prod VARCHAR(9) NOT NULL,
cod_fabricante VARCHAR(15) NULL,
dat_cadastro DATE NULL,
descricao_pecas VARCHAR(255) NULL,
marca_pecas VARCHAR(100) NULL,
familia_pecas VARCHAR(100) NULL,
similar_pecas VARCHAR(100) NULL,
valor_compras DECIMAL(8,2) NULL,
valor_vendas DECIMAL(8,2) NULL,
porcentagem_venpecas DECIMAL(5,2) NULL,
observacoes_produto VARCHAR(500) NULL,
CONSTRAINT PK_Produto_Cod PRIMARY KEY(cod_prod));

CREATE TABLE Familia(
cod_familia INT NOT NULL,
descricao_familia VARCHAR(100) NOT NULL,
CONSTRAINT PK_Familia_Cod PRIMARY KEY (cod_familia));

CREATE TABLE Similar(
cod_similar INT NOT NULL,
descricao_similar VARCHAR(100) NOT NULL,
CONSTRAINT PK_Similar_Cod PRIMARY KEY (cod_similar));

CREATE TABLE Orcamento(
cod_orcamento INT NOT NULL ,
id_funcionario INT NOT NULL,
id_cliente INT NOT NULL,
data_orcamento DATE NULL,
sub_Total DECIMAL(8,2) NULL,
forma_pagamento VARCHAR(15) NULL,
desconto_valor DECIMAL(5,2) NULL,
total_orcamento DECIMAL(8,2) NULL,
orbservacoes_orcamento VARCHAR(500) NULL,
CONSTRAINT PK_Orcamento_Cod_Orc PRIMARY KEY(cod_orcamento),
CONSTRAINT FK_Cod_Func FOREIGN KEY (id_funcionario) REFERENCES Funcionario,
CONSTRAINT FK_Cod_Cli FOREIGN KEY (id_cliente) REFERENCES Cliente);

CREATE TABLE ItensOrcamento(
cod_orcamento INT NOT NULL,
cod_prod VARCHAR(9) NOT NULL,
quantidade DECIMAL(8,2) NOT NULL,
CONSTRAINT FK_iOrcamento_codOrc FOREIGN KEY (cod_orcamento) REFERENCES Orcamento,
CONSTRAINT FK_codProd FOREIGN KEY (cod_prod) REFERENCES Produto);

/*AutoIncrement*/
/*pt1: Sequencias*/

CREATE SEQUENCE cliente_id
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE funcionario_id
START WITH 1
INCREMENT BY 1;
  
CREATE SEQUENCE familia_id
START WITH 1
INCREMENT BY 1;
  
CREATE SEQUENCE similar_id
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE orcamento_id
START WITH 1
INCREMENT BY 1;

/*p2: Triggers*/

CREATE OR REPLACE TRIGGER trigger_cliente
BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
	SELECT cliente_id.nextval
	INTO :new.id_cliente
	FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_funcionario
BEFORE INSERT ON Funcionario
FOR EACH ROW
BEGIN
	SELECT funcionario_id.nextval
	INTO :new.id_funcionario
	FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_familia
BEFORE INSERT ON Familia
FOR EACH ROW
BEGIN
	SELECT familia_id.nextval
	INTO :new.cod_familia
	FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_similar
BEFORE INSERT ON Similar
FOR EACH ROW
BEGIN
	SELECT similar_id.nextval
	INTO :new.cod_similar
	FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_orcamento
BEFORE INSERT ON Orcamento
FOR EACH ROW
BEGIN
	SELECT orcamento_id.nextval
	INTO :new.cod_orcamento
	FROM dual;
END;

ALTER SEQUENCE cliente_id NOCACHE;
ALTER SEQUENCE familia_id NOCACHE;
ALTER SEQUENCE funcionario_id NOCACHE;
ALTER SEQUENCE orcamento_id NOCACHE;
ALTER SEQUENCE similar_id NOCACHE;