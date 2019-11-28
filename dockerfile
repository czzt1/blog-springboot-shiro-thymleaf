# This my first nginx Dockerfile
# Version 1.0

# Base images 基础镜像
FROM centos

#MAINTAINER 维护者信息
MAINTAINER czzt1

#ENV 设置环境变量
#ENV PATH /usr/local/nginx/sbin:$PATH

#ADD  文件放在当前目录下，拷过去会自动解压
ADD blog-0.0.1-SNAPSHOT.jar /usr/local/
#ADD epel-release-latest-7.noarch.rpm /usr/local/

#RUN 执行以下命令
#RUN rpm -ivh /usr/local/epel-release-latest-7.noarch.rpm
#RUN yum install -y wget lftp gcc gcc-c++ make openssl-devel pcre-devel pcre && yum clean all
RUM yum install java-1.8.0-openjdk-devel.x86_64
RUN jar -jar blog-0.0.1-SNAPSHOT.jar


#EXPOSE 映射端口
EXPOSE 8080

#CMD 运行以下命令
WORKDIR /usr/local
ENTRYPOINT java -jar blog-0.0.1-SNAPSHOT.jar