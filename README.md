Health Data Dashboard

Goal:
- [ ] Display data from Cronometer + Hevy into an interactive dashboard
- [ ] Cronometer data is stored in separate CSV files
- [ ] Hevy data can be obtained from API
- [ ] Frontend obtains data from backend API and displays them in graphs
- [ ] Backend provides API return from database
- [ ] Backend is also in charge of downloading the CSV files and updating the database as needed

Steps:
1. [ ] Create dashboard frontend using CSV files
    - very hard to import CSV files into Vue/Quasar, will focus on Springboot for now
2. [X] Migrate from CSV files as frontend source to Springboot backend
3. [ ] Migrate from CSV files to MySQL database
4. [ ] Dockerize all the services
5. [ ] Add filters on the graphs to limit data to be seen
6. [ ] Find out how to query the data obtained from the CSV file with Springboot
7. [ ] Move data parsing to Springboot
8. [ ] As new daily data is added, compare data to previous data points

Stack:
- Frontend: [Vue](https://vuejs.org/guide/introduction.html) + [Quasar](https://quasar.dev/components) + [ApexChart](https://apexcharts.com/docs/vue-charts/)
- Backend: [Springboot](https://spring.io/projects/spring-boot)
- Database: [MySQL](https://dev.mysql.com/doc/) + CSV files + API Key
- Dockerfile: Frontend + Backend + Database

Documentation:
- Add documentation website for modifying files as needed