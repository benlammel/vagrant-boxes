#!/usr/bin/env bash

sudo apt-get update
sudo apt upgrade -y
sudo apt-get -y install gnupg

sudo wget -qO - https://www.mongodb.org/static/pgp/server-5.0.asc | sudo apt-key add -

echo "deb http://repo.mongodb.org/apt/debian buster/mongodb-org/5.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-5.0.list
sudo apt-get update
sudo apt-get install -y mongodb-org





#sudo timedatectl set-timezone Europe/Berlin

#./mvnw compile quarkus:dev


######
#sudo apt-get install software-properties-common -y
#sudo add-apt-repository ppa:openjdk-r/ppa -y
