# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table o_user (
  id                        bigint not null,
  full_name                 varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  phone                     varchar(255),
  created_by_id             bigint,
  modified_by_id            bigint,
  created                   timestamp,
  constraint pk_o_user primary key (id))
;

create sequence o_user_seq;

alter table o_user add constraint fk_o_user_createdBy_1 foreign key (created_by_id) references o_user (id);
create index ix_o_user_createdBy_1 on o_user (created_by_id);
alter table o_user add constraint fk_o_user_modifiedBy_2 foreign key (modified_by_id) references o_user (id);
create index ix_o_user_modifiedBy_2 on o_user (modified_by_id);



# --- !Downs

drop table if exists o_user cascade;

drop sequence if exists o_user_seq;

