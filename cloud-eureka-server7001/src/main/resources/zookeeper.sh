#!/bin/bash
#chkconfig:2345 10 90
#description:service zookeeper
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.275.b01-0.el6_10.x86_64
export ZOO_LOG_DIR=/opt/module/zookeeper-3.4.10/logs
ZOOKEEPER_HOME=/opt/module/zookeeper-3.4.10/
case  "$1"   in start)  su  root  ${ZOOKEEPER_HOME}/bin/zkServer.sh  start;; start-foreground)  su  root ${ZOOKEEPER_HOME}/bin/zkServer.sh   start-foreground;; stop)  su  root  ${ZOOKEEPER_HOME}/bin/zkServer.sh  stop;; status)  su root  ${ZOOKEEPER_HOME}/bin/zkServer.sh    status;; restart)  su root   ${ZOOKEEPER_HOME}/bin/zkServer.sh   restart;; upgrade)su root  ${ZOOKEEPER_HOME}/bin/zkServer.sh  upgrade;; print-cmd)su root  ${ZOOKEEPER_HOME}/bin/zkServer.sh  print-cmd;; *)  echo "requirestart|start-foreground|stop|status|restart|print-cmd";;
esac