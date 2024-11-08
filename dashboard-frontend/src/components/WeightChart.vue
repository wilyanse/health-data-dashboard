<template>
  <div class="chart-container" v-if="series != null">
    <apexchart type="line" :options="chartOptions" :series="series"></apexchart>
  </div>
</template>

<script>
import VueApexCharts from 'vue3-apexcharts';
import apiService from '../services/ApiService.js';

export default {
  components: {
    apexchart: VueApexCharts,
  },
  data() {
    return {
      chartOptions: {
        chart: {
          id: 'basic-line',
          zoom: {
                type: 'x',
                enabled: true,
                autoScaleYaxis: true
              },
          toolbar: {
            show: false
          }
        },
        title: {
          text: 'Weight',
          align: 'center'
        },
        xaxis: {
            type: 'datetime',  // treat x-axis as time series
            title: {
            text: 'Date',
            },
        },
        yaxis: {
            title: {
            text: 'Weight (kg)',
            },
        },
      },
      series: null,
    };
  },
  async mounted() {
    try {
      this.series = await apiService.getWeightData();
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  },
};
</script>

<style>
.chart-container {
    width: 50vw;
    height: 40vw;
    margin: 0 auto;
    aspect-ratio: 16 / 9;
}
</style>