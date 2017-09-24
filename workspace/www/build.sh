#!/bin/bash
mvn clean package -Dmaven.test.skip=true -f pom.xml -U && rm -rf stop.sh && rm -rf run.sh && rm -rf conf/* && cp -R target/classes/* conf/ && cp conf/run.sh run.sh && cp conf/stop.sh stop.sh

