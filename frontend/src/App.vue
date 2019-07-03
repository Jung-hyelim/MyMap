<template>
  <div id="app">
    <div id="left">
      <LeftMenu/>
    </div>
    <div id="right">
      <Map/>
    </div>
  </div>
</template>

<script>
import Map from '@/components/Map'
import LeftMenu from '@/components/LeftMenu'

export default {
  name: 'App',
  components: {
    Map,
    LeftMenu
  }
}
</script>

<style>
* {
  margin: 0px;
  padding: 0px;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: grid;
  grid-template-columns: 30% 70%;
  position: relative;
  overflow: hidden;
  min-height: 700px;
}
#left {
  height: 100%;
  float: left;
}
#right {
  height: 100%;
  float: left;
  overflow: hidden
}
</style>
