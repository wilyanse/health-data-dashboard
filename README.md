# Health Data Dashboard
## Running the Project
1. Clone the repository and set the directory to the repository.
2. Run `docker compose up`.
    - If MySQL initialization scripts aren't being run, use `docker compose down -v` followed by `docker compose up`
3. Access the Springboot API endpoints at `localhost:8080`
    - Endpoints:
        - `localhost:8080/biometrics` : Cronometer biometrics data
        - `localhost:8080/dailysummary`: Cronometer dailysummary data
        - `localhost:8080/exercises`: Cronometer exercises data
        - `localhost:8080/servings`: Cronometer servings data
4. Access the Quasar App at `localhost:9000`


Goal:
- [ ] Display data from Cronometer + Hevy into an interactive dashboard
- [ ] Cronometer data is stored in separate CSV files
- [ ] Hevy data can be obtained from API
- [ ] Frontend obtains data from backend API and displays them in graphs
- [ ] Backend provides API return from database
- [ ] Backend is also in charge of downloading the CSV files and updating the database as needed

Steps:
[ ] Create dashboard frontend using CSV files
    - very hard to import CSV files into Vue/Quasar, will focus on Springboot for now
[X] Migrate from CSV files as frontend source to Springboot backend
[ ] Migrate from CSV files to MySQL database
[ ] Dockerize all the services
[ ] Add filters on the graphs to limit data to be seen
[ ] Find out how to query the data obtained from the CSV file with Springboot
[ ] Move data parsing to Springboot
[ ] As new daily data is added, compare data to previous data points

Stack:
- Frontend: [Vue](https://vuejs.org/guide/introduction.html) + [Quasar](https://quasar.dev/components) + [ApexChart](https://apexcharts.com/docs/vue-charts/)
- Backend: [Springboot](https://spring.io/projects/spring-boot)
    - Add CORS to allow reading API endpoint
- Database: [MySQL](https://dev.mysql.com/doc/) + CSV files + API Key
    - If an init file returns an error, the other lines will not be executed.
        - Best practice is to compartmentalize each initialization into separate files
            - NOTE THAT THE REMAINING INIT SCRIPTS IN THE PIPELINE WILL NOT RUN
    - DECIMAL values cannot be NULL in MySQL
    - Running it individually can be done by running `docker exec -it health-data-dashboard-mysql-db-1 mysql -u root -p` and entering the password
    - Convention used in the Dockerfiles are 'XYZ' where X, Y, and Z are integers set to accommodate for init scripts to be added in between. Currently, X = 1 is for manipulating databases, X = 2 is for manipulating tables, and X = 3 is for manipulating records.
- Dockerfile: Frontend + Backend + Database

Documentation:
- Add documentation website for modifying files as needed

Removed CSVReader from docker compose for now:

  csvreader-app:
    build:
      context: ./csvreader   # Path to your Spring Boot project
      dockerfile: Dockerfile
    depends_on:
      mysql-db:
        condition: service_healthy
        restart: true
    ports:
      - "8080:8080"           # Expose Spring Boot API on port 8080
    volumes:
      - ./csvreader:/app     # Mount local Spring Boot code (optional, for live development)
    environment:
      - SPRING_PROFILES_ACTIVE=dev  # Optionally set Spring profiles for dev environment