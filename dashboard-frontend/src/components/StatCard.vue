<template>
  <div class="stats-comparison">
    <!-- Main stat comparison -->
    <div class="main-stat">
      <p class="main-stat-value value">{{ mainStat.value }}</p>
      <p class="main-stat-label label">{{ mainStat.label }}</p>
    </div>

    <!-- Secondary stats comparison -->
    <div class="substats">
        <div v-for="(stat, index) in subStats" :key="index">
            <div class="substat-elements">
                <q-icon v-if="stat.comp == false && mainStat.value >= stat.value"
                name="keyboard_double_arrow_up" class="icons" size="2rem" color="red"/>
                <q-icon v-else
                name="keyboard_double_arrow_down" class="icons" size="2rem" color="green"/>
                
                <div class="substat-text">
                    <p class="sub-stat-value value">{{ stat.value }}</p>
                    <p class="sub-stat-label label">{{ stat.label }}</p>
                </div>
            </div>
        </div>
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
  background-color: aliceblue;
  margin: auto;
  border-radius: 10%;
  text-align: center;
  width: fit-content;
  padding: 1%;
}

.main-stat {
  font-size: 3rem;
  margin: auto;
  display: flex;
  flex-direction: column;
  width: fit-content;
  height: fit-content;
  justify-content: center;
}

.main-stat-value {
    font-weight: bold;
    margin: auto;
    width: fit-content;
}

.main-stat-label {
    font-size: 2rem;
    margin: auto;
    width: fit-content;
}

.substats {
    font-size: 1rem;
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: fit-content;
    margin: auto;
    border-style: solid none none none;
    border-color: darkcyan;
}

.substat-elements {
    display: flex;
    flex-direction: column;
    align-items: center;
    vertical-align: middle;
    margin: 0 20px;
    padding: 5px;
}

.good {
  color: green;
}

.bad {
  color: red;
}

.value {
    font-weight: bold;
}

.label {
    margin-top: -25px;
}
</style>