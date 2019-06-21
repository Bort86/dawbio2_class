/* mysql -u root -p */

CREATE DATABASE mvc_pdo DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

/* ALTER DATABASE mvc_pdo DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; */


/* linux */
CREATE USER 'provenusr' IDENTIFIED BY 'Provenpass1.';
GRANT ALL PRIVILEGES ON proven.* TO 'provenusr';

USE mvc_pdo;

DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS product;

CREATE TABLE category
(
    id          INT(4)       NOT NULL AUTO_INCREMENT,
    name       VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
)
ENGINE = INNODB DEFAULT CHARSET=utf8;

CREATE TABLE product
(
    id          INT(4)       NOT NULL AUTO_INCREMENT,
    name       VARCHAR(150) NOT NULL,
    price     DECIMAL     NOT NULL ,
    description     TEXT         NOT NULL,
    category    INT(4), 
    PRIMARY KEY (id),
    foreign key (category) references category(id)
)
ENGINE = INNODB DEFAULT CHARSET=utf8;

DELETE FROM category;


