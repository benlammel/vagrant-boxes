#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt-get update
apt install openjdk-8-jdk-headless -y

wget https://www-eu.apache.org/dist/jena/binaries/apache-jena-fuseki-3.9.0.tar.gz -O /opt/apache-fuseki.tar.gz
tar -xvzf /opt/apache-fuseki.tar.gz -C /opt/
mv /opt/apache-jena-fuseki* /opt/fuseki

mkdir /opt/fuseki/run
cp /vagrant/config/shiro.ini /opt/fuseki/run/shiro.ini