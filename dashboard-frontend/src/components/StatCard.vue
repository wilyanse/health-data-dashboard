<template>
  <div class="stats-comparison">
    <!-- Main stat comparison -->
    <div class="stat">
      <p class="main-stat">{{ mainStat.value }} </p>
      <p class="label">{{ mainStat.label }}</p>
    </div>

    <!-- Secondary stats comparison -->
    <div v-for="(stat, index) in subStats" :key="index" class="stat">
      <p class="sub-stat">{{ stat.value }}</p>
      <p class="label">{{ stat.label }}</p>
      <p class="comp">{{ stat.comp }}</p>
    </div>
  </div>
</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
    mainStat: {
        type: Object,
        required: true,
    },
    subStats: {
        type: Array,
        required: true,
    }
});
</script>

<style scoped>
.stats-comparison {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}

.stat {
  margin-bottom: 10px;
}

.main-stat,
.sub-stat {
  font-size: 1.2rem;
  font-weight: bold;
}

.comparison span {
  font-size: 1rem;
}

.unit {
  font-size: 0.8rem;
  color: #555;
}

.good {
  color: green;
}

.bad {
  color: red;
}
</style>