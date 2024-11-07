import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080', // Replace with your Spring Boot base URL
  headers: {
    'Content-Type': 'application/json',
  },
});

export default {
  getCsvData(filePath) {
    return apiClient.get(`/csv-data`, {
      params: { filePath },
    });
  },
};