FROM openjdk:8-jdk-alpine
MAINTAINER liuhongliang89@foxmail.com

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ARG JAR_FILE
ARG APP_NAME
ARG PORT
ENV APP_NAME=${APP_NAME}
ENV PORT=${PORT}
WORKDIR /app
EXPOSE ${PORT}

ADD ${JAR_FILE} ./
CMD java -jar ${APP_NAME} --server.port=${PORT}
