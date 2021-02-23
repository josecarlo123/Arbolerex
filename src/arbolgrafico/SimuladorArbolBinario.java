
package arbolgrafico;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jose Carlos
 */
public class SimuladorArbolBinario {


     ArbodeExpresiones miArbol = new ArbodeExpresiones();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(String dato) {
 
      return (this.miArbol.contruir(dato));
    }

    public String borrar(Integer dato) {
            return ("No existe el dato en el arbol");
    }

  public String preOrden() {
       return "hola";
   }

    public String inOrden() {
        return "hola";
    }

    public String posOrden() {
        return "hola";
    }

    public String imprimirPorNiveles() {
        return "hola";
    }

    public String darHojas() {
        return "hola";
    }

    public String darPadre(Integer hijo) {
        /*
        if (this.miArbol.getRaiz().getDato() == (hijo)) {
            return ("La raiz no tiene padre");
        }
        Integer padre = this.miArbol.padre(hijo);
        if (padre == null) {
            return ("No existe el Dato: " + hijo.toString());
        }
        return ("El padre de: " + hijo + "\n es : " + padre.toString());
        */
         return "hola";
    }

    public String esta(Integer dato) {
       // boolean siEsta = this.miArbol.buscar(dato);
      //  String r = "El dato:" + dato.toString() + "\n";
      //  r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
       // return (r);
       return "hola";
    }

    private String recorrido(ArrayList it, String msg) {
        /*
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);
*/
      return "hola";   
    }
    
    public String CantidadNodos(){
        return "hola";
    }
    
    public String CantidadHojas(){
        return "hola";
    }
    public String alturaArbol(){
         return "hola";
    }
    public String menorValor(){
         return "hola";
    }
    public String mayorValor(){
         return "hola";
    }
    public String balance(){
         return "hola";
    }
    public String borrarMenor(){
          return "hola";
    }
    public String borrarMayor(){
          return "hola";
    }
    public String porNivel(){
         return "hola";
    }
    public String cambiar() {
         return "hola";
    }
    public String ramaMayor() {
          return "hola";
    }
    

    public void podarArbol() {
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }

}
