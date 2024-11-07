<template>
  <q-page padding>
    <q-input v-model="filePath" label="CSV File Path" />
    <q-btn label="Fetch CSV Data" @click="fetchCsvData" color="primary" />

    <div v-if="loading">Loading...</div>
    <q-table
      v-if="!loading && csvData.length"
      :rows="csvData"
      :columns="columns"
      row-key="id"
    />

    <div v-if="error">{{ error }}</div>
  </q-page>
</template>

<script>
import ApiService from 'src/services/ApiService';

export default {
  data() {
    return {
      filePath: '', // Path to the CSV file
      csvData: [], // Data from the CSV file
      loading: false,
      error: null,
      columns: [
        { name: 'Day', label: 'Day', align: 'left', field: 'Day' },
        { name: 'Group', label: 'Group', align: 'left', field: 'Group' },
        { name: 'Metric', label: 'Metric', align: 'left', field: 'Metric' },
        { name: 'Unit', label: 'Unit', align: 'left', field: 'Unit' },
        { name: 'Amount', label: 'Amount', align: 'left', field: 'Amount' }
      ],
    };
  },
  methods: {
    async fetchCsvData() {
      this.loading = true;
      this.error = null;
      try {
        const response = await ApiService.getCsvData(this.filePath);
        this.csvData = response.data;
      } catch (err) {
        this.error = 'Failed to fetch CSV data';
      } finally {
        this.loading = false;
      }
    },
  },
};
</script>
