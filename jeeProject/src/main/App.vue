<template>
  <div id="app">
    <Navbar></Navbar>
    <Content></Content>
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue";
import Content from "./components/Content.vue";

export default {
  name: "App",
  components: {
    Navbar,
    Content
  },
  data() {
    return {
      content: "configuration"
    }
  }
};
</script>

<style>
html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}

#app {
  font-family: sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: flex;
  flex-flow: column;
  height: 100%;
}
</style>