CREATE TABLE MANUFACTURER
(
    ID   BIGSERIAL    NOT NULL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,

    UNIQUE (NAME)
);

CREATE TABLE PRODUCT
(
    ID               BIGSERIAL      NOT NULL PRIMARY KEY,
    TITLE            VARCHAR(255)   NOT NULL,
    COST             DECIMAL(10, 2) NOT NULL,
    MANUFACTURE_DATE DATE           NOT NULL,
    MANUFACTURER_ID  BIGINT,

    UNIQUE (TITLE),

    CONSTRAINT fk_manufacturer
        FOREIGN KEY (MANUFACTURER_ID)
            REFERENCES MANUFACTURER (ID)
);

ALTER table product
    add column MANUFACTURE_DATE DATE NOT NULL;

ALTER TABLE PRODUCT
    ADD COLUMN VERSION            INT NOT NULL DEFAULT 0,
    ADD COLUMN CREATED_BY         VARCHAR(255),
    ADD COLUMN CREATED_DATE       TIMESTAMP,
    ADD COLUMN LAST_MODIFIED_BY   VARCHAR(255),
    ADD COLUMN LAST_MODIFIED_DATE TIMESTAMP;

ALTER TABLE PRODUCT
    ADD COLUMN STATUS VARCHAR(30) NOT NULL DEFAULT 'ACTIVE';

SELECT name, p.id as product_id, title, cost, MANUFACTURE_DATE, MANUFACTURER_ID
FROM MANUFACTURER m
         INNER JOIN PRODUCT p on m.ID = p.MANUFACTURER_ID
WHERE m.id = 3;

SELECT p.id, title, m.id as manufacturer_id, m.NAME as manufacturer_name, COST, MANUFACTURE_DATE
FROM PRODUCT p
         INNER JOIN MANUFACTURER M on p.MANUFACTURER_ID = M.ID
where p.id = 40;

select *
from MANUFACTURER
where id = 12;

select *
from PRODUCT
order by id desc
limit 3;

delete
from PRODUCT
where id = 45;

select *
from PRODUCT;

create table cart
(
    ID     BIGSERIAL not null primary key,
    STATUS varchar(255) default 'not empty'

);

create table cart_product
(
    cart_id    bigint not null,
    product_id bigint not null,
    primary key (cart_id, product_id),
    constraint fk_cart_product_cart
        foreign key (cart_id)
            references cart (ID),

    constraint fk_cart_product_product
        foreign key (product_id)
            references product (id)
);

select *
from cart_product;