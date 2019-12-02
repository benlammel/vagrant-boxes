#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt-get update
apt-get upgrade
apt install openjdk-8-jdk-headless  -y

wget -O - https://debian.neo4j.org/neotechnology.gpg.key | sudo apt-key add -
echo 'deb https://debian.neo4j.org/repo stable/' | sudo tee -a /etc/apt/sources.list.d/neo4j.list
sudo apt-get update

apt-get install neo4j=1:3.5.0 -y

sed -i -- 's/#dbms.connectors.default_listen_address/dbms.connectors.default_listen_address/g' /etc/neo4j/neo4j.conf
sed -i -- 's/#dbms.connectors.default_advertised_address=localhost/dbms.connectors.default_advertised_address=0.0.0.0/g' /etc/neo4j/neo4j.conf
sed -i -- 's/#dbms.connector.http.listen_address=:7474/dbms.connector.http.listen_address=:7474/g' /etc/neo4j/neo4j.conf
sed -i -- 's/#dbms.connector.https.listen_address=:7473/dbms.connector.https.listen_address=:7473/g' /etc/neo4j/neo4j.conf

service neo4j restart

