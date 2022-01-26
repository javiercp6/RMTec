import axios from "axios";


export default class Login {
   options = {
      headers:{
          'content-type':'application/json',
          "Acces-Control-Allow-Origin":"*",
      },
       }
   url = "http://localhost:8080/login"

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