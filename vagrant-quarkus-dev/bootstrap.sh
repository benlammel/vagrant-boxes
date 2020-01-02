#!/usr/bin/env bash

sudo apt-get update
sudo apt upgrade -y

sudo apt-get -y install software-properties-common maven gnupg

wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | sudo apt-key add -
add-apt-repository --yes https://adoptopenjdk.jfrog.io/adoptopenjdk/deb/
sudo apt update
apt install -y adoptopenjdk-11-hotspot


#apt-get install apt-transport-https ca-certificates curl gnupg2 software-properties-common -y
#curl -fsSL https://download.docker.com/linux/debian/gpg | sudo apt-key add -
#add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"
#apt-get update
#apt-get install docker-ce -y