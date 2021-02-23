package arbolgrafico;
import arbolgrafico.Nodo1;

import java.util.*;
import javax.swing.JPanel;
/*
  private NodoGeneral<E> raiz;
    private int cantidad;

    public ArbolGeneral()
    {
        this.cantidad=0;
    }

    public Elemento<E> getRaiz()
    {
        return raiz;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    private NodoGeneral<E> crearNodo(E e,NodoGeneral<E> padre)
    {
        return new NodoGeneral<E>(e,padre);
    }

    private NodoGeneral<E> validar(Elemento<E> elemento)
    {
        if(!(elemento instanceof NodoGeneral))
        {
            return null;
        }
        NodoGeneral<E> nodoGeneral = (NodoGeneral<E>)elemento;
        return nodoGeneral.getPadre()==nodoGeneral?null:nodoGeneral;
    }

    public boolean esRaiz(Elemento<E> elemento)
    {
        return elemento==getRaiz();
    }

    public boolean estaVacia()
    {
        return getCantidad()==0;
    }

    public Elemento<E>obtenerPadre(Elemento<E> elemento)
    {
        return validar(elemento).getPadre();
    }

    public int cantidadHijos(Elemento<E> elemento)
    {
        NodoGeneral<E> nodoGeneral=validar(elemento);
        return nodoGeneral.cantHijos();
    }

    public int cantidadNiveles(Elemento<E> elemento)
    {
        if(esRaiz(elemento))
        {
            return 0;
        }
        else {
            return 1+cantidadNiveles(obtenerPadre(elemento));
        }

    }


    public int alto(Elemento<E> elemento)
    {
        int alto=0;
        for (Elemento<E> hijo:obtenerHijos(elemento))
        {
            alto=Math.max(alto,1+alto(hijo));
        }
        return alto;
    }

    public ArrayList<Elemento<E>> obtenerHijos(Elemento<E> elemento)
    {
        NodoGeneral<E> nodoGeneral=validar(elemento);
        return nodoGeneral.hijos();
    }

    public Elemento<E> obtenerElemento(E elemento)
    {
        NodoGeneral<Elemento<E>> nodoGeneral=new NodoGeneral<Elemento<E>>();
        buscar(elemento,getRaiz(),nodoGeneral);
        return nodoGeneral.getElemento();
    }

    private void buscar(E elemento, Elemento<E> raiz, NodoGeneral<Elemento<E>> nodoGeneral)
    {
        if(elemento.equals(raiz.getElemento()))
        {
            nodoGeneral.setElemento(raiz);
        }

        for(Elemento<E> x:obtenerHijos(raiz))
        {
            buscar(elemento,x,nodoGeneral);
        }
    }

    public Elemento<E> insertarRaiz(E info)
    {
        if(!estaVacia())
        {
            return null;
        }
        raiz=crearNodo(info,null);
        cantidad=1;
        return raiz;
    }
*/


public class ArbodeExpresiones {
      Stack < Nodo1 > pOperandos = new Stack < Nodo1> ();
       Stack < String > pOperadores = new Stack < String > ();
       
    final String blanco;           
    final String operadores;       

    
   
    public ArbodeExpresiones() {
        
	blanco = " \t";
	operadores = ")+-*/%^(";  
    }

  /**
   * @param expresion 
   * @return NodoArbol
   */
    private Nodo1 raiz;
    
    public Nodo1 getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo1 r) {
        this.raiz = r;
    }
    
    public boolean contruir (String con){
    construirArbol(con);
    return true;
    }
    
    public Nodo1 construirArbol(String expresion) {
       	StringTokenizer tokenizer;
	String token;
	//Nodo1 raiz = null;

	tokenizer = new StringTokenizer(expresion, blanco+operadores, true);
	while (tokenizer.hasMoreTokens()) {
	    token = tokenizer.nextToken();
	    if (blanco.indexOf(token) >= 0) 
		;              
	    else if (operadores.indexOf(token) < 0) {
		                
                                Nodo1 a;
		pOperandos.push( new Nodo1(token));
	    } else if(token.equals(")")) { 
		while (!pOperadores.empty() && !pOperadores.peek().equals("(")) {
		    guardarSubArbol();
		}
		pOperadores.pop(); 
	    } else {
		if (!token.equals("(") && !pOperadores.empty()) {
		        
		    String op = (String) pOperadores.peek();
		    while (!op.equals("(") && !pOperadores.empty()
			   && operadores.indexOf(op) >= operadores.indexOf(token)) {
			guardarSubArbol();
			if (!pOperadores.empty()) 
			    op = (String)pOperadores.peek();
		    }
		}
		pOperadores.push(token); 
	    }
	}

	raiz = (Nodo1)pOperandos.peek();
	while (!pOperadores.empty()) {
	    if (pOperadores.peek().equals("(")) {
		pOperadores.pop();
	    } else {
	    guardarSubArbol();
	    raiz = (Nodo1) pOperandos.peek() ;
	    }
	}
	return raiz;
    }

    private void guardarSubArbol() {
	Nodo1 op2 = (Nodo1) pOperandos.pop();
	Nodo1 op1 = (Nodo1)pOperandos.pop();
	pOperandos.push( new Nodo1(op2, pOperadores.pop(), op1));

    }

    /**
     * Metodo para imprimir un arbol en inorden
     * @param n 
     */
    public void imprime(Nodo1 n) {
	if (n != null) {
	   
	    
	    imprime(n.getNodoDerecho());
            System.out.print(n.getInformacion()+" ");
             imprime(n.getNodoIzquierdo());
	}
    }

    /** 
     * @param n
     */
    public void imprimePos(Nodo1 n) {
	if (n != null) {
	    imprimePos(n.getNodoIzquierdo());
	    imprimePos(n.getNodoDerecho());
	    System.out.print(n.getInformacion()+" ");
	}
    }

    /**
     * 
     * @param n --
     */
    public void imprimePre(Nodo1 n) {
	if (n != null) {
	    System.out.print(n.getInformacion()+" ");
	   
	   
            
              imprimePre(n.getNodoDerecho());
               imprimePre(n.getNodoIzquierdo());
	}
    }
 public JPanel getdibujo() {
       return new ArbolExpresionGrafico(this);
       
    }
    public static void main (String[] pps) {
	 ArbodeExpresiones expr= new  ArbodeExpresiones();
 
        Scanner leer = new Scanner (System.in);
        System.out.println("Digite la expresion aritmetica");
        String expresion =leer.nextLine();
                Nodo1 raiz = expr.construirArbol(expresion);
		System.out.print("El arbol es ");
		expr.imprime(raiz);
	          expr.imprimePre(raiz);
	 
    }
}

