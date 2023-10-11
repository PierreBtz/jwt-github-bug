# Jwt Github Bug

This repository demonstrates an issue using JWT with the github api project running with the latest jjwt version (0.
12.x).

## How to reproduce

1. You'll need to create and install an application on github, then you'll need:
* the application installation id
* the application id
* the application private key as a PKCS#8 formatted string (you can convert it from PKCS#1 by running 
`openssl pkcs8 -topk8 -inform PEM -outform PEM -in current-key.pem -out new-key.pem -nocrypt).

2. Copy `.env.sample` into an `.env` file and set the 3 values you gathered earlier.

Once done, run `mvn test` and observe the failure.

Compare with what you get by running an older version of `jjwt`: ` mvn test -Djjwt.version=0.11.5`.