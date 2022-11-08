## About
This project is a simple illustration of rest functionalities plus some pagination.
No extra DB necessary - uses H2 In-Memory DB.

## How to:

### Curl Command for Employee creation:

curl --location --request POST 'http://localhost:8080/employees' --header 'Content-Type: application/json' --data-raw '{
"userName":"john.doe",
"firstName":"John",
"lastName":"Doe",
"emailId":"john.doe@gmail.com",
"dayOfBirth":"1997-12-03"
}'

### Curl Command for getting pageable employees
curl --location --request GET 'http://localhost:8080/employees?page=1&size3' --header 'Content-Type: application/json' --data-raw 
or
curl 'http://localhost:8080/employees?page=1&size3'