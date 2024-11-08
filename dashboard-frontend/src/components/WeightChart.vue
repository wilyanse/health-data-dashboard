<template>
  <div class="chart-container" v-if="chartOptions != null">
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
      chartOptions: null,
      series: null,
    };
  },
  async mounted() {
    try {
      const response = await apiService.getWeightData();
      const csvData = response.data;

      const poundsToKg = pounds => parseFloat(pounds * 0.453592).toFixed(2);

      const parsedData = csvData.map(entry => ({
        x: new Date(entry.date).getTime(),
        y: entry.unit === "lbs" ? poundsToKg(entry.amount) : entry.amount
      }))
      .sort((a, b) => a.x - b.x);

      const seriesData = [{
        name: 'Weight (kg)',
        data: parsedData
      }];

      this.chartOptions = {
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
      };
      this.series = seriesData;
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