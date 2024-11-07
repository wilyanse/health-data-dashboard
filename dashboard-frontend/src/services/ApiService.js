import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080/', // Base URL for Spring Boot API
  headers: {
    'Content-Type': 'application/json',
  },
});

export default {
  getData() {
    return apiClient.get('/data'); // replace with your actual endpoint
  },
  // Add more functions as needed for other endpoints
};