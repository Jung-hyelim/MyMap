<template>
  <div id="map" style="width:100%; height:100%; max-height:700px;">지도</div>
</template>
<script>
import { eventBus } from '../main'
export default {
  /* eslint-disable */
  data () {
    return {
      x: 126.570667,
      y: 33.450701,
      name: null,
      address: null,
      place_url: null
    }
  },
  created () {
    eventBus.$on('selectPlace', (x, y, name, address, placeUrl) => {
      this.x = x
      this.y = y
      this.name = name
      this.address = address
      this.place_url = placeUrl
      this.drawMap()
    })
  },
  mounted () {
    this.drawMap()
  },
  methods: {
    drawMap () {
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
              center: new kakao.maps.LatLng(this.y, this.x), // 지도의 중심좌표
              level: 3 // 지도의 확대 레벨
          };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      if(this.name !== null && this.address !== null){
        // 마커가 표시될 위치입니다
        var markerPosition  = new kakao.maps.LatLng(this.y, this.x);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });

        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        var iwContent = '<div style="padding:5px;"><a href="'+this.place_url+'" target="_blank">'+this.name+'</a><br>'+this.address+'<br></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            iwPosition = new kakao.maps.LatLng(this.y, this.x); //인포윈도우 표시 위치입니다

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
            position : iwPosition,
            content : iwContent
        });

        // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
        infowindow.open(map, marker);
      }
    }
  }
}
</script>
