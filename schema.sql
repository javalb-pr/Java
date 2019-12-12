CREATE DATABASE products;

USE products;

CREATE TABLE product (
                         id_product int(11) NOT NULL AUTO_INCREMENT,
                         name varchar(100) NOT NULL,
                         product_group_id int(11) NOT NULL,
                         description varchar(255) NOT NULL,
                         releaseDate varchar (50) NOT NULL,
                         FOREIGN KEY (product_group_id) REFERENCES product_group (id_product_group),
                         PRIMARY KEY (id_product)
) ENGINE=InnoDB;

CREATE TABLE product_group (
                               id_product_group int(11) NOT NULL AUTO_INCREMENT,
                               product_group_name varchar(100) NOT NULL,
                               param_group_id int(11) NOT NULL,
                               FOREIGN KEY (param_group_id) REFERENCES param_group (id_param_group),
                               PRIMARY KEY (id_product_group)
) ENGINE=InnoDB;

CREATE TABLE param_group (
                             id_param_group int(11) NOT NULL AUTO_INCREMENT,
                             param_group_name varchar(100) NOT NULL,
                             PRIMARY KEY (id_param_group)
) ENGINE=InnoDB;

CREATE TABLE param (
                       id_param int(11) NOT NULL AUTO_INCREMENT,
                       unit_of_measurement varchar(25) NOT NULL,
                       PRIMARY KEY (id_param)
) ENGINE=InnoDB;

CREATE TABLE params_in_groups(
                                 param_group_id int(11) NOT NULL,
                                 param_id int(11) NOT NULL,
                                 PRIMARY KEY (param_group_id, param_id)
) ENGINE=InnoDB;

ALTER TABLE params_in_groups
  ADD CONSTRAINT params_in_groups_grp_fk FOREIGN KEY (param_group_id) REFERENCES param_group (id_param_group);
ALTER TABLE params_in_groups
  ADD CONSTRAINT params_in_groups_prm_fk FOREIGN KEY (param_id) REFERENCES param (id_param);


INSERT INTO products.param (id_param, unit_of_measurement) VALUES (1, 'meter');
INSERT INTO products.param (id_param, unit_of_measurement) VALUES (2, 'second');
INSERT INTO products.param (id_param, unit_of_measurement) VALUES (3, 'day');
INSERT INTO products.param (id_param, unit_of_measurement) VALUES (4, 'year');
INSERT INTO products.param (id_param, unit_of_measurement) VALUES (5, 'kilogram');

INSERT INTO products.param_group (id_param_group, param_group_name) VALUES (1, 'physical');
INSERT INTO products.param_group (id_param_group, param_group_name) VALUES (2, 'time');
INSERT INTO products.param_group (id_param_group, param_group_name) VALUES (3, 'taste');

INSERT INTO products.params_in_groups (param_group_id, param_id) VALUES (1, 1);
INSERT INTO products.params_in_groups (param_group_id, param_id) VALUES (1, 5);
INSERT INTO products.params_in_groups (param_group_id, param_id) VALUES (2, 2);
INSERT INTO products.params_in_groups (param_group_id, param_id) VALUES (2, 3);
INSERT INTO products.params_in_groups (param_group_id, param_id) VALUES (2, 4);

INSERT INTO products.product_group (id_product_group, product_group_name, param_group_id) VALUES (1, 'phone', 1);
INSERT INTO products.product_group (id_product_group, product_group_name, param_group_id) VALUES (2, 'vacation', 2);

INSERT INTO products.product (id_product, name, product_group_id, description, releaseDate) VALUES (1, 'Iphnoe', 1, 'created by apple', '12-12-2020');
INSERT INTO products.product (id_product, name, product_group_id, description, releaseDate) VALUES (2, 'Vacation on the sea', 2, 'main summers''s tourism product', '15-05-2020');