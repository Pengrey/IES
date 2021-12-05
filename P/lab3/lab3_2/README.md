Run mySQL db inside a docker
```bash
docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7
``` 

Post new employee
```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{"name":"John", "role":"human", "email_address":"human@earth.com"}' \
    http://localhost:8080/employees
```

Get employees
```bash
 curl -X GET http://localhost:8080/employees 
```

Update employee
```bash
curl -X PUT -H "Content-Type: application/json" \
    -d '{"name":"John Hammond", "role":"human", "email_address":"human@earth.com"}' \
    http://localhost:8080/employees/1
```

Delete employee
```bash
curl -X DELETE http://localhost:8080/employees/1
```

Get employees by email
```bash
curl -X GET http://localhost:8080/employees?email_address=human@earth.com 
```
