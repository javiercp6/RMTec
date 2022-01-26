import axios from "axios";


export default class Usuario {
   options = {
      headers:{
          'content-type':'application/json',
          "Acces-Control-Allow-Origin":"*",
          //'Authorization': localStorage.getItem("token")
      },
       }
   url = "http://localhost:8080/usuario"

   listar(data) {
      return axios.get(this.url + "/listar/", data , this.options ) 
   }


   listaPorSolicitud(){
      return axios.get(this.url + "/listarporsolicitud/", this.options ) 
   }
   

   eliminar() {
      return axios.delete(this.url + "/eliminar", this.options) 
    }
}