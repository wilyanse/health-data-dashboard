<template>
  <div>
    <StatCard :mainStat="mainStat" :subStats="subStats"/>
    <WeightChart />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';
import StatCard from '../components/StatCard.vue';

const mainStat = ref({
  value: 75,
  label: "Current Weight"
});
const subStats = ref([
  {
    value: 65,
    label: "Goal Weight",
    comp: true
  },
  {
    value: 95,
    label: "Starting Weight",
    comp: true
  }
]);

async function loadCurrentWeight() {
  const apiData = await apiService.getWeightDataSorted("date", "desc");
  console.log(apiData)
  mainStat.value = {
    value: apiData[0].y,
    label: "Current Weight",
    unit: "kg",
  };

  subStats.value = [
    {
      value: 65,
      label: "Goal Weight",
      comp: false
    },
    {
      value: apiData[apiData.length - 1].y,
      label: "Starting Weight",
      comp: false
    }
  ];
}

onMounted(() => {
  loadCurrentWeight();
});
</script>