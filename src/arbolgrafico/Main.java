
package arbolgrafico;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Gui().setVisible(true);
    }
}
/*


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(!arbolGeneral.estaVacia())
        {
            dibujar(g,arbolGeneral.getRaiz(),getWidth()/2,30,getWidth()/5);
        }
    }

    private void dibujar(Graphics g, Elemento<E> raiz, int x, int y, int espacioH)
    {
        g.drawOval(x-radio,y-radio,2*radio,2*radio);
        g.drawString(raiz.getElemento() + "", x - 6, y + 4);
        ArrayList<Elemento<E>>hijos=arbolGeneral.obtenerHijos(raiz);
        coordenadas.put(raiz,new Point(x,y));
        for(Elemento<E> hijo:hijos)
        {
            Point punto=coordenadas.get(arbolGeneral.obtenerPadre(hijo));
            dibujarLinea(g,x-espacioH,y+espacioVertical,punto.x,punto.y);
            dibujar(g,hijo,x-espacioH,y+espacioVertical,espacioH/hijos.size());
            x+=espacioH;
        }
    }
*/