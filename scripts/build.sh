#!/bin/bash

# Get version number from pom.xml
VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -f ../api/pom.xml -Dexpression=project.version -q -DforceStdout 2> /dev/null)

IMAGE_NAME=ghcr.io/brianpursley/k8sdemo-api

# Build the container image, tagging it "latest" and also with the specific version number
docker build ../api -t $IMAGE_NAME -t "$IMAGE_NAME:$VERSION"

# Push the image to the container registry
docker push "$IMAGE_NAME:latest"
docker push "$IMAGE_NAME:$VERSION"
