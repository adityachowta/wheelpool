# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ride (
  id                        bigint auto_increment not null,
  constraint pk_ride primary key (id))
;

create table o_user (
  id                        bigint auto_increment not null,
  full_name                 varchar(255),
  status                    integer,
  email                     varchar(255),
  password                  varchar(255),
  phone                     varchar(255),
  created                   datetime,
  constraint ck_o_user_status check (status in (0,1,2,3,4,5)),
  constraint pk_o_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ride;

drop table o_user;

SET FOREIGN_KEY_CHECKS=1;

