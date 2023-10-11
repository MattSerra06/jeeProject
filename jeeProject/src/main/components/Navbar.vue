<template>
  <nav class="navbar navbar-dark bg-dark">
    <div class="container">
      <a class="nav-link" v-on:click="changeContent('configuration')">Configuration</a>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  methods: {
    changeContent (content) {
      this.$parent.content = content;
    }
  }
};
</script>

<style scoped>
a {
  color: red;
  font-size: 1.5em;
}

a:hover {
  cursor: pointer;
}
</style>
