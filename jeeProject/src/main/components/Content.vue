<template>
  <div id="content">
    <Configuration v-show="getContent() === 'configuration'" v-on:data-update="updateData"/>
    <Result :data="search"/>
  </div>
</template>

<script>
import Configuration from "./Content/Configuration.vue";
import Result from "./Content/Result.vue";

export default {
  name: "Content",
  components: {
    Result,
    Configuration
  },
  data() {
    return {search: {books:[]}}
  },
  methods: {
    getContent() {
      return this.$parent.content;
    },
    updateData(data) {
      let parsedData = {books:[]};
      data.forEach(dat=>{
        if(dat[0].startsWith('check-')){
          let selectedData = data.filter(field=> field[0] === dat[0].replace('check-', ''))[0];
          if(selectedData !== undefined) parsedData[selectedData[0]] = selectedData[1];
        }if(dat[0] === 'book'){
          parsedData['books'].push(dat[1]);
        }
      })
      console.log(parsedData);
      this.search = parsedData;
    }
  }
};
</script>

<style scoped>
#content {
  flex: 1 1 auto;
  background-color: slategrey;
}
</style>
