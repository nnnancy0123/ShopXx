create table shop_product (
  id  serial not null 
  , name character varying(50) not null
  , simple_desc character varying(300)
  , price integer not null
  , inventory integer not null
  , image character varying(300) not null
  , show_flg character varying(1)
  , del_flg character varying(1) 
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
  , primary key (id)
);

drop table shop_product;

select * from shop_product order by id asc;

insert into shop_product (id,name,simple_desc,price,inventory,image,show_flg,del_flg,date_created,date_modified)values(1,'jin','â¬à§Ç¢',100,20,'C:\image\1.jpg',1,1,'2022/07/16','2022-09-13')

select * from shop_product WHERE name::text like 'çgíÉÉ~ÉãÉN';
