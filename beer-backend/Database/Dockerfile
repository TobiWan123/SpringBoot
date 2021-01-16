# To run the container:
# docker build -t beer_db .
# docker run --name beer_db_1 -p 3306:3306 beer_db
# Logs:
# docker logs -f beer_db_1

# Stop and remove container:
# docker container stop beer_db_1
# docker container rm beer_db_1

FROM mariadb:10.4.4-bionic

ENV MYSQL_ROOT_PASSWORD beer_db
ENV MYSQL_DATABASE beer_db
ENV MYSQL_USER beer_db
ENV MYSQL_PASSWORD beer_db
EXPOSE 3306

CMD ["mysqld"]
