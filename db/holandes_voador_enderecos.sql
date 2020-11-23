create table enderecos
(
    id          int auto_increment
        primary key,
    cep         varchar(8)   not null,
    endereco    varchar(100) not null,
    numero      int          not null,
    complemento varchar(50)  null,
    cidade      varchar(50)  not null,
    uf          varchar(2)   not null,
    bairro      varchar(50)  not null
);

INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (7, '04437030', 'Rua 1', 99, 'Bloco 9', 'Cidade 1', 'C1', 'Bairro 1');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (8, '04437040', 'Rua 2', 88, 'Bloco 8', 'Cidade 2', 'C2', 'Bairro 2');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (11, '04437030', 'Rua 1', 99, 'Bloco 9', 'Sao Paulo', 'SP', 'Bairro 1');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (12, '04437040', 'Rua 2', 88, 'Bloco 8', 'Sao Paulo', 'SP', 'Bairro 1');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (14, '04437030', 'Rua João da Rocha', 99, null, 'São Paulo', 'SP', 'Jardim Consórcio');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (15, '04437030', 'Rua João da Rocha', 99, null, 'São Paulo', 'SP', 'Jardim Consórcio');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (17, '04437030', 'Rua João da Rocha', 44, null, 'São Paulo', 'SP', 'Jardim Consórcio');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (18, '04437030', 'Rua João da Rocha', 44, null, 'São Paulo', 'SP', 'Jardim Consórcio');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (20, '04437030', 'Rua João da Rocha', 888, '', 'São Paulo', 'SP', 'Jardim Consórcio');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (21, '05574007', 'Rua Elizabetha Kisberi', 222, null, 'São Paulo', 'SP', 'Butantã');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (22, '05574007', 'Rua Elizabetha Kisberi', 22, null, 'São Paulo', 'SP', 'Butantã');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (23, '04844300', 'Rua Giuseppe Tartini', 15, null, 'São Paulo', 'SP', 'Jardim São Bernardo');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (24, '04844300', 'Rua Giuseppe Tartini', 15, null, 'São Paulo', 'SP', 'Jardim São Bernardo');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (25, '07428070', 'Rua Almandina', 333, null, 'Arujá', 'SP', 'Jardim Fazenda Rincão');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (26, '07428070', 'Rua Almandina', 333, null, 'Arujá', 'SP', 'Jardim Fazenda Rincão');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (27, '03274110', 'Rua Advogado Modesto Naclério Homem', 123, null, 'São Paulo', 'SP', 'Vila Santa Clara');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (28, '03274110', 'Rua Advogado Modesto Naclério Homem', 123, null, 'São Paulo', 'SP', 'Vila Santa Clara');
INSERT INTO holandes_voador.enderecos (id, cep, endereco, numero, complemento, cidade, uf, bairro) VALUES (29, '12712450', 'Rua Maria de Lourdes Sampaio', 123, '', 'Cruzeiro', 'SP', 'Retiro da Mantiqueira');