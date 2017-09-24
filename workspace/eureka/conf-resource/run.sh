#!/bin/bash
export JAVA_HOME=${java.home}
export TOMCAT_HOME=${tomcat.home}
export WEB_APP_HOME=${app.home}
export CATALINA_BASE=$WEB_APP_HOME
export APP_DEPLOY_HOME=$WEB_APP_HOME/deploy
export APP_PORT=${app.port}
export APP_DEBUG_PORT=${app.debug.port}
export APP_OUTPUT=$WEB_APP_HOME/

export CHECK_STARTUP_URL="http://localhost:$APP_PORT/ok.htm"
export STARTUP_SUCCESS_MSG="OK"
export TOMCAT_LOG=$APP_OUTPUT/logs/tomcat.log
#export CATALINA_OUT=$APP_OUTPUT/logs/catalina.log
export CATALINA_OUT=/dev/null

export JAVA_OPTS_EXT=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true  -Dfile.encoding=UTF-8 -DdisableIntlRMIStatTask=true"
export JAVA_DEBUG_OPT=" -server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=$APP_DEBUG_PORT,server=y,suspend=n "
export JAVA_MONITOR_OPTS=" -Dtrace.flag=true -Dtrace.output.dir=$APP_DEPLOY_HOME/trace/ "
export JAVA_MEM_OPTS=" -Xms64m -Xmx128m -XX:MaxPermSize=128m "
export JAVA_OPTS=" $JAVA_MEM_OPTS $JAVA_DEBUG_OPT $JAVA_MONITOR_OPTS "
export JAVA_OPTS=" $JAVA_OPTS $JAVA_OPTS_EXT"

sh $TOMCAT_HOME/bin/startup.sh

