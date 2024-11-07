<template>
  <div>
    <h1>Data from API</h1>
    <div v-if="data">
      <pre>{{ data }}</pre>
    </div>
  </div>
</template>

<script>
import apiService from '../services/ApiService.js';

export default {
  data() {
    return {
      data: null,
    };
  },
  async mounted() {
    try {
      const response = await apiService.getData();
      this.data = response.data;
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  },
};
</script>
