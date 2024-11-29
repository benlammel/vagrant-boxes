#!/usr/bin/env bash

sudo apt-get update
sudo apt upgrade -y
sudo apt-get -y install python3 python3-pip



python3 -m pip install depthflow shaderflow broken-source pianola spectronote turbopipe


#anaconda
#sudo apt-get -y install libgl1-mesa-glx libegl1-mesa libxrandr2 libxrandr2 libxss1 libxcursor1 libxcomposite1 libasound2 libxi6 libxtst6
#curl -O https://repo.anaconda.com/archive/Anaconda3-2024.06-1-Linux-aarch64.sh
#bash ./Anaconda3-2024.06-1-Linux-aarch64.sh -b

#source  /home/vagrant/anaconda3/bin/activate
#https://docs.anaconda.com/anaconda/install/linux/



#sudo timedatectl set-timezone Europe/Berlin

#./mvnw compile quarkus:dev


######
#sudo apt-get install software-properties-common -y
#sudo add-apt-repository ppa:openjdk-r/ppa -y


#cd /vagrant/github/emma/webservice/
#./mvnw install
#./mvnw compile quarkus:dev -pl meta-schema
