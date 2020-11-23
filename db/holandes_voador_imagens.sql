create table imagens
(
    id         int auto_increment
        primary key,
    id_produto int          not null,
    imagem     varchar(100) not null,
    constraint imagens_ibfk_1
        foreign key (id_produto) references produtos (id)
);

create index id_produto
    on imagens (id_produto);

INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (7, 2, 'https://i.imgur.com/E6iioYu.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (8, 2, 'https://i.imgur.com/Zd3Fs4k.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (9, 2, 'https://i.imgur.com/Ry8ImvZ.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (20, 1, 'https://i.imgur.com/enyGWWB.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (23, 3, 'https://i.imgur.com/UDW8Ydr.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (24, 3, 'https://i.imgur.com/HMg5fKY.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (25, 4, 'https://i.imgur.com/epsOlWq.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (26, 4, 'https://i.imgur.com/yoCiPVP.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (27, 5, 'https://i.imgur.com/hgGNHOy.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (28, 5, 'https://i.imgur.com/Cfei9s6.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (29, 6, 'https://i.imgur.com/lSpwems.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (30, 6, 'https://i.imgur.com/ApZdp1s.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (31, 6, 'https://i.imgur.com/t950dtU.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (32, 7, 'https://i.imgur.com/d5d4Pdb.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (33, 7, 'https://i.imgur.com/DJdytw1.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (34, 7, 'https://i.imgur.com/1iJ8I7J.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (35, 7, 'https://i.imgur.com/zJody46.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (36, 8, 'https://i.imgur.com/h7281Fz.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (37, 8, 'https://i.imgur.com/UOAhQZX.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (38, 9, 'https://i.imgur.com/5LRpoig.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (39, 9, 'https://i.imgur.com/i3gq38Q.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (40, 10, 'https://i.imgur.com/nU3Bd2O.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (41, 10, 'https://i.imgur.com/oYYsRui.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (42, 10, 'https://i.imgur.com/Mc95eU8.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (43, 11, 'https://i.imgur.com/kuTVydr.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (44, 11, 'https://i.imgur.com/IxkiVWl.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (45, 11, 'https://i.imgur.com/ATMvRGG.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (58, 12, 'https://i.imgur.com/5vKrKr8.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (59, 12, 'https://i.imgur.com/p5hfgUG.jpg');
INSERT INTO holandes_voador.imagens (id, id_produto, imagem) VALUES (60, 12, 'https://i.imgur.com/gBJNpTl.jpg');