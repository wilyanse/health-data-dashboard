<template>
  <div class="stats-comparison">
    <!-- Main stat comparison -->
    <div class="stat">
      <p class="main-stat">{{ mainStat.label }}: {{ mainStat.value }}</p>
    </div>

    <!-- Secondary stats comparison -->
    <div v-for="(stat, index) in subStats" :key="index" class="stat">
      <p class="sub-stat">{{ stat.label }}: {{ stat.value }}</p>
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
  padding: 20px;
  background-color: aliceblue;
  width: 20%;
  margin: 10px;
  border-radius: 10%;
  text-align: left;
  justify-content: center;
}

.stat {
    width: 90%;
}

.main-stat{
  font-size: 1.2rem;
  font-weight: bold;
}

.sub-stat {
    font-size: 0.8rem;
}

.good {
  color: green;
}

.bad {
  color: red;
}
</style>