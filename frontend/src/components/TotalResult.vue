<template>
<div class="total-result">
  <b-container >
    <b-row>
        <h3> 레저 / 액티비티 </h3>
    </b-row>
    <b-row>
      <carousel-3d v-if="leisures.length > 0" :width="200" :height="400" controls-visible :perspective="0" :space="300" ref="leisureSlides" :on-main-slide-click="viewLeisure">
        <slide v-for="(leisure, i) in leisures" :key="leisure.id" :index="i">
        <div class="post-card">
          <span class="post-tag">{{leisure.region}}</span>
          <div class="logo">
            <img v-bind:src="leisure.img">
          </div>
          <div class="post-info">
            <div class="post-text">
              <h5>{{leisure.name}}</h5>
              <p class="post-desc">{{leisure.description}}</p>
            </div>
          </div>
        </div>
        </slide>
      </carousel-3d>
    <div v-else class="no-search">
        <img :src="empty"/>
        <h3>검색결과 없음</h3>
      </div>
    </b-row>
    <b-row>
      <div v-if="leisures.length > 0" class="more">더보기...</div>
    </b-row>
    <b-row>
        <h3> 장비 대여 </h3>
    </b-row>
    <b-row>
      <carousel-3d v-if="equips.length > 0" :width="200" :height="400" controls-visible :perspective="0" :space="300" ref="equipSlides" :on-main-slide-click="viewEquip">
        <slide v-for="(equip, i) in equips" :key="equip.id" :index="i">
        <div class="post-card">
          <span class="post-tag">카테고리</span>
          <div class="logo">
            <img v-bind:src="equip.img">
          </div>
          <div class="post-info">
            <div class="post-text">
              <h5>{{equip.name}}</h5>
              <p class="post-desc">{{equip.description}}</p>
            </div>
          </div>
        </div>
        </slide>
      </carousel-3d>
      <div v-else class="no-search">
        <img :src="empty"/>
        <h3>검색결과 없음</h3>
      </div>
    </b-row>
    <b-row>
      <div v-if="equips.length > 0" class="more">더보기...</div>
    </b-row>
    <b-row>
      <h3> 정보 공유 </h3>
    </b-row>
    <b-row>
      <carousel-3d v-if="tips.length > 0" :width="200" :height="400" controls-visible :perspective="0" :space="300" :count="tips.length"  ref="tipSlides" :on-main-slide-click="viewtip">
        <slide v-for="(tip, i) in tips" :key="tip.id" :index="i">
        <div class="post-card">
          <span class="post-tag">{{tip.category}}</span>
          <div class="post-tip">
            <div class="post-text">
              <h3>{{tip.title}}</h3>
              <p class="post-desc">{{tip.date}}</p>
              <p class="post-desc">{{tip.hits}}</p>
            </div>
          </div>
        </div>
        </slide>
      </carousel-3d>
      <div v-else class="no-search">
        <img :src="empty"/>
        <h3>검색결과 없음</h3>
      </div>
    </b-row>
    <b-row>
      <router-link v-if="tips.length > 0" class="more" :to="{ name: 'TipList', params: { word: this.word }}">더보기...</router-link>
    </b-row>
  </b-container>
  </div>
</template>

<script>
import empty from '../assets/empty.png';
import { Carousel3d, Slide } from 'vue-carousel-3d';
import axios from 'axios';

const API_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: 'TotalResult',
  props: {
    word: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      empty,
      leisures: [
      ],
      equips: [
      ],
      tips: [],
    };
  },
  components: {
    Carousel3d,
    Slide
  },
  methods: {
    viewLeisure() {
      this.$router.push({ path: `/leisuredetail/${this.leisures[this.$refs.leisureSlides.currentIndex].id}`});
    },
    viewEquip() {
      this.$router.push({ path: `/leisuredetail/${this.equips[this.$refs.equipSlides.currentIndex].id}`}); // equip 상세페이지로 바꾸기
    },
    viewTip() {
      this.$router.push({ path: `/tipdetail/${this.tips[this.$refs.tipSlides.currentIndex].id}`});
    },
  },
  created () {
    axios({
        method: "GET",
        url: `${API_URL}/shops/search/`+this.word,
      })
        .then((res) => {
          this.equips = res.data.data.rentalShops;
          this.leisures = res.data.data.leisureShops;
          console.log(res)
        })
        .catch((err) => {
          console.log(err);
          alert("예약업체를 검색하던 도중 에러가 발생했습니다.");
        });
        
    axios({
        method: "GET",
        url: `${API_URL}/tip/total?keyword=` + this.word,
      })
        .then((res) => {
          this.tips = res.data.data;
        })
        .catch((err) => {
          console.log(err);
          alert("팁을 검색하던 도중 에러가 발생했습니다.");
        });
  }
}
</script>

<style scoped>
  .total-result {
    padding-top: 100px;
    background-color: #F2F2F5;
  }
  .carousel-3d-slide {
    background-color: #F2F2F5;
    border-style: none;
  }
  .post-card {
    background-color: white;
    max-width: 300px;
    height: 100%;
    border-radius: 5px;
    position: relative;
    font-family: 'roboto', Sans-Serif;
    text-align: center;
    overflow: hidden;
  }
  .post-tag {
    position: absolute;
    right: -6px;
    top: 15px; 
    background-color: #FFD95B;
    font-size: 10px;
    padding: 7px;
    letter-spacing: .4px;
    text-transform: uppercase;
    box-shadow: 0px 1px 2px 0px rgba(0,0,0,0.21);
    z-index: 99;
  }
  .logo {
    height: 50%;
    width: 100%;
    background-color: darkgray;
    display: inline-block;
    position: relative;
  } 
  .logo img {
    max-width: 100%;
    max-height: 100%;
  }
  .post-info{
    display: flex;
    align-items: center;
    margin-top: 25px;
    margin-left: 5px;
  }
  .post-tip{
    display: flex;
    align-items: center;
    margin-top: 40%;
    margin-left: 5px;
  }
  .post-text {
      text-align: left;
      margin-left: 15px;
      margin-right: 15px;
  }
  .post-desc {
      margin: 4px 0;
      font-size: 12px;
  }
  .post-add {
    width: 100%;
    text-align: right;
  }
  .more {
    width: 100%;
    text-align: right;
  }
  .no-search {
    width: 100%;
    height: 400px;
  }
  .no-search img {
    width: 100px;
    height: 100px;
    margin-top: 7%;
    margin-bottom: 7%;
  }
</style>
