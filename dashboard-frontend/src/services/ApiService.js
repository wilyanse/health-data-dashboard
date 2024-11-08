import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api', // Base URL for Spring Boot API
  headers: {
    'Content-Type': 'application/json',
  },
});

export default {
  getWeightData() {
    return apiClient.get('/biometrics?metric=Weight'); // replace with your actual endpoint
  },
  // Add more functions as needed for other endpoints
};