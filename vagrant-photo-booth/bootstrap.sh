#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt-get update
apt-get upgrade -y
apt install gphoto2 openjdk-8-jdk-headless maven -y
#wget https://raw.githubusercontent.com/gonzalo/gphoto2-updater/master/gphoto2-updater.sh && sudo bash gphoto2-updater.sh



#mvn -Dspring-boot.run.jvmArguments="-Dspring.config.location=/vagrant/photo-booth/web-service.yml" spring-boot:run
#gphoto2
#lsusb
#sudo chmod o+w /dev/bus/usb/002/006
#gphoto2 --auto-detect
#gphoto2 --capture-image
#gphoto2 --capture-image-and-download


#apt-get install python3 python3-pip -y
#apt install openjdk-8-jdk-headless maven -y

#git clone https://github.com/jsimone/webapp-runner.git /vagrant/webapp-runner

#mvn package
