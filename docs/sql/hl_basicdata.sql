/*==============================================================*/
/* DB name:      hl_basicdata                                */
/* Created on:     2019/4/21 星期日 1:15:16                        */
/*==============================================================*/

CREATE DATABASE hl_basicdata DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE hl_basicdata;

drop table if exists bd_dictionary;

/*==============================================================*/
/* Table: bd_dictionary                                         */
/*==============================================================*/
create table bd_dictionary
(
   Id                   bigint not null auto_increment comment '主键',
   Code                 varchar(50) not null comment '唯一编码',
   Name                 varchar(50) not null comment '名称',
   ParentId             bigint not null comment '父级Id',
   Seq                  int not null comment '序号',
   TypeName             varchar(50) not null comment '分类名称',
   HasChild             int not null comment '0.没有 1.有',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table bd_dictionary comment '字典表';

