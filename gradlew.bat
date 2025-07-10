@echo off
set DIR=%~dp0
java %JAVA_OPTS% -jar "%DIR%gradle/wrapper/gradle-wrapper.jar" %*
