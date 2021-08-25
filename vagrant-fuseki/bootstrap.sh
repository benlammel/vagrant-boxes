#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt update
apt upgrade -y
sudo apt-get -y install openjdk-17-jdk

#apt-get -y install ntp openjdk-11-jdk

#sudo -s
#wget https://downloads.apache.org/jena/binaries/apache-jena-fuseki-4.1.0.tar.gz -O /opt/apache-fuseki.tar.gz
#tar -xvzf /opt/apache-fuseki.tar.gz -C /opt/
#mv /opt/apache-jena-fuseki* /opt/fuseki
#mkdir /opt/fuseki/run/
#sudo cp /vagrant/config/shiro.ini /opt/fuseki/run/shiro.ini
#sudo sh /opt/fuseki/fuseki-server