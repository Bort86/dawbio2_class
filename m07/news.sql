/* mysql -u root -p */

CREATE DATABASE proven DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

/* ALTER DATABASE proven DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; */


/* linux */
CREATE USER 'provenusr' IDENTIFIED BY 'Provenpass1.';
GRANT ALL PRIVILEGES ON proven.* TO 'provenusr';

USE proven;

DROP TABLE IF EXISTS news;

CREATE TABLE news
(
    id          INT(4)       NOT NULL AUTO_INCREMENT,
    title       VARCHAR(150) NOT NULL,
    pubdate     DATETIME     NOT NULL DEFAULT NOW(),
    content     TEXT         NOT NULL,
    category    ENUM ('Ciencia','Cultura','Deportes','Economía','Internacional','Política'),
    PRIMARY KEY (id)
)
ENGINE = INNODB DEFAULT CHARSET=utf8;

DELETE FROM news;

INSERT INTO news (title,pubdate,content,category) VALUES ('Samsung atribuye el incendio de sus dispositivos a los dos kilos de dinamita que insertó en cada Note 7',STR_TO_DATE('01/01/2015','%d/%m/%Y'),'Texto 1','Ciencia');
INSERT INTO news (title,pubdate,content,category) VALUES ('Académicos de la RAE mayores de 80 años proponen eliminar ''pene'' por falta de uso',STR_TO_DATE('10/02/2016','%d/%m/%Y'),'Texto 2','Cultura');
INSERT INTO news (title,pubdate,content,category) VALUES ('El Real Madrid, contento porque no le ha tocado la Agencia Tributaria en el cruce de Champions',STR_TO_DATE('20/03/2017','%d/%m/%Y'),'Texto 3','Deportes');
INSERT INTO news (title,pubdate,content,category) VALUES ('Rajoy advierte de que, si sigue lloviendo, la electricidad saldrá gratis',STR_TO_DATE('30/04/2015','%d/%m/%Y'),'Texto 4','Economía');
INSERT INTO news (title,pubdate,content,category) VALUES ('Una familia española lleva cinco años apadrinando a un dictador africano sin saberlo',STR_TO_DATE('01/05/2016','%d/%m/%Y'),'Texto 5','Internacional');
INSERT INTO news (title,pubdate,content,category) VALUES ('Donald Trump se ofrece a hacer de interlocutor entre Rajoy y Cataluña',STR_TO_DATE('10/06/2017','%d/%m/%Y'),'Texto 6','Política');
INSERT INTO news (title,pubdate,content,category) VALUES ('Los expertos en nutrición corrigen la Pirámide de los Alimentos para añadir Almax en todos los pisos',STR_TO_DATE('20/07/2015','%d/%m/%Y'),'Texto 7','Ciencia');
INSERT INTO news (title,pubdate,content,category) VALUES ('La gala de los Goya se celebrará en un Cash Converters',STR_TO_DATE('30/08/2016','%d/%m/%Y'),'Texto 8','Cultura');
INSERT INTO news (title,pubdate,content,category) VALUES ('Los sacos de boxeo empezarán a devolver los golpes',STR_TO_DATE('01/09/2017','%d/%m/%Y'),'Texto 9','Deportes');
INSERT INTO news (title,pubdate,content,category) VALUES ('Los jubilados que quieran cobrar la pensión tendrán que trabajar y percibir un sueldo',STR_TO_DATE('10/10/2015','%d/%m/%Y'),'Texto 10','Economía');
INSERT INTO news (title,pubdate,content,category) VALUES ('Detienen a un terrorista que pretendía acabar con el Gobierno con 23 tuits y 10 favs',STR_TO_DATE('20/11/2016','%d/%m/%Y'),'Texto 11','Internacional');
INSERT INTO news (title,pubdate,content,category) VALUES ('Murcia pide al Estado dos millones de euros para la construcción de un muñeco de nieve',STR_TO_DATE('30/12/2017','%d/%m/%Y'),'Texto 12','Política');
