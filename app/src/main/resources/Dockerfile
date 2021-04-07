FROM postgres
ENV POSTGRES_USER matrixUser
ENV POSTGRES_PASSSWORD password
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432