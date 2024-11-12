<template>
    <div class="chart-container">
        <apexchart :options="chartOptions" :series="chartSeries" type="bar"/>
    </div>
</template>

<script>
import { computed } from 'vue';
import ApexCharts from 'vue3-apexcharts';

export default {
  name: 'CalorieDistributionChart',
  components: {
    apexchart: ApexCharts
  },
  props: {
    data: {
      type: Array,
      required: true
    }
  },
  setup(props) {
    // Compute occurrences of calorie ranges
    const groupedData = computed(() => {
      const ranges = props.data.reduce((acc, item) => {
        const roundedCalories = Math.round(item.calories / 250) * 250;
        acc[roundedCalories] = (acc[roundedCalories] || 0) + 1;
        return acc;
      }, {});
      return Object.entries(ranges).map(([calories, count]) => ({
        x: calories,
        y: count
      }));
    });

    // Define chart series and options
    const chartSeries = computed(() => [
      {
        name: 'Occurrences',
        data: groupedData.value
      }
    ]);

    const chartOptions = computed(() => ({
      chart: {
        type: 'bar',
        zoom: {
            enabled: true
        }
      },
      plotOptions: {
          bar: {
            borderRadius: 4,
            borderRadiusApplication: 'end',
            columnWidth: '50%',
            dataLabels: {
                position: 'top',
            }
          }
      },
      xaxis: {
        title: { text: 'Calories' },
        categories: groupedData.value.map((entry) => entry.x)
      },
      yaxis: {
        title: { text: 'Occurrences' }
      },
      annotations: {
        xaxis: [
            {
                x: 0,
                x2: 200,
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
                    text: 'Cutting',
                    textAnchor: 'start',
                    position: 'top',
                    orientation: 'horizontal',
                }
            },
           {
                x: 300,
                x2: 700,
                borderColor: '#000',
                fillColor: '#ff5e5e',
                opacity: 0.2,
                label: {
                    borderColor: '#333',
                    style: {
                    fontSize: '10px',
                    color: '#333',
                    background: '#ff5e5e',
                    },
                    text: 'Bulking',
                    textAnchor: 'start',
                    position: 'top',
                    orientation: 'horizontal',
                }
            },
        ]
      }
    }));

    return { chartSeries, chartOptions };
  }
};
</script>

<style scoped>
.chart-container {
    aspect-ratio: 16 / 9;
}
</style>