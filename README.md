# MongoDBTwitter

## Installation
In order for you to use this program/files you need to clone this project

## Requirements
  - Terminal
  - Java
  - Maven
  - Docker

## Setup docker and Database

0. If you already have done this for your own project, you can simply start the docker container and skip to the Usage guide

1. `$ docker run --rm -v $(pwd)/data:/data/db --publish=27017:27017 --name dbms -d mongo`

2. `docker exec -it 88385afa bash`

3. `apt-get update`

4. `apt-get install wget`

5. `apt-get install unzip`

6. `wget http://cs.stanford.edu/people/alecmgo/trainingandtestdata.zip`

7. `unzip trainingandtestdata.zip`

8. `sed -i '1s;^;polarity,id,date,query,user,text\n;' training.1600000.processed.noemoticon.csv`

9. `mongoimport --drop --db social_net --collection tweets --type csv --headerline --file training.1600000.processed.noemoticon.csv`


## Usage
1. Open a Terminal navigate to the folder where you can put the files.

2. Run `mvn install` this will install the dependencies and compile the classes

3. Commandlist
    * `getTotalUsers`
    * `getTop10Mentioners`
    * `getTop5Mentioned`
    * `getTop10MostActive`
    * `getTop5Happy`
    * `getTop5Grumpy`

 4. `mvn exec:java -Dexec.args="$command"` to run the different commands you simply need to pick a command from the      Commandlist and replace `$command`
 
 #Side notes / learning
 
 Personally i think Java has been a rather bad choice for this because making it run from the terminal is rather annoying when you have to work with maven. So for the reviewer i'm sorry for the hassle. 
