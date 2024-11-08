<template>
  <div>
    <h1>Weight: {{ currentWeight }}</h1>
    <WeightChart />
  </div>
</template>

<script>
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';

export default {
  components: { WeightChart },
  data () {
    currentWeight: null
  },
  async mounted() {
    this.currentWeight = apiService.getCurrentWeight();
  }
};
</script>
