package pksWS;


import pkgModelo.MDB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pkgModelo.*;

/**
 *
 * @author AVJ-01
 */
@WebService(serviceName = "WSBDSOA")
public class WSBDSOA {
    MDB obj = new MDB();
    MDB administradorBD = new MDB();
    Tester obj2 =  new Tester();
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {        
        String leyenda;
        //insertar
        String Data = "null, 'Maye','vazquez','Juarez',12346";
        obj2.antoni(Data);
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "Create")
    public  String Create(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "apPaterno") String apPaterno, @WebParam(name = "apMaterno") String apMaterno, @WebParam(name = "codigoAcceso") int codigoAcceso) {
        String Respuesta = "";
        String DATOS = "nombre='" + nombre + "',apPaterno='" + apPaterno + "',apMaterno='" + apMaterno + "',codigoAcceso=" + String.valueOf(codigoAcceso) + "";
        Respuesta = obj.registrarAlta("tbpersona2", "null," + DATOS);

        return Respuesta;
    }

    @WebMethod(operationName = "Update")
    public String Update(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "apPaterno") String apPaterno, @WebParam(name = "apMaterno") String apMaterno, @WebParam(name = "codigoAcceso") int codigoAcceso) {
        String Respuesta = "";
        String DATOS = "nombre='" + nombre + "',apPaterno='" + apPaterno + "',apMaterno='" + apMaterno + "',codigoAcceso=" + String.valueOf(codigoAcceso) + "";

        Respuesta = obj.modificarRegistro("tbpersona2", DATOS, "id =" + id + "");

        return Respuesta;
    }

    @WebMethod(operationName = "Delete")
    public String Delete(@WebParam(name = "id") int id) {
        String Respuesta = "";
        Respuesta = obj.borrarRegistro("tbpersona2", "id =" + String.valueOf(id));

        return Respuesta;
    }

}
