import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api', // Base URL for Spring Boot API
  headers: {
    'Content-Type': 'application/json',
  },
});

export default {
  async getWeightData() {
    const apiResponse = await apiClient.get('/biometrics?metric=Weight');
    const apiData = apiResponse.data;
    const poundsToKg = pounds => parseFloat(pounds * 0.453592).toFixed(2);

    const parsedData = apiData.map(entry => ({
      x: new Date(entry.date).getTime(),
      y: entry.unit === "lbs" ? poundsToKg(entry.amount) : entry.amount
    }))
    .sort((a, b) => a.x - b.x);

    const seriesData = [{
      name: 'Weight (kg)',
      data: parsedData
    }];

    return seriesData;
  },
  async getWeightDataSorted(sortBy = 'date', sortDirection = 'desc') {
    const apiResponse = await apiClient.get(`/biometrics/sorted?sortBy=${sortBy}&sortDirection=${sortDirection}`);
    const apiData = apiResponse.data;

    const poundsToKg = pounds => parseFloat(pounds * 0.453592).toFixed(2);
    const parsedData = apiData.map(entry => ({
      x: new Date(entry[sortBy]).getTime(),
      y: entry.unit === "lbs" ? poundsToKg(entry.amount) : entry.amount
    }))
    .sort((a, b) => 
        sortDirection === 'asc' ? a.x - b.x : b.x - a.x
    );

    return parsedData;
  },
  async getDailySummaryData() {
    const apiResponse = await apiClient.get(`/dailysummaries`);
    const apiData = apiResponse.data;
    return apiData;
  }
};