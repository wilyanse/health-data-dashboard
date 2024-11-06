<template>
  <div class="chart-container">
    <apexchart type="line" :options="chartOptions" :series="series"></apexchart>
  </div>
</template>

<script>
import VueApexCharts from 'vue3-apexcharts';

export default {
  components: {
    apexchart: VueApexCharts,
  },
  data() {
    return {
      chartOptions: {
        chart: {
          id: 'basic-line',
          toolbar: {
            show: false
          }
        },
        xaxis: {
          categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        },
      },
      series: [{
        name: 'Sales',
        data: [30, 40, 35, 50, 49, 60, 70, 91, 125, 110, 100, 90],
      }],
    };
  },
};
</script>

<style scoped>
.chart-container {
    width: 50vw;
    height: 40vw;
    margin: 0 auto;
    aspect-ratio: 16 / 9;
}
</style>