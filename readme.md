# Các bước làm:

## 1. Khởi tạo Spring Boot Project
### 1.1. Sử dụng các dependencies:
- Spring Web
- Spring Data JPA
- Thymeleaf
- MySQL JDBC Driver
- Spring Boot DevTools (for automatic reload changes)
- Webjar for Bootstrap

### 1.2. Tạo database schema

Cài đặt Mysql và Portainer với Docker trong WSL.

File `docker-compose.yml` như sau:

```yaml
version: '3.7'

services:
  mysql:
    image: mysql:latest
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: abc123-
      MYSQL_DATABASE: usersdb
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

  portainer:
    image: portainer/portainer-ce:latest
    restart: always
    ports:
      - "9000:9000"
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
      - portainer_data:/data

volumes:
  mysql_data:
  portainer_data:


```

### 1.3. Cài đặt config datasource trong application.properties

```bash
spring.application.name=mywebapp
spring.datasource.url=jdbc:mysql://localhost:3306/usersdb
spring.datasource.username=root
spring.datasource.password=abc123-
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
```

## 2. Code Home Page

## 3. Code User Entity Class & UserRepository Interface

### 3.1 UserRepository là interface extend CRUDRepository

## 4. Code UserRepostoryTests (unit test for data access layer)

### 4.1. Test chức năng Create
### 4.2. Test chức năng Read
### 4.3. Test chức năng Update
### 4.4. Test chức năng Delete

## 5. Code Users Listing Page



## 6. Code Add User Function
## 7. Code Update User Function
## 8. Code Delete User Function
