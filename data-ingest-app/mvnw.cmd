@echo off
setlocal

rem Maven Wrapper for Windows

set MAVEN_HOME=%~dp0.mvn\wrapper
set MAVEN_OPTS=-Xmx512m

if not exist "%MAVEN_HOME%\maven-wrapper.jar" (
    echo Maven wrapper jar not found. Please run mvnw to download it.
    exit /b 1
)

java -cp "%MAVEN_HOME%\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain %*

endlocal