docker exec -it docker_cassandra-cluster-seed-node_1 bash -c "cqlsh -e \"CREATE KEYSPACE kickstarter_db WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};\""
