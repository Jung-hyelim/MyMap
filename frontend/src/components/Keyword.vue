<template>
  <div id="search">
    <div id="input-keyword">
      <input v-model="keyword" @keyup.enter="search(1)" placeholder="키워드 입력">
      <button @click="search(1)">검색</button>
    </div>
    <div id="result">
      <h3>검색결과</h3>
      <div v-if="list.length === 0">
        검색 결과가 없습니다.
      </div>
      <div v-else>
        <ul>
          <li v-for="(item, index) in list" :key="item.id" class="search-item">
            <div>
              <span>{{ (page - 1 ) * size + index + 1 }}</span>
              <span><button @click="selectPlace(item)">{{ item.place_name }}</button></span><br>
              <span>{{ item.category_group_name }}</span>
              <span>({{ item.category_name }})</span><br>
              <span>{{ item.address_name }}</span><br>
              <span>{{ item.road_address_name }}</span><br>
              <span>{{ item.phone }}</span>
            </div>
          </li>
        </ul>
      </div>
      <div class="pagination" v-if="list.length > 0">
        <a v-if="page > 1" @click.stop="prev()">이전</a>
        <a>{{ page }}</a>
        <a v-if="!is_end" @click.stop="next()">다음</a>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import { eventBus } from '../main'
export default {
  data () {
    return {
      keyword: null,
      list: [],
      page: 1,
      size: 15,
      is_end: false,
      history: []
    }
  },
  methods: {
    search: function (page) {
      this.saveLocalStorage(this.keyword)
      this.$axios({
        method: 'GET',
        url: '/search/'+this.keyword,
        params: {page: page}
      })
        .then(response => {
          this.list = response.data.documents
          this.page = page
          this.is_end = response.data.meta.is_end
        })
        .catch(error => {
          console.log(error)
        })
    },
    selectPlace: function (item) {
      eventBus.selectPlace(item.x, item.y, item.place_name, item.address_name, item.place_url)
    },
    prev: function () {
      --this.page;
      this.search(this.page)
    },
    next: function () {
      ++this.page;
      this.search(this.page)
    },
    saveLocalStorage (value) {
      if( !localStorage.history ){
        localStorage.history = "[]"
      }
      var list = JSON.parse(localStorage.history)
      if( list.indexOf(value) === -1 ){
        list.unshift({'keyword':value, 'date':new Date()});
      }
      localStorage.setItem('history', JSON.stringify(list))
    }
  }
}
</script>

<style scoped>
#input-keyword {
  padding: 10px;
}
#input-keyword input {
  width: 80%;
}
#input-keyword button {
  width: 15%;
}
#result {
  padding: 10px;
  text-align: left;
}
.pagination {
  display: inline-block;
  text-align: center;
}
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  text-align: center;
}
.pagination a.active {
  background-color: #4CAF50;
  color: white;
}
.pagination a:hover:not(.active) {background-color: #ddd;}
.search-item {
  padding: 2px;
  border-bottom: 1px solid #efefef;
  font-size: 1.0em;
}
</style>
