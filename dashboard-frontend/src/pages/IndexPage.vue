<template>
  <q-page class="flex flex-center">
    <WeightChart />
  </q-page>
</template>

<script setup>
import WeightChart from '../components/WeightChart.vue'
defineOptions({
  name: 'IndexPage',
});
</script>