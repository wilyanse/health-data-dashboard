<template>
  <div>
    <h1 v-if="currentWeight !== null">Current Weight: {{ this.currentWeight }} kg</h1>
    <h1 v-else>Loading weight data...</h1>
    
    <WeightChart />
  </div>
</template>

<script>
import { ref } from 'vue';
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';

export default {
  components: { WeightChart },
  data () {
    return {
      currentWeight: ref(null),
    }
  },
  mounted () {
    this.loadCurrentWeight();
    console.log('this ', this.currentWeight);
  },
  methods: {
    async loadCurrentWeight() {
      this.currentWeight = await apiService.getCurrentWeight();
    }
  },
};
</script>
