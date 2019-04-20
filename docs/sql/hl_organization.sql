/*==============================================================*/
/* DB name:      hl_organization                                */
/* Created on:     2019/4/21 星期日 1:15:16                        */
/*==============================================================*/

CREATE DATABASE hl_organization DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE hl_organization;

drop table if exists org_corporation;

drop table if exists org_department;

drop table if exists org_dept_position;

drop table if exists org_dept_user;

drop table if exists org_position;

/*==============================================================*/
/* Table: org_corporation                                       */
/*==============================================================*/
create table org_corporation
(
   Id                   bigint not null comment '主键',
   Code                 varchar(50) not null comment '唯一编码',
   Name                 varchar(50) not null comment '公司名称',
   ParentId             bigint comment '母公司Id',
   Type                 int comment '0.集团公司;1.单体公司',
   Mold                 int not null comment '0.母公司;2.子公司3.控股公司',
   Address              varchar(200) not null comment '公司地址',
   Logo                 varchar(50) comment 'logo名称',
   LogoPosition         varchar(50) comment 'logo存放位置',
   CorporateRepresentative varchar(50) comment '法人代表',
   RegisterDate         datetime comment '注册日期',
   OpenDate             datetime comment '开业时间',
   Trade                varchar(50) comment '所属行业',
   Memo                 varchar(500) comment '备注',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDelete             int comment '软删除标识',
   primary key (Id),
   key AK_Key_1 (Id)
);

alter table org_corporation comment '公司信息表';

/*==============================================================*/
/* Table: org_department                                        */
/*==============================================================*/
create table org_department
(
   Id                   bigint not null comment '主键',
   Code                 varchar(50) not null comment '唯一编码',
   Name                 varchar(50) not null comment '部门名称',
   ParentId             bigint not null comment '上级部门Id',
   CorporationId        bigint comment '所属公司',
   Location             varchar(100) comment '部门位置',
   DeptTypeId           bigint comment '部门类型,取自字典表',
   BriefIntro           varchar(100) comment '部门简介',
   Memo                 varchar(500) comment '备注',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDelete             int comment '软删除标识',
   primary key (Id),
   key AK_Key_1 (Id)
);

alter table org_department comment '部门表';

/*==============================================================*/
/* Table: org_dept_position                                     */
/*==============================================================*/
create table org_dept_position
(
   Id                   bigint not null comment '主键',
   DeptId               bigint not null comment '部门Id',
   PositionId           bigint not null comment '职位Id',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id),
   key AK_Key_1 (Id)
);

alter table org_dept_position comment '部门岗位关系表';

/*==============================================================*/
/* Table: org_dept_user                                         */
/*==============================================================*/
create table org_dept_user
(
   Id                   bigint not null comment '主键',
   DeptId               bigint not null comment '部门Id',
   UserId               bigint not null comment '用户Id',
   PositionId           bigint not null comment '职位Id',
   DirectLeaderId       bigint comment '直属领导Id',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id),
   key AK_Key_1 (Id)
);

alter table org_dept_user comment '部门用户关系表';

/*==============================================================*/
/* Table: org_position                                          */
/*==============================================================*/
create table org_position
(
   Id                   bigint not null comment '主键',
   Code                 varchar(50) not null comment '唯一编码',
   ParentId             char(10) comment '上级职位Id',
   Name                 varchar(50) not null comment '职位名称',
   FunctionId           bigint not null comment '职能Id,取自字典表',
   PositionTypeId       bigint not null comment '岗位类型Id,取自字典表',
   BriefIntro           varchar(100) comment '岗位说明',
   Memo                 varchar(500) comment '备注',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDelete             int comment '软删除标识',
   primary key (Id),
   key AK_Key_1 (Id)
);

alter table org_position comment '职位表';

