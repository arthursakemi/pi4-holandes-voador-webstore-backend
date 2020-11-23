create table clientes
(
    id          int auto_increment
        primary key,
    nome        varchar(100) not null,
    cpf         varchar(11)  not null,
    email       varchar(50)  not null,
    senha       varchar(255) not null,
    cargo       varchar(50)  not null,
    id_endereco int          not null,
    ativo       boolean      not null,
    constraint cpf
        unique (cpf),
    constraint email
        unique (email),
    constraint clientes_ibfk_1
        foreign key (id_endereco) references enderecos (id)
);

create index endereco
    on clientes (id_endereco);

INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (3, 'Arthur Sakemi', '12345678911', 'arthur@mail.com', '$2a$10$ECjigpT2l3aSoTqG/j3Hn.3YbLw1QhuvtLwhUgdIM1THSPHeRB51u', 'cliente', 7, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (5, 'Marcelo Braga', '12345678922', 'marcelo@mail.com', '$2a$10$CWC4aFGyHmC7lGwfKRbAbeGkyh66mKgTqe4IpsOVwt2qhCzqs18pe', 'cliente', 11, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (6, 'Diogo Cunha', '65498765455', 'diogo@mail.com', '$2a$10$lRfJXjDYo7RUbBoNhmwjR.jHAcLU8yFJys0pgP.djaIDRzbeztkBS', 'cliente', 14, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (8, 'Patricia Oliveira', '82828282900', 'patricia@mail.com', '$2a$10$dpX57cB0BnT.mTDT.nFF2.E/RjnLLnwpHv7GYqVZigD7JqTcZ/WLO', 'cliente', 17, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (9, 'Cliente Teste', '45698732155', 'teste@mail.com', '$2a$10$sRxmnzCkGsVMBKI5SCFV1eIsJmPv7Ui8.OS3QR3X0kH49NFa1Ka0O', 'cliente', 21, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (10, 'Marcelo Arthur', '22860545829', 'marcelo@mail.com.br', '$2a$10$CWC4aFGyHmC7lGwfKRbAbeGkyh66mKgTqe4IpsOVwt2qhCzqs18pe', 'cliente', 23, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (11, 'Arthur Japa', '36542368543', 'japa@mail.com', '$2a$10$5qlRthmekgzy2RqfoUDOLuJkPfuWnUQ6ga6H0fArQaDsvhMsk.hsS', 'cliente', 25, 1);
INSERT INTO holandes_voador.clientes (id, nome, cpf, email, senha, cargo, id_endereco, ativo) VALUES (12, 'Marcelinho Contos Filho', '65498765411', 'marcelinho@mail.com', '$2a$10$cbNOWXaZVZ8Uf6ZWDUwSIut.DOSqjKYmfGPYp53KPIudfyw9mv8dm', 'cliente', 27, 1);