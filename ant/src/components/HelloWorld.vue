<template>
  <h1>{{ message }}</h1>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    message: String,
  },
  data() {
    return {
      count: 0,
    };
  },
};
</script>
