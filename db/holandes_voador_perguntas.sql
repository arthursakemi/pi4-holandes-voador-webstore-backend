create table perguntas
(
    id         int auto_increment
        primary key,
    id_produto int          not null,
    pergunta   varchar(255) not null,
    resposta   varchar(255) not null,
    constraint perguntas_ibfk_1
        foreign key (id_produto) references produtos (id)
);

create index id_produto
    on perguntas (id_produto);

INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (1, 1, 'Pergunta 1', 'Resposta 1');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (2, 1, 'Pergunta 2', 'Resposta 2');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (5, 2, 'É jeans?', 'Sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (6, 2, 'É 100% algodão?', 'Sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (7, 3, 'azul?', 'nao');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (8, 3, 'tem pra gordao?', 'tem');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (14, 4, 'Se lavar encolhe?', 'Não');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (15, 4, 'Tem possibilidade de troca?', 'Sim.');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (16, 5, 'O tecido desbota?', 'Depois de um tempo, é inevitável.');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (17, 6, 'Tem garantia para troca?', 'Sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (18, 7, 'Desbota com facilidade?', 'Não');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (19, 7, 'O tecido é leve?', 'Sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (20, 8, 'Tem resistência a agua?', 'Sim, 10m.');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (21, 9, 'É de algodão?', 'Sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (22, 10, 'Há garantia para trocas?', 'Sim. Apenas para defeitos de fábrica.');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (23, 11, 'Há a possibilidade de troca?', 'Sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (25, 12, 'É Cetim?', 'sim');
INSERT INTO holandes_voador.perguntas (id, id_produto, pergunta, resposta) VALUES (26, 12, 'É impermeável?', 'Sim');