### Exercise Descriptions

Make sure you have below containers running:
1. createbuckets(Will be exited once the buckets are created)
2. [minio](https://hub.docker.com/r/minio/minio) Which serves as a S3 layer for spark streaming
3. spark-master
4. spark-worker-1
5. spark-worker-2

Run the Kstream example "basic" from home folder. This will load the data into the given topic.
```shell
./gradlew runStreams -Pargs=basic
```

Submit the command from current folder:
```shell
sh submit_to_container.sh
```

You can use below command to get into the spark container
```shell
docker-compose exec spark-master bash
```