<template>
  <div id="history">
    <h1>최근 검색어</h1>
    <ul class="list">
      <li v-for="item in list" :key="item.keyword" class="item">
        <span class="span-keyword">{{ item.keyword }}</span>
        <span class="span-date">{{ item.date }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
/* eslint-disable */
export default {
  data () {
    return {
      list: []
    }
  },
  mounted () {
    this.getLocalStorage()
  },
  methods: {
    getLocalStorage () {
      if(localStorage.history){
       var list = JSON.parse(localStorage.history)
       this.list = list
      }
    }
  }
}
</script>

<style scoped>
#popular {
  text-align: center;
}
ul.list {
  list-style: none;
  margin: 10px 0px 0px 0px;
  padding: 0px;
  width: 100%;
}
ul.list li {
  padding: 5px 0px 5px 5px;
  border-bottom: 1px solid #efefef;
  font-size: 1.1em;
  width: 100%;
}
ul.list .item:hover {
  cursor: pointer;
  background-color: #efefef;
}
.span-keyword {
  display: inline-block;
  width: 50%;
}
.span-date {
  display: inline-block;
  width: 45%;
}
</style>
