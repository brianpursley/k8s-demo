#!/bin/bash

docker run --name postgres -e POSTGRES_USER=demouser -e POSTGRES_PASSWORD=demo1234 -e POSTGRES_DB=k8sdemo -p 5432:5432 -d postgres

