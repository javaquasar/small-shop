delete from sub_category_attribute_type;
delete from attribute_type;

delete from product;
delete from sub_category;
delete from category;

delete from user_permission;
delete from user_info;
delete from role_permission;
delete from role;
delete from permission;

insert into category (id, title) values
(1, 'First category'),
(2, 'Second category'),
(3, 'Third category');

insert into sub_category (id, title, category_id) values
  (1, 'first in first sub cat', 1),
  (2, 'second in first sub cat', 1),
  (3, 'first in second sub cat', 2),
  (4, 'second in second sub cat', 2);

insert into product (id, name, sub_category_id) values
  (1, 'first product in first_first sub cat', 1),
  (2, 'second product in first_first sub cat', 1),
  (3, 'third product in first_first sub cat', 1);

insert into attribute_type (id, name, type) values
  (1, 'first attr type', 'STRING'),
  (2, 'second attr type', 'STRING'),
  (3, 'third attr type', 'STRING');

insert into attribute (id, numeric_value, string_value, attribute_type_id) values
  (1, null, 'first_first', 1),
  (2, null, 'first_second', 1),
  (3, null, 'second_first', 2),
  (4, null, 'second_second', 3);

insert into product_attribute (product_id, attributes_id) values
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 3);

insert into sub_category_attribute_type (sub_category_id, attribute_type_id) values
  (1, 1),
  (1, 2),
  (1, 3);