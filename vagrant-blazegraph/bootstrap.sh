#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt-get update
apt install openjdk-8-jdk-headless maven -y

mkdir /vagrant/blazegraph
wget -O /vagrant/blazegraph/blazegraph.jar https://netix.dl.sourceforge.net/project/bigdata/bigdata/2.1.4/blazegraph.jar

#java -server -Xmx4g -jar /vagrant/blazegraph/blazegraph.jar

