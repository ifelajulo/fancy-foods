#!/bin/bash
# felix.sh
PAX_CONSTRUCT_VERSION=1.5
PAX_PLUGIN=org.ops4j:maven-pax-plugin:$PAX_CONSTRUCT_VERSION
FRAMEWORK=felix

mvn $PAX_PLUGIN:provision -Dframework=$FRAMEWORK