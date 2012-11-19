SET DATABASE SQL SYNTAX ORA TRUE;

CREATE TABLE CUSTOMER (
  employee_id  NUMBER NOT NULL,
  CONSTRAINT pk_employee_id PRIMARY KEY (employee_id)
);

CREATE TABLE PRODUCT_ITEM (
  product_id  NUMBER NOT NULL,
  product_sku VARCHAR(10),
  CONSTRAINT pk_product_id PRIMARY KEY (product_id)
);

CREATE TABLE CUSTOMER_ORDER (
  order_id NUMBER NOT NULL,
  created DATE NOT NULL,
  CONSTRAINT pk_order_id PRIMARY KEY (order_id),
);

CREATE TABLE CUSTOMER_ORDER_ITEM (
  order_item_id NUMBER NOT NULL,
  order_id NUMBER NOT NULL,
  product_id NUMBER NOT NULL,
  quantity NUMBER NOT NULL,
  CONSTRAINT pk_order_item_id PRIMARY KEY (order_item_id),
  CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES customer_order(order_id),
  CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product_item(product_id),
);

CREATE SEQUENCE CUSTOMER_ORDER_SEQ;

CREATE SEQUENCE CUSTOMER_ORDER_ITEM_SEQ;

CREATE SEQUENCE PRODUCT_ITEM_SEQ;


