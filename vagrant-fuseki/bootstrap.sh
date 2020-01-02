#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt update
apt upgrade -y

apt-get -y install software-properties-common gnupg

wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | sudo apt-key add -
add-apt-repository --yes https://adoptopenjdk.jfrog.io/adoptopenjdk/deb/
apt update
apt install -y adoptopenjdk-11-hotspot



wget https://www-eu.apache.org/dist/jena/binaries/apache-jena-fuseki-3.13.1.tar.gz -O /opt/apache-fuseki.tar.gz
tar -xvzf /opt/apache-fuseki.tar.gz -C /opt/
mv /opt/apache-jena-fuseki* /opt/fuseki
mkdir /opt/fuseki/run
cp /vagrant/config/shiro.ini /opt/fuseki/run/shiro.ini