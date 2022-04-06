#!/bin/bash

API_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -f ../api/pom.xml -Dexpression=project.version -q -DforceStdout 2> /dev/null)
POSTGRES_USER=demouser
POSTGRES_PASSWORD=demo1234

kubectl create ns k8s-demo 2> /dev/null
kubectl create secret docker-registry ghcr-registry --namespace=k8s-demo --docker-server=ghcr.io --docker-username="$GITHUB_USER" --docker-password="$GITHUB_TOKEN" 2> /dev/null

BASE64_POSTGRES_USER=$(echo -n $POSTGRES_USER | base64) \
BASE64_POSTGRES_PASSWORD=$(echo -n $POSTGRES_PASSWORD | base64) \
API_VERSION=$API_VERSION \
envsubst < k8s-demo.yaml | kubectl apply -f -
