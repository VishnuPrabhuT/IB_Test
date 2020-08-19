<template>
  <div class="container">
    <card class="card">
      <v-table :files="files" />
      <div class="error">{{error}}</div>
    </card>
    <card class="card">
      <button class="primary" @click="openDialog">Upload</button>
      <input
        id="file-input"
        ref="file-input"
        @change="addFile($event)"
        type="file"
        accept="image/*, .doc, .docx, .txt, .pdf"
        multiple="false"
        style="display:none"
      />
    </card>
  </div>
</template>

<script>
import { fetcher } from "./modules/fetcher.js";

import VTable from "./components/Table.vue";
import Card from "./components/Card.vue";

export default {
  name: "App",
  components: {
    VTable,
    Card,
  },
  data() {
    return {
      files: [],
      error: "",
    };
  },
  mounted() {
    fetcher.fetchGET("http://localhost:8085/getFileDetails").then(
      (files) => {
        console.log(files);
        this.files = files;
        this.getFiles();
      },
      (error) => {
        this.error = error;
      }
    );
  },
  methods: {
    setupSSE() {
      let evtSource = new EventSource(
        "http://localhost:8085/streamFileDetails"
      );
      try {
        let id;
        let vueRef = this;
        evtSource.onmessage = function (event) {
          //console.log(event);
          vueRef.files = JSON.parse(event.data);
          clearInterval(id);
          id = null;
        };
      } catch {
        throw new Error();
      }
      return evtSource;
    },
    getFiles() {
      let vueRef = this;
      let evtSource = this.setupSSE();
      evtSource.onerror = function (event) {
        evtSource.close();
        try {
          evtSource = this.setupSSE();
        } catch {
          setTimeout(() => {
            vueRef.getFiles();
          }, 5000);
        }
      };
    },
    openDialog() {
      this.$refs["file-input"].click();
    },
    addFile(event) {
      let file = event.target.files[0];

      if (file && this.files.length > 3) {
        this.error = "Cannot upload more than 3 files.";
        return;
      }

      let [date, time] = new Date(Date.now()).toISOString().split("T");
      time = time.split(".")[0];

      let fileItem = {
        fileName: file.name,
        size: file.size,
        processedTime: `${date} ${time}`,
      };

      fetcher.fetchPOST("http://localhost:8085/addFileDetails", fileItem).then(
        (result) => {
          this.files.push(fileItem);
        },
        (error) => {
          this.error = error;
        }
      );
    },
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
  height: 100%

body
  padding: 0
  margin: 0
  background-color: whitesmoke
  min-height: 100%

#app
  display: grid
  justify-items: center

  & .error
    margin-top: 5%
    color: red

  & > .container
    margin-top: 60px
    padding: 1%
    max-width: 700px
    width: 100%
    display: flex
    flex-direction: column
    justify-content: space-around
    background-color: #d5e4ff

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