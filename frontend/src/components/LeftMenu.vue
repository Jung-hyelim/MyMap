<template>
  <div class="hello">
    <div id="menu">
      <ul class="list">
        <li><router-link :to="{ name: 'Keyword', params: {} }">키워드 검색</router-link></li>
        <li><router-link :to="{ name: 'Top10', params: {} }">인기 키워드</router-link></li>
        <li><router-link :to="{ name: 'History', params: {} }">최근 검색어</router-link></li>
      </ul>
    </div>
    <div id="content">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style scoped>
ul.list {
  list-style: none;
  margin: 0px;
  padding: 0px;
  width: 100%;
}
ul.list li {
  display: inline-block;
  margin: 0px 10px;
}
ul.list li a {
  display: inline-block;
  padding: 10px;
  margin-bottom: 5px;
  border: 1px solid #efefef;
  font-size: 12px;
  cursor: pointer;
  -webkit-transition: background-color 0.3s linear;
  -moz-transition: background-color 0.3s linear;
  -ms-transition: background-color 0.3s linear;
  -o-transition: background-color 0.3s linear;
  transition: background-color 0.3s linear;
}
ul.list a:hover {
  background-color: #efefef;
}
ul.list a {
  color: #42b983;
  padding: 5px;
  border: 1px solid white;
  background-color: white;
  text-decoration: none;
  font-size: 1.2em;
  font-weight: bold;
}
#menu {
  padding-top: 10px;
  padding-bottom: 15px;
  border-bottom: 1px solid;
}
#content {
  margin-top: 30px;
}
</style>
