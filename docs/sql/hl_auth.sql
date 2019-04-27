/*==============================================================*/
/* DB name:      hl_auth                            */
/* Created on:     2019/4/21 星期日 1:15:16                        */
/*==============================================================*/

CREATE DATABASE hl_auth DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE hl_auth;


drop table if exists auth_employee;

drop table if exists auth_file;

drop table if exists auth_function;

drop table if exists auth_menu;

drop table if exists auth_menu_function;

drop table if exists auth_org_role;

drop table if exists auth_permission;

drop table if exists auth_permission_file;

drop table if exists auth_permission_function;

drop table if exists auth_permission_menu;

drop table if exists auth_role;

drop table if exists auth_role_permission;

drop table if exists auth_user;

drop table if exists auth_user_group;

drop table if exists auth_user_role;

drop table if exists auth_user_usergroup;

drop table if exists auth_usergroup_role;

/*==============================================================*/
/* Table: auth_employee                                         */
/*==============================================================*/
create table auth_employee
(
   Id                   bigint not null auto_increment comment '主键',
   UserName             varchar(50) not null comment '用户名',
   ChineseName          varchar(50) not null comment '中文名',
   Email                varchar(50) not null comment '电子邮件',
   Phone                varchar(22) not null comment '联系电话',
   Gender               int comment '性别',
   Birth                date comment '生日',
   NativePlace          varchar(50) comment '籍贯',
   Address              varchar(100) comment '住址',
   Folk                 varchar(50) comment '民族',
   PoliticalStatus      int comment '政治面貌',
   GraduateInstitutions varchar(50) comment '毕业院校',
   Education            varchar(50) comment '学历',
   Major                varchar(50) comment '专业',
   Resume               varchar(500) comment '简历',
   Memo                 varchar(500) comment '备注',
   Status               int comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_employee comment '职员表';

/*==============================================================*/
/* Table: auth_file                                             */
/*==============================================================*/
create table auth_file
(
   Id                   bigint not null auto_increment comment '主键',
   Code                 varchar(50) not null comment '编码',
   Name                 varchar(50) not null comment '名称',
   FIleName             varchar(50) not null,
   FilePath             varchar(100) not null,
   Memo                 varchar(100) comment '备注',
   Status               int not null comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_file comment '文件表';

/*==============================================================*/
/* Table: auth_function                                         */
/*==============================================================*/
create table auth_function
(
   Id                   bigint not null auto_increment comment '主键',
   Code                 varchar(50) not null comment '编码',
   Name                 varchar(50) not null comment '名称',
   WebApi               int not null comment 'webapi',
   Status               int not null comment '状态',
   Method               int comment '请求方法',
   ParentId             bigint not null comment '父Id',
   Memo                 varchar(100) comment '备注',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_function comment '功能操作表';

/*==============================================================*/
/* Table: auth_menu                                             */
/*==============================================================*/
create table auth_menu
(
   Id                   bigint not null auto_increment comment '主键',
   Code                 varchar(50) not null comment '菜单编码',
   Name                 varchar(50) not null comment '菜单名称',
   UrlPath              int not null comment '菜单URL',
   ParentId             bigint not null comment '父Id',
   Level                int not null comment '层级',
   Mold                 int comment '菜单类型',
   Icon                 varchar(100) comment 'icon图标',
   FrontEndComponent    varchar(1) comment '前端组件',
   Sort                 int comment '排序',
   Memo                 varchar(100) comment '备注',
   Status               int not null comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_menu comment '菜单表';

/*==============================================================*/
/* Table: auth_menu_function                                    */
/*==============================================================*/
create table auth_menu_function
(
   Id                   bigint not null auto_increment comment '主键',
   MenuId               bigint not null,
   FunctionId           bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_menu_function comment '菜单功能关系表';

/*==============================================================*/
/* Table: auth_org_role                                         */
/*==============================================================*/
create table auth_org_role
(
   Id                   bigint not null auto_increment comment '主键',
   OrgId                bigint not null,
   RoleId               bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_org_role comment '组织机构角色关系表';

/*==============================================================*/
/* Table: auth_permission                                       */
/*==============================================================*/
create table auth_permission
(
   Id                   bigint not null auto_increment comment '主键',
   Code                 varchar(50) not null comment '权限编码',
   Name                 varchar(50) not null comment '权限名称',
   Mold                 int comment '权限类型 1.菜单  2. 操作 3. 页面元素 4. 文件',
   Memo                 varchar(100) comment '备注',
   Status               int not null comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_permission comment '权限表';

/*==============================================================*/
/* Table: auth_permission_file                                  */
/*==============================================================*/
create table auth_permission_file
(
   Id                   bigint not null auto_increment comment '主键',
   PermissionId         bigint not null,
   FileId               bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_permission_file comment '权限文件关系表';

/*==============================================================*/
/* Table: auth_permission_function                              */
/*==============================================================*/
create table auth_permission_function
(
   Id                   bigint not null auto_increment comment '主键',
   PermissionId         bigint not null,
   FunctionId           bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_permission_function comment '权限菜单关系表';

/*==============================================================*/
/* Table: auth_permission_menu                                  */
/*==============================================================*/
create table auth_permission_menu
(
   Id                   bigint not null auto_increment comment '主键',
   PermissionId         bigint not null,
   MenuId               bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_permission_menu comment '权限菜单关系表';

/*==============================================================*/
/* Table: auth_role                                             */
/*==============================================================*/
create table auth_role
(
   Id                   bigint not null auto_increment comment '主键',
   Code                 varchar(50) not null comment '角色编码',
   Name                 varchar(50) not null comment '角色名称',
   Memo                 varchar(100) comment '备注',
   Status               int not null comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_role comment '角色表';

/*==============================================================*/
/* Table: auth_role_permission                                  */
/*==============================================================*/
create table auth_role_permission
(
   Id                   bigint not null auto_increment comment '主键',
   RoleId               bigint not null,
   PerssionId           char(10) not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_role_permission comment '角色权限表';

/*==============================================================*/
/* Table: auth_user                                             */
/*==============================================================*/
create table auth_user
(
   Id                   bigint not null auto_increment comment '主键',
   EmployeeId           bigint not null comment '员工Id',
   Email                varchar(50) not null comment '电子邮件',
   Phone                varchar(22) not null comment '联系电话',
   UserName             varchar(50) not null comment '用户名',
   Password             varchar(100) not null comment '密码',
   Status               int comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_user comment '用户表';

/*==============================================================*/
/* Table: auth_user_group                                       */
/*==============================================================*/
create table auth_user_group
(
   Id                   bigint not null auto_increment comment '主键',
   ParentId             varchar(22) not null comment '父用户组Id',
   GroupName            varchar(50) not null comment '用户组名称',
   Status               int not null comment '状态',
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   IsDeleted            int comment '软删除标识',
   DeleteBy             bigint comment '删除用户',
   DeleteTime           datetime comment '删除时间',
   primary key (Id)
);

alter table auth_user_group comment '用户组表';

/*==============================================================*/
/* Table: auth_user_role                                        */
/*==============================================================*/
create table auth_user_role
(
   Id                   bigint not null auto_increment comment '主键',
   UserId               bigint not null,
   RoleId               bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_user_role comment '用户角色关系表';

/*==============================================================*/
/* Table: auth_user_usergroup                                   */
/*==============================================================*/
create table auth_user_usergroup
(
   Id                   bigint not null auto_increment comment '主键',
   UserId               bigint not null,
   UserGroupId          bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_user_usergroup comment '用户与用户关系表';

/*==============================================================*/
/* Table: auth_usergroup_role                                   */
/*==============================================================*/
create table auth_usergroup_role
(
   Id                   bigint not null auto_increment comment '主键',
   UserGroupId          bigint not null,
   RoleId               bigint not null,
   CreateBy             bigint comment '创建人',
   CreateTime           datetime comment '创建日期',
   UpdateBy             bigint comment '修改人',
   UpdateTime           datetime comment '修改日期',
   primary key (Id)
);

alter table auth_usergroup_role comment '用户组角色关系表';
