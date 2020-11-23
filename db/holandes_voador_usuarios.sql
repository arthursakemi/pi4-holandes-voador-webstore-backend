USE holandes_voador;

create table usuarios
(
    id    int auto_increment
        primary key,
    nome  varchar(100) not null,
    cpf   varchar(11)  not null,
    email varchar(50)  not null,
    senha varchar(255) not null,
    cargo varchar(50)  not null,
    ativo boolean      not null,
    constraint cpf
        unique (cpf),
    constraint email
        unique (email)
);

INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (1, 'Arthur Sakemi', '12345678900', 'arthur@mail.com', '$2a$10$RRARi3G6odKlSYRW0R7qCOk4bILMXVaJXKIPqc6Uu6cGlESWjcyhW', 'admin', 1);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (3, 'Marcelo Braga', '12345678911', 'marcelo@mail.com', '$2a$10$31daF9Wu8ytp5fwz6T5KkO.Sr7LaMbSTUg7oDe4Onpo9.bNQmOFVq', 'admin', 1);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (4, 'Diogo Souza', '12345678922', 'diogo@mail.com', '$2a$10$31daF9Wu8ytp5fwz6T5KkO.Sr7LaMbSTUg7oDe4Onpo9.bNQmOFVq', 'admin', 1);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (12, 'BCrypt Test', '12345678944', 'bcrypt@mail.com', '$2a$10$31daF9Wu8ytp5fwz6T5KkO.Sr7LaMbSTUg7oDe4Onpo9.bNQmOFVq', 'admin', 0);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (13, 'Arthur Sakemi', '12345678999', 'arthursakemi@mail.com', '$2a$10$M6ePu3k9af4n.90vSWO8gu312IFKM2GGSSyExYDaa5OvPeWlVfL2e', 'estoquista', 0);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (14, 'Japa Japa', '87965432155', 'japa@mail.com', '$2a$10$LDSBdhTrBpthJWn05CKs7Ox9Kkv5Oz8L2RcH8IyTZ5R25vQM2tKf6', 'estoquista', 1);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (15, 'Leonildo', '99988855548', 'leonildo@mail.com', '$2a$10$dv.L81yY3odWyQAyBihOaO3P.1Mk5RhNL8Ba01WIJK/v/6Md2MHw2', 'admin', 1);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (17, 'Marcelo', '22855866848', 'marcelin@mail.com', '$2a$10$h54Fu.cmqQJfKqR7Pnu1.ummJW.CXopo2k81QqyR5gPPGH2vhoCOy', 'admin', 0);
INSERT INTO holandes_voador.usuarios (id, nome, cpf, email, senha, cargo, ativo) VALUES (19, 'Robert', '45678912355', 'bob@mail.com', '$2a$10$PH0HZrsnVXmzM734HSuvseXtuw8m9FC7aXcqMYqLCUfzLgwPhYTJi', 'estoquista', 1);