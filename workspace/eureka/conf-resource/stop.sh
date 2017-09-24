#!/bin/bash
export CATALINA_BASE=${app.home}
export CATALINA_HOME=${tomcat.home}

$CATALINA_HOME/bin/shutdown.sh

