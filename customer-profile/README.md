### Sample REST APIs :

* [Sample 1 - Get all customer]
`GET /v1/customerprofile HTTP/1.1
Host: localhost:8080`

* [Sample 3 - Create a customer]
`POST /v1/customerprofile HTTP/1.1
Host: localhost:8080

{
	"name" : "Test",
	"age" : "12"
}`


GET /v1/customerprofile/1/account HTTP/1.1
Host: localhost:8080

GET /v1/accountdetails/search?type=current HTTP/1.1
Host: localhost:8080

GET /v1/accountdetails/search?name=Name-2&type=current HTTP/1.1
Host: localhost:8080




