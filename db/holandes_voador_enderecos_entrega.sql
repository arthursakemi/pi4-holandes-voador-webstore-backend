create table enderecos_entrega
(
    id          int auto_increment
        primary key,
    id_cliente  int not null,
    id_endereco int not null,
    constraint enderecos_entrega_ibfk_1
        foreign key (id_cliente) references clientes (id),
    constraint enderecos_entrega_ibfk_2
        foreign key (id_endereco) references enderecos (id)
);

create index id_cliente
    on enderecos_entrega (id_cliente);

create index id_endereco
    on enderecos_entrega (id_endereco);

INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (3, 3, 8);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (5, 5, 12);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (7, 6, 15);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (8, 8, 18);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (10, 3, 20);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (11, 9, 22);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (12, 10, 24);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (13, 11, 26);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (14, 12, 28);
INSERT INTO holandes_voador.enderecos_entrega (id, id_cliente, id_endereco) VALUES (15, 12, 29);