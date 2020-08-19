<template>
  <table>
    <th>Filename</th>
    <th>Size (bytes)</th>
    <th>Processed</th>

    <tbody>
      <tr v-for="file in files" :key="file.fileName">
        <td>{{file.fileName}}</td>
        <td>{{file.size}}</td>
        <td>{{file.processedTime}}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "v-table",
  props: {
    files: {
      type: Array,
      default: [],
    },
  },
};
</script>

<style lang="sass">
table
  width: 100%
  border-collapse: collapse

  & > th
    font-size: 1.3em
    font-style: bolder
    height: 15px
    text-align: left
    padding: 1% 0 2% 1%

table, th, td
  border: 1px solid black
</style>