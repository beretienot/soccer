#!/usr/bin/env sh

# Simplified Gradle wrapper script
DIR="$(cd "$(dirname "$0")" && pwd)"
JAVA_OPTS="${JAVA_OPTS:-}"
exec java $JAVA_OPTS -jar "${DIR}/gradle/wrapper/gradle-wrapper.jar" "$@"
