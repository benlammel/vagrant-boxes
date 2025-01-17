#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt update
apt update -y
sudo apt-get install software-properties-common -y

sudo add-apt-repository ppa:openjdk-r/ppa
apt update -y


#apt install default-jdk -y
#apt install openjdk-17-jdk-headless maven -y
