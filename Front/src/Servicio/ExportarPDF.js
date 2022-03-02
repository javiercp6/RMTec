import jsPDF from 'jspdf'


export default class ExportarPdf {

   exportar(data) {
      return 
   }

   obtenerPorUserName(userName){
      
      return axios.post(this.url + `/obtenerporusername/${userName}`) 
   }

   listarPorSolicitud(){
      return axios.get(this.url + "/listarporsolicitud/", this.options ) 
   }
   

   eliminar() {
      return axios.delete(this.url + "/eliminar", this.options) 
    }
}