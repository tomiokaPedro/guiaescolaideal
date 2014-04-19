#!/bin/sh

git pull origin pre-master

mkdir src/main/webapp/css
mkdir src/main/webapp/img
mkdir src/main/webapp/js

mkdir src/test
mkdir src/test/java

HOME_PACK = src/main/java/br/com/mdsgpp/guiaescolaideal/

cd $HOME_PACK
ls -al

echo "criando as pastas!"

mkdir dao
mkdir control
mkdir exception
mkdir model
mkdir uitl
