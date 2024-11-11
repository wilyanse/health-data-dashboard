<template>
  <div>
    <h1 v-if="currentWeight !== null">Current Weight: {{ currentWeight }} kg</h1>
    <h1 v-else>Loading weight data...</h1>
    
    <WeightChart />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';

// Declare reactive state variable
const currentWeight = ref(null);

// Define async function to load current weight
async function loadCurrentWeight() {
  currentWeight.value = await apiService.getCurrentWeight();
}

// Call loadCurrentWeight when the component is mounted
onMounted(() => {
  loadCurrentWeight();
});
</script>