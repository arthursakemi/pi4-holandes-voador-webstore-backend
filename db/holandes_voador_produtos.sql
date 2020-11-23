create table produtos
(
    id             int auto_increment
        primary key,
    nome           varchar(50)  not null,
    marca          varchar(50)  not null,
    categoria      varchar(20)  not null,
    valor          double       not null,
    p              int          not null,
    m              int          not null,
    g              int          not null,
    unico          int          not null,
    descricao      text         null,
    palavras_chave varchar(255) null,
    ativo          boolean      not null
);

INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (1, 'Camiseta Branca', 'Hering', 'Masculino', 29.9, 10, 6, 11, 0, 'Camiseta branca, gola careca sem estampa.', 'camiseta basica', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (2, 'Cropped Jeans', 'Handbook', 'Casacos', 199, 10, 2, 5, 0, 'Jaqueta confeccionada em tecido jeans estonada lavagem média.
Sua modelagem cropped, bolsos frontais , botões encapado, costura na linha cor ocre, barra desfiada.
A única jaqueta que não pode faltar no armário, combina com tudo, para o look casual, o look descolado, look ofice.
Composição: 100% Algodão', 'Jaqueta Jeans Cropped', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (3, 'Blusão cinza', 'git', 'Casacos', 50, 2, 4, 5, 2, 'Blusa que dá o atributo de estrutura de dados', 'Blusa Moletom', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (4, 'Calça Jeans', 'FATAL', 'Masculino', 99, 10, 5, 5, 0, 'Calça Jeans Skinny', 'Jeans Skinny', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (5, 'Calça Sarja Preta', 'FATAL', 'Masculino', 89, 10, 22, 50, 0, 'Calça Sarja Preta', 'Calça Sarja Preta', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (6, 'Jaqueta Corta Vento', 'AMBER', 'Casacos', 150, 5, 10, 15, 0, 'Jaqueta Corta vento Rosa e preto com detalhes camuflados.', 'Corta-vento preto rosa camuflado Amber', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (7, 'Jaqueta Vintage', 'Handbook', 'Casacos', 199, 10, 8, 7, 0, 'Jaqueta confeccionada em confeccionada tecido com toque aveludado aspecto lavado.
Sua modelagem quadrada, com bolsos frontais quadrado e lapela e fechamento botão, abertura frontal com fechamento botões , barra larga com elástico embutido , manga longa com punho largo e elástico embutido.
Aquela jaqueta que salva o dia, perfeita para usar com uma pantalona ou mesmo com uma calça skynny, muito casual, para usar todos os dias.
Composição: 95% Poliéster 5% Poliamida', 'Jaqueta Vintage Poliester', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (8, 'Analogico 5050 Tuguir', 'Tuguir', 'Acessórios', 100, 0, 0, 0, 5, 'Relogio Analogico Cinza Tuguir 5050', 'Tuguir Relogio Analogico Cinza', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (9, 'Camiseta Caveira', 'JOSS', 'Feminino', 50, 3, 5, 10, 0, 'Camiseta Feminina Básica Joss com caimento reto estampa em silk, máxima qualidade e conforto para o seu dia a dia.', 'Camiseta Caveira Preta', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (10, 'Boné Element', 'ELEMENT', 'Acessórios', 150, 0, 0, 0, 5, 'Boné preto e amarelo Element', 'Boné Aberto Element Preto Amarelo', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (11, 'Blusa Hora da Diva', 'Hora da Diva', 'Feminino', 60, 4, 4, 2, 0, 'Blusa de Diva confeccionada em musseline com lycra na cor branca. Tecido leve, com suave transparência e toque macio. Super elegante e charmosa possui ombros drapeados, mangas bufantes e punhos bem românticos com lastex. Golinha alta também com lastex. Composição 95% poliéster, 5% lycra. PP veste manequim 34 . P veste manequim 36-38. M veste manequim 38-40 G veste manequim 42-44. GG veste manequim 46-48.', 'Branca Gola-alta', 1);
INSERT INTO holandes_voador.produtos (id, nome, marca, categoria, valor, p, m, g, unico, descricao, palavras_chave, ativo) VALUES (12, 'Jaqueta Bomber', 'Handbook', 'Casacos', 299, 12, 12, 10, 0, 'Jaqueta confeccionada em tecido de cetim.
Sua modelagem bomber curtinha,gola padre, manga longa de punho de elástico, bolso faca lateral, fechamento zíper metal frontal, elástico embutido traseiro.
Aquela jaqueta que todos nos precisamos ter, perfeita para usar com vestido ou calça jeans, para uma balada um dia no escritório , um passeio no shopping , ou seja ela te acompanha para todos os lugares.', 'Jaqueta Bomber Cetim', 1);