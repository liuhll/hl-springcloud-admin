# 基于SpringCloud实现的管理系统

[![Build Status](https://api.travis-ci.com/liuhll/hl-springcloud-admin.svg?branch=master)](https://travis-ci.com/liuhll/hl-springcloud-admin) 
[![LICENSE](https://img.shields.io/github/license/liuhll/hl-springcloud-admin.svg?style=flat-square)](https://raw.githubusercontent.com/liuhll/hl-springcloud-admin/master/LICENSE)

## 项目简介
基于springcloud框架实现的系统管理,可以作为管理系统的基础框架。

## IDE
推荐使用IDEA,需要安装Lombok插件,否则无法编译通过。

## 运行项目
### 1. 启动mysql服务
```shell
docker-compose -f ./docker-compose/mysql/docker-compose.yml up -d
```

### 2. 执行数据库脚本
使用mysql数据库管理工具nacicat(或是其他数据链接工具),链接到数据库服务，并执行`docs/sql`目录下的数据库脚本,数据库链接的配置如下:
```shell
hostname: 127.0.0.1
port： 13306
username: root
password: qwe!P4ss
```

### 3.打包jar包
```shell
mvn clean package "-Dmaven.test.skip=true"
```

### 4. 打包docker镜像
```shell
docker-compose -f ./docker-compose/hl-admin/docker-compose.yml build
```

### 5. 运行服务
```shell
docker-compose -f ./docker-compose/hl-admin/docker-compose.yml up -d
```

## 微服务组件

| 微服务名称 | 说明 |  端口号 | 维护人  | 新增日期 | 备注  |
|:---------|:------|:-------|:------|:-------|:---------|
| hl-basicdata-server | 基础数据服务组件 | 8002 | * | * | * |
| hl-auth-server | 身份认证与授权服务组件 | 8003 | * | * | * |
| hl-organization-server | 组织机构服务组件 | 8004 | * | * | * |
| hl-product-server | 产品服务组件 | 8005 | * | * | * |
| hl-eureka | 服务注册中心组件 | 8000 | * | * | * |
| hl-gateway | 网关服务组件 | 8001 | * | * | * |