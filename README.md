# Rest Application deployed in kubernetes
### Overview
Demonstrates a kubernetes application deployment that uses a postgres database.

The application is a spring boot rest service that makes a Rest call to an external endpoint and merges the endpoint
result with the posted Json, "employee".
The result is written to a Postgres database via a postgres stateful pod

#### Rest Application 
>Endpoint
```json
http://localhost:9090/employee - POST
```
>Application sample message 
```json5
{
	"email" : "simon@gmail.com",
	"fullName" : "Simon Harry",
	"managerEmail" : "fredg@gmail.com",
	"department" : "Maths"
}
```

### Kubernetes Deployment
#### Employee Rest Application Pod
```shell script
docker build -t employees:latest   // builds docker image of spring boot application
kubectl create -f employees-deployment.yaml // creates deployment pod of application 
kubectl create -f employees-service.yaml // creates how the pod is exposed as a service
```
#### Postgress Stateful Pod
```shell script
kubectl create -f postgres-storage.yaml  // defines the database storage on k8 volumes
kubectl create -f postgres-configmap.yaml  // defines possible configurations of postgres, in this case credentials
kubectl create -f postgres-service.yaml  // creates how the postgres database is exposed as a service
kubectl create -f postgres-deployment.yaml  // creates pod for postgres
````
