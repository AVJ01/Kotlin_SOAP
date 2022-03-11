package pkgModelo;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    /**
     * @param args
     */
    /*public static void main(String[] args) {
        
    }*/

    public void antoni(String data) {

        MDB administradorBD = new MDB();
        String leyenda;
        //insertar

        leyenda = administradorBD.registrarAlta("tbpersona2", data );
        //leyenda= administradorBD.borrarRegistro("tbpersona2", "id =2");
        System.out.println(leyenda);
    }
}
