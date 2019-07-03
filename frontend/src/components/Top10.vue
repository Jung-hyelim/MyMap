<template>
  <div id="popular">
    <h1>인기 키워드</h1>
    <ul class="list">
      <li>
        <span class="span-rank">랭킹</span>
        <span class="span-keyword">키워드</span>
        <span class="span-count">검색수</span>
      </li>
      <li v-for="item in list" :key="item.keyword" class="item">
        <span class="span-rank">{{ item.rank }}</span>
        <span class="span-keyword">{{ item.keyword }}</span>
        <span class="span-count">{{ item.search_count }}</span>
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
    this.$axios({
      method: 'GET',
      url: '/popular'
    })
      .then(response => {
        this.list = response.data
      })
      .catch(error => {
        console.log(error)
      })
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
.span-rank {
  display: inline-block;
  width: 20%;
}
.span-keyword {
  display: inline-block;
  width: 45%;
}
.span-count {
  display: inline-block;
  width: 30%;
}
</style>
