<template>
  <div class="dashboard">
    <StatCard :mainStat="weightMain" :subStats="weightSub" class="stat-card"/>
    <StatCard :mainStat="caloriesMain" :subStats="caloriesSub" class="stat-card" />
    <WeightChart class="weight-chart"/>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';
import StatCard from '../components/StatCard.vue';

const weightMain = ref({
  value: 75,
  label: "Current Weight"
});
const weightSub = ref([
  {
    value: 65,
    label: "Goal Weight",
    comp: true
  }
]);

async function loadCurrentWeight() {
  const apiData = await apiService.getWeightDataSorted("date", "desc");
  console.log(apiData)
  weightMain.value = {
    value: apiData[0].y,
    label: "Current Weight",
    unit: "kg",
  };

  weightSub.value = [
    {
      value: apiData[1].y,
      label: "Previous Weight",
      comp: false
    },
    {
      value: 65,
      label: "Goal Weight",
      comp: false
    },
    {
      value: apiData[apiData.length - 1].y,
      label: "Starting Weight",
      comp: false
    },
  ];
};

const caloriesMain = ref({
  value: 2000,
  label: "Calories"
});

const caloriesSub = ref([
  {
    value: 2000,
    label: "Goal Calories",
    comp: true
  }
]);

onMounted(() => {
  loadCurrentWeight();
});
</script>

<style scoped>
  .weight-chart {
    width: 50%;
    margin-top: 30px;
  }

  .stat-card {
    width: 35%;
  }

  .dashboard {
    display: flex;
  }
</style>