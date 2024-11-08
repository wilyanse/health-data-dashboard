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
        stroke: {
            show: true,
            curve: 'smooth',
            lineCap: 'butt',
            colors: undefined,
            width: 2,
            dashArray: 0, 
        },
        markers: {
          size: 3,
          colors: undefined,
          strokeColors: '#fff',
          strokeWidth: 3,
          strokeOpacity: 0.2,
          strokeDashArray: 0,
          fillOpacity: 0.4,
          discrete: [],
          shape: "circle",
          offsetX: 0,
          offsetY: 0,
          onClick: undefined,
          onDblClick: undefined,
          showNullDataPoints: true,
          hover: {
            size: undefined,
            sizeOffset: 3,
          }
      },
      forecastDataPoints: {
        count: 3,
        fillOpacity: 0.5,
        strokeWidth: 2,
        dashArray: 4,
      }
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
    width: 30%;
    height: 20%;
    margin: 0 auto;
    aspect-ratio: 16 / 9;
}
</style>