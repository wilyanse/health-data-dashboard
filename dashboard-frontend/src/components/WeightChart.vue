<template>
  <div class="chart-container">
    <apexchart type="line" :options="chartOptions" :series="series"></apexchart>
  </div>
</template>

<script>
import VueApexCharts from 'vue3-apexcharts';

// TODO: Replace with real data
const csvData = [
  { Day: "2024-08-04", Group: "Uncategorized", Metric: "Weight", Unit: "lbs", Amount: 158.5 },
  { Day: "2024-08-06", Group: "Uncategorized", Metric: "Weight", Unit: "lbs", Amount: 161.7 },
  { Day: "2024-08-07", Group: "Uncategorized", Metric: "Weight", Unit: "lbs", Amount: 161.0 },
];

const poundsToKg = pounds => parseFloat(pounds * 0.453592).toFixed(2);

const parsedData = csvData.map(entry => ({
  x: new Date(entry.Day).getTime(),
  y: poundsToKg(entry.Amount)
}));

const seriesData = [{
  name: 'Weight (kg)',
  data: parsedData
}];

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
      series: seriesData,
    };
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