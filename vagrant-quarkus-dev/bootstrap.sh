#!/usr/bin/env bash

sudo apt-get update
sudo apt upgrade -y

apt-get -y install ntp openjdk-11-jdk

#sudo timedatectl set-timezone Europe/Berlin

#./mvnw compile quarkus:dev