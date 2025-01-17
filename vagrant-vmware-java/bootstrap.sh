#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt update
apt update -y

wget https://download.java.net/java/GA/jdk23.0.1/c28985cbf10d4e648e4004050f8781aa/11/GPL/openjdk-23.0.1_linux-aarch64_bin.tar.gz -P /usr/local/
tar xvf /usr/local/openjdk-*.tar.gz -C /usr/local/
mv /usr/local/jdk-* /usr/local/jdk-23

export JAVA_HOME=/usr/local/jdk-23/
export PATH=$PATH:$JAVA_HOME/bin

#apt install  maven -y




#./mvnw compile quarkus:dev

#https://green.cloud/docs/how-to-install-java-jdk-21-or-openjdk-21-on-debian-12/

#apt install software-properties-common python3-launchpadlib -y

