# Sem

## Prerequisites

- JDK 11 or later
- Gradle
- A web browser to access the H2 console

## Setup Instructions

1. **Clone the repository:**
   git clone https://github.com/your-username/my-spring-boot-app.git
   cd my-spring-boot-app

./gradlew clean build

./gradlew bootRun


#Databse Console

You can access the H2 database console at `http://localhost:8080/h2-console`.

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** (leave this blank)
