<template>
  <div>
    <weight-chart></weight-chart>
  </div>
</template>

<script>
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';

export default {
  components: { WeightChart },
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
