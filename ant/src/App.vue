<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <HelloWorld :message="message" />
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "App",
  components: {
    HelloWorld,
  },
  data() {
    return {
      message: "",
    };
  },
  mounted() {
    fetch("http://localhost:8085/")
      .then((response) => response.text())
      .then((message) => {
        this.message = message;
      });
  },
};
</script>
