#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt update
apt upgrade -y

apt-get -y install openjdk-11-jdk

#sudo -s
#wget http://mirror.easyname.ch/apache/jena/binaries/apache-jena-fuseki-3.14.0.tar.gz -O /opt/apache-fuseki.tar.gz
#tar -xvzf /opt/apache-fuseki.tar.gz -C /opt/
#mkdir /opt/fuseki/run
#cp /vagrant/config/shiro.ini /opt/fuseki/run/run/shiro.ini
#sudo sh /opt/fuseki/fuseki-server