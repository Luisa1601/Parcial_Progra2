
package porrateofactura;

import datos.ManipularDatos;


public class Principal {
    
    
    //CREAMOS UN OBJETO DE TIPO ManipularDatos
    //DE ESTA FORMA TENEMOS EL CÓDGIO SEPARADO Y AQUÍ POR MEDIO DE ESE MÉTODO LO LLAMAMOS
    ManipularDatos manipular = new ManipularDatos();
    
    public void iniciar(){
        
        //PRIMERO LLAMAMOS AL MÉTODO LLENAR DATOS QUE CONTIENE EL CÓDIGO NECESARIO PARA EL INGRESO DE DATOS FIJOS
        manipular.llenadoDatos();
        
        //CUANDO LOS DATOS YA ESTÁN INGRESADOS MANDAMOS A LLAMAR AL  MÉTODO MOSTRAR
        //ESTE MÉTODO CONTIENE TODOS LOS PASOS PARA REALIZAR EL EJERCICIO
        manipular.mostrarDatos();
    }
    
}
