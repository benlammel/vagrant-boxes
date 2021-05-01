#!/usr/bin/env bash

export LANGUAGE=en_US.UTF-8; export LANG=en_US.UTF-8; export LC_ALL=en_US.UTF-8; locale-gen en_US.UTF-8

apt update
apt upgrade -y


#sudo apt install mariadb-server net-tools -y

#https://www.digitalocean.com/community/tutorials/how-to-install-mariadb-on-debian-10
#sudo mysql_secure_installation

#mysql -uroot -p
#GRANT ALL ON *.* TO 'root'@'%' IDENTIFIED BY 'myrootpassword' WITH GRANT OPTION;

#sudo nano /etc/mysql/mariadb.conf.d/50-server.cnf
#bind-address = 0.0.0.0

#sudo systemctl restart mariadb




#sudo apt-get install net-tools

