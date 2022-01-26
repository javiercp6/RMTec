import Vue from 'vue'
import axios from 'axios'

Vue.prototype.$axios = axios

if (localStorage.getItem("token")) {
    console.log("Hay un token")
    axios.defaults.headers.common['Authorization'] = localStorage.getItem("token")
}