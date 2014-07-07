# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table o_user (
  id                        bigint not null,
  full_name                 varchar(255),
  status                    integer,
  email                     varchar(255),
  password                  varchar(255),
  phone                     varchar(255),
  created                   timestamp,
  constraint ck_o_user_status check (status in (0,1,2,3,4,5)),
  constraint pk_o_user primary key (id))
;

create sequence o_user_seq;




# --- !Downs

drop table if exists o_user cascade;

drop sequence if exists o_user_seq;

