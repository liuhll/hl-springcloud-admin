docker rm -f $(docker ps -aq)
sleep 2
docker-compose up -d