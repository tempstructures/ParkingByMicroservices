# ParkingByMicroservices

--Services with MongoBD
--2PC (2 phase commit protocol) implementation to maintain data consistency using Apache Kafka for Eventual Consistency
--Event driven architecture in services
--Exactly-once Kafka Dynamic Consumer via Subscribe (One and Only One Message Delivery)




Setup MongoDB Docker Container

	docker run --name=myMongoDB --volume="/Users/<<LocalUSerName>>/Docker/MongoDBMount/configdb:/data/configdb:Z" --	volume="/Users/<<LocalUSerName>>/Docker/MongoDBMount/db:/data/db:Z" --volume="/data/configdb" --volume="/data/db" -p 	     27017:27017/ -p 0.0.0.0:27017:27017 --restart= --detach=true mongo:latest mongod
	
	
Setup Kafka Docker Container

	1. Install Kafka Container

	docker run --name myKafka -it --rm -p 2181:2181 -p 3030:3030 -p 8081:8081 \
	-p 8082:8082 -p 8083:8083 -p 9092:9092 \
	-e ADV_HOST=127.0.0.1 \lensesio/fast-data-dev:latest
	
	This will install kafka container with lensesio ui on top
	For details visit: https://github.com/lensesio/fast-data-dev

	Access lensesio UI on url: http://localhost:3030
	
	2. Start another terminal window and enter into container shell:
	
	docker exec -it myKafka /bin/bash

	3. Create Topics

	kafka-topics --zookeeper 127.0.0.1:2181 --create --topic parking --partitions 3 --replication-factor 1

	kafka-topics --zookeeper 127.0.0.1:2181 --create --topic admin --partitions 3 --replication-factor 1

	4. Start Consumer process in same terminal window:
	/usr/local//kafka-console-consumer --bootstrap-server localhost:9092 --topic parking --from-beginning
	
	5. Repeat Step 2 to have another shell window for producer

	/usr/local/bin/kafka-console-producer --broker-list localhost:9092 --topic parking
	
	6. Type anything in producer window and see the message being received at consumer


Ensure Connectivity between various services:::
1. Write tests to ensure connectivity.
