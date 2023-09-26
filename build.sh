#! /usr/bin/env bash

docker volume create client-api-whitelist

docker build -t client-api-whitelist .
