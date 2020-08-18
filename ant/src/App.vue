<template>
  <div class="container">
    <div id="table-card" class="card">
      <v-table />
    </div>
    <div class="card">
      <button class="primary">Upload</button>
    </div>
  </div>
</template>

<script>
import VTable from "./components/Table.vue";

export default {
  name: "App",
  components: {
    VTable,
  },
  data() {
    return {
      message: "",
    };
  },
};
</script>

<style lang="sass">
*
  padding: 0
  margin: 0
  box-sizing: border-box
  outline: none

html
  padding: 0
  margin: 0

body
  padding: 0
  margin: 0
  height: 100%
  background-color: whitesmoke

#app
  display: grid
  justify-items: center

  & > .container
    padding: 1%
    max-width: 700px
    width: 100%
    display: flex
    flex-direction: column
    justify-content: space-around
    background-color: #d5e4ff

    & > #table-card
      padding: 2% 2% 8% 2%

    & > .card
      border-radius: 2px
      margin: 1%
      padding: 3%
      background-color: #a9c8ff

      & .primary
        cursor: pointer
        border-radius: 7px
        font-size: 1.4em
        padding: 1% 7% 1% 7%
        background-color: #497bd5
        color: whitesmoke
        border: 2px solid #313160
</style>