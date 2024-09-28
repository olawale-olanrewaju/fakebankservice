## A fake bank account service

This service simulates fetching  a list of transactions from a fake bank account.

### Run the service locally as a Docker container
1. Build the Docker image with ``docker build -t fakebankservice:local .``
2. Start the service with ``docker run -d -p 9000:8080 fakebankservice:local``
3. Call ``GET localhost:8080/v1/accounts/11111111/transactions``

### TODO: Start service locally with Batect
1. Run .batect start-service
2. Call ``GET localhost:8080/v1/accounts/11111111/transactions``
 

### TODO: Deploy service to EKS on AWS