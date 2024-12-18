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
            min: 50,
            max: 90
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
          strokeColors: '#fff',
          strokeWidth: 3,
          strokeOpacity: 0.2,
          fillOpacity: 0.4,
          shape: "circle",
          onDblClick: undefined,
          showNullDataPoints: true,
          hover: {
            size: undefined,
            sizeOffset: 3,
          }
        },
        forecastDataPoints: {
          count: 20,
          fillOpacity: 0.5,
          strokeWidth: 2,
          dashArray: 4,
        },
        annotations: {
          yaxis: [
            {
              y: 65,
              y2: 0,
              borderColor: '#000',
              fillColor: '#FEB019',
              opacity: 0.2,
              label: {
                borderColor: '#333',
                style: {
                  fontSize: '10px',
                  color: '#333',
                  background: '#FEB019',
                },
                text: 'Goal weight',
              }
            },
          ],
          xaxis: [],
          points: [],
        },
      },
      series: null,
    };
  },
  async mounted() {
    try {
      this.series = await apiService.getWeightData();

      const maxYObject = this.series[0].data.reduce((maxObj, current) => (current.y > maxObj.y ? current : maxObj), this.series[0].data[0]);
      this.chartOptions.yaxis.max = Math.ceil(maxYObject.y / 10) * 10;

      const minYObject = this.series[0].data.reduce((minObj, current) => (current.y < minObj.y ? current : minObj), this.series[0].data[0]);
      this.chartOptions.yaxis.min = Math.floor(Math.min(minYObject.y, 50) / 10) * 10;
      this.chartOptions.annotations.points.push(
        {
          x: minYObject.x,
          y: minYObject.y,
          marker: {
            fillColor: '#2d9c01',
          }
        },
        {
          x: maxYObject.x,
          y: maxYObject.y,
          marker: {
            fillColor: '#5700b9',
          }
        }
      );
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  },
};
</script>

<style scoped>
  .chart-container {
    aspect-ratio: 16 / 9;
  }
</style>