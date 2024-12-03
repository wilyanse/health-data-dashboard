<template>
  <div class="dashboard">
    <div class="stats">
      <StatCard :mainStat="weightMain" :subStats="weightSub" class="stat-card"/>
      <StatCard :mainStat="caloriesMain" :subStats="caloriesSub" class="stat-card" />
      <StatCard :mainStat="proteinMain" :subStats="proteinSub" class="stat-card" />
    </div>
    <div class="charts">
      <WeightChart class="weight-chart chart"/>
      <CalorieChart :data="nutritionData" class="chart"/>
      <ServingsTable :data="servingsData" class="table"/>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import WeightChart from '../components/WeightChart.vue';
import apiService from '../services/ApiService.js';
import StatCard from '../components/StatCard.vue';
import CalorieChart from '../components/CalorieChart.vue';
import ServingsTable from '../components/ServingsTable.vue';

const weightMain = ref({
  value: 75,
  label: "Weight (kg)"
});
const weightSub = ref([
  {
    value: 65,
    label: "Goal",
    comp: true
  }
]);

async function loadWeightdata() {
  const apiData = await apiService.getWeightDataSorted("date", "desc");
  weightMain.value = {
    value: apiData[0].y,
    label: "Weight (kg)",
    unit: "kg",
  };

  weightSub.value = [
    {
      value: apiData[1].y,
      label: "Previous",
      comp: false
    },
    {
      value: 65,
      label: "Goal",
      comp: false
    },
    {
      value: apiData[apiData.length - 1].y,
      label: "Starting",
      comp: false
    },
  ];
};

const caloriesMain = ref({
  value: 2000,
  label: "Calories (kcal)"
});

const caloriesSub = ref([
  {
    value: 2000,
    label: "Goal",
    comp: true
  }
]);

async function loadCalorieData() {
  const apiData = await apiService.getDailySummaryData();
  const caloriesData = removeColumns(apiData, ['protein']);
  caloriesMain.value = {
    value: caloriesData[caloriesData.length - 1].calories,
    label: "Calories (kcal)"
  };

  caloriesSub.value = [
    {
      value: 2000,
      label: "Goal",
      comp: false
    },
    {
      value: caloriesData[caloriesData.length - 2].calories,
      label: "Previous",
      comp: false
    }
  ]
};

const proteinMain = ref({
  value: 120,
  label: "Protein (g)"
});

const proteinSub = ref([
  {
    value: 120,
    label: "Goal",
    comp: true
  }
]);

async function loadProteinData() {
  const apiData = await apiService.getDailySummaryData();
  const proteinData = removeColumns(apiData, ['calories']);
  proteinMain.value = {
    value: proteinData[proteinData.length - 1].protein,
    label: "Protein (g)"
  };

  proteinSub.value = [
    {
      value: 120,
      label: "Goal",
      comp: true
    },
    {
      value: proteinData[proteinData.length - 2].protein,
      label: "Previous",
      comp: true
    }
  ]
};

const nutritionData = ref([
  { date: "2024-03-21", calories: 998.43, protein: 47.9 },
]);

async function loadNutritionData(){
  nutritionData.value = await apiService.getDailySummaryData();
};

const servingsData = ref([
  {
    date: "2024-03-21",
    group_name: 'Uncategorized',
    food_name: 'Eggs, Cooked',
    amount: '3.00 large',
    calories: 232.50,
    protein: 14.9
  },
]);

async function loadServingsData(){
  servingsData.value = await apiService.getServingsData();
  console.log(servingsData.value);
};


function removeColumns(array, columnsToRemove) {
  return array.map(item => {
    let newItem = { ...item };
    columnsToRemove.forEach(column => delete newItem[column]);
    return newItem;
  });
};

onMounted(() => {
  loadWeightdata();
  loadCalorieData();
  loadProteinData();
  loadNutritionData();
  loadServingsData();
});
</script>


<style scoped>
  .stat-card {
    width: 30%;
    margin: 10px;
    min-width: 350px;
  }

  .dashboard {
    display: flex;
    flex-direction: column;
  }

  .stats {
    display: flex;
    padding: 10px;
    flex-wrap: wrap;
    justify-content: center;
  }

  .charts {
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    justify-content: center;
  }

  .chart {
    width: 45%;
    min-width: 500px;
    margin: auto;
  }

  .table {
    width: 100%;
    margin: auto;
  }
</style>