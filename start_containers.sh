docker-compose up --build -d --remove-orphans

# curl -X GET http://localhost:8081/schemas
# curl -X DELETE http://localhost:8081/subjects/ratings-value



# docker-compose exec ksqldb-cli ksql http://ksqldb-server:8088
# docker-compose exec spark-master bash