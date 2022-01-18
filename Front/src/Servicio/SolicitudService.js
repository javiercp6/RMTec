import axios from "axios";


export default class Solicitud {
   options = {
      headers:{
          'content-type':'application/json',
          "Acces-Control-Allow-Origin":"*"
      },
       }
   url = "http://localhost:8080/solicitud"

   listar(data) {
      return axios.get(this.url + "/listar/", data , this.options ) 
   }

   listaCompletaEnviada(){
      return axios.get(this.url + "/listacompletaenviada/", this.options ) 
   }
   
   modificar(data) {
      data.estado = 'Enviada'
      return axios.put(this.url + "/modificar/", data, this.options) 
   }

   salvar(data) {
       return axios.post(this.url + "/salvar/", data, this.options) 
    }
   
   salvarSolicitud(data) {
      const salvSolicitud = {
         idUsuario: 2,
         solicitud: {
            id: data.id,
            marca: data.marca,
            modelo: data.modelo,
            noserie: data.noserie,
            macwifi: data.macwifi,
            maccable: data.maccable,
            tipo: "Laptop",
            estado: "Enviada",
            fecha: new Date
         },
         }
         console.log(salvSolicitud)

      return axios.post(this.url + "/salvarsolicitud/", salvSolicitud, this.options) 
   }

   cambiarEstado(id, est){
      const solicitud = {
         idSolicitud: id,
         estado: est
      }
      console.log(solicitud)
      return axios.put(this.url + "/cabiarestado/", solicitud ,  this.options) 
   }

   eliminarPorId(id) {
     return axios.delete(this.url + `/eliminar/${id}`, this.options) 
   }

   eliminar() {
      return axios.delete(this.url + "/eliminar", this.options) 
    }
}