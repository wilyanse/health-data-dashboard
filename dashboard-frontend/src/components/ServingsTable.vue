<template>
  <q-card class="q-pa-md">
    <q-card-section>
      <q-table
        :rows="data"
        :columns="columns"
        row-key="date"
        flat
        bordered
        :dense="true"
        rows-per-page-label="Show:"
      >
        <template v-slot:body-cell-date="props">
          {{ new Date(props.row.date).toLocaleDateString() }}
        </template>
      </q-table>
    </q-card-section>
  </q-card>
</template>

<script>
import { ref, computed } from "vue";

export default {
  name: "FoodTable",
  props: {
    data: {
      type: Array,
      required: true,
    },
  },
  setup() {
    const columns = ref([
      { name: "date", align: "left", label: "Date", field: "date" },
      { name: "groupName", align: "left", label: "Group", field: "groupName" },
      { name: "foodName", align: "left", label: "Food", field: "foodName" },
      { name: "amount", align: "left", label: "Amount", field: "amount" },
      { name: "calories", align: "right", label: "Calories", field: "calories" },
      { name: "protein", align: "right", label: "Protein (g)", field: "protein" },
    ]);

    return {
      columns,
    };
  },
};
</script>

<style scoped>
.q-table {
  font-size: 14px;
}
</style>
