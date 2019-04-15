/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     2019/4/15 星期一 21:13:50                       */
/*==============================================================*/

drop database if exists basicdata_db;
drop table if exists bd_dictionary;

/*==============================================================*/
/* create db                                      */
/*==============================================================*/
create database basicdata_db;
use basicdata_db;

/*==============================================================*/
/* Table: bd_dictionary                                         */
/*==============================================================*/
create table bd_dictionary 
(
   Id                   bigint                         not null,
   Code                 varchar(50)                    not null,
   Name                 varchar(50)                    not null,
   ParentId             bigint                         not null,
   Seq                  int                            not null,
   TypeName             varchar(50)                    not null,
   HasChild             int                            not null,
   CreateBy             bigint                         null,
   CreateTime           datetime                       null,
   UpdateBy             bigint                         null,
   UpdateTime           datetime                       null,
   IsDelete             int                            null,
   constraint PK_BD_DICTIONARY primary key (Id),
   constraint AK_KEY_1_BD_DICTI unique clustered (Id)
);

comment on table bd_dictionary is 
'字典表';

comment on column bd_dictionary.Id is 
'主键';

comment on column bd_dictionary.Code is 
'唯一编码';

comment on column bd_dictionary.Name is 
'名称';

comment on column bd_dictionary.ParentId is 
'父级Id';

comment on column bd_dictionary.Seq is 
'序号';

comment on column bd_dictionary.TypeName is 
'分类名称';

comment on column bd_dictionary.HasChild is 
'0.没有 1.有';

comment on column bd_dictionary.CreateBy is 
'创建人';

comment on column bd_dictionary.CreateTime is 
'创建日期';

comment on column bd_dictionary.UpdateBy is 
'修改人';

comment on column bd_dictionary.UpdateTime is 
'修改日期';

comment on column bd_dictionary.IsDelete is 
'软删除标识';

