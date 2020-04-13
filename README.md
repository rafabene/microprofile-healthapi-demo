# Helidon Quickstart MP Example

This example implements a simple Hello World REST service using MicroProfile.

Demo of this application <https://youtu.be/gS4ZAPt2eIs>

## Build and run

With JDK8+
```bash
mvn package
java -jar target/microprofile-health.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/
```

## Try health

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...
. . .

```

## Build the Docker Image

```
docker build -t microprofile-health .
```

## Start the application with Docker

```
docker run --rm -p 8080:8080 microprofile-health:latest
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                         # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f app.yaml               # Deploy application
kubectl get service microprofile-health  # Verify deployed service
```
