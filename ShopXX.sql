create table shop_product (
  id character varying(10) not null
  , name character varying(50) not null
  , price integer not null
  , show_flg character varying(1) not null
  , del_flg character varying(1) not null
  , sort integer not null
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
  , primary key (id)
);

drop table shop_product;
