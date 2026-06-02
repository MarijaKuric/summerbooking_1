# SummerBooking

## Opis projekta

SummerBooking je web aplikacija za upravljanje smještajima za ljetovanje. Korisnicima omogućuje pregled, dodavanje, uređivanje i brisanje smještaja kroz jednostavno web sučelje.

Projekt je izrađen korištenjem Spring Boota, MySQL baze podataka i Thymeleaf predložaka.

## Funkcionalnosti

* Pregled svih smještaja
* Dodavanje novog smještaja
* Uređivanje postojećeg smještaja
* Brisanje smještaja
* Prikaz detalja smještaja
* Pretraga smještaja
* Sortiranje po cijeni
* Validacija unosa podataka

## Tehnologije

### Backend

* Java
* Spring Boot
* Spring Data JPA

### Frontend

* Thymeleaf
* HTML
* CSS
* Bootstrap

### Baza podataka

* MySQL

### Razvojno okruženje

* IntelliJ IDEA


## Pokretanje aplikacije

### 1. Kreiranje baze podataka

U MySQL-u kreirati bazu:

```sql
CREATE DATABASE summerbooking;
```

### 2. Konfiguracija baze

U datoteci application.properties postaviti:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/summerbooking
spring.datasource.username=username
spring.datasource.password=lozinka

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Pokretanje projekta

1. Otvoriti projekt u IntelliJ IDEA.
2. Pokrenuti klasu:

```text
SummerBookingApplication
```

3. Otvoriti preglednik i posjetiti:

```text
http://localhost:8080
```

## Autor

Projekt izrađen kao završni projekt iz kolegija Programiranje u Javi.

## Napomena

Projekt koristi stvarnu MySQL bazu podataka te implementira CRUD operacije, validaciju unosa i pretragu podataka kroz web sučelje.
