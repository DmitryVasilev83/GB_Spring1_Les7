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
    MANUFACTURER_ID  BIGINT         NOT NULL,

    UNIQUE (TITLE),

    CONSTRAINT fk_manufacturer
        FOREIGN KEY (MANUFACTURER_ID)
            REFERENCES MANUFACTURER (ID)
);


CREATE TABLE CART
(
    ID     BIGSERIAL NOT NULL PRIMARY KEY,
    STATUS VARCHAR(255) DEFAULT 'not empty'
);


CREATE TABLE CART_PRODUCT
(
    CART_ID    BIGINT NOT NULL,
    PRODUCT_ID BIGINT NOT NULL,

    PRIMARY KEY (CART_ID, PRODUCT_ID),

    CONSTRAINT fk_cart_product_cart
        FOREIGN KEY (CART_ID)
            REFERENCES CART (ID),

    CONSTRAINT fk_cart_product_product
        FOREIGN KEY (PRODUCT_ID)
            REFERENCES PRODUCT (ID)
);

ALTER TABLE PRODUCT
ADD COLUMN VERSION                INT NOT NULL DEFAULT 0,
ADD COLUMN CREATED_BY             VARCHAR(255),
    ADD COLUMN CREATED_DATE       TIMESTAMP,
    ADD COLUMN LAST_MODIFIED_BY   VARCHAR(255),
    ADD COLUMN LAST_MODIFIED_DATE TIMESTAMP;

select * from PRODUCT where title = 'Shrimp';

ALTER TABLE PRODUCT
ADD COLUMN STATUS VARCHAR(20) NOT NULL DEFAULT 'ACTIVE';

select * from PRODUCT order by desc;


