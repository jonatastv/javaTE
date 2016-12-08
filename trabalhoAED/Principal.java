
package trabalhoAED;



public class Principal
{
      
	public static void main(String[] args) {
	  
              int valor=0;  
                FilaDinamica f1 = new FilaDinamica();
                NoArvore raiz = null;
		
		ABB arvore = new ABB();
		
                f1.enqueue(5);
                f1.enqueue(8);
                f1.enqueue(3);
                f1.enqueue(14);
                f1.enqueue(2);
                f1.imprime();
	
	
                while (!f1.filaEstaVazia()) {
                
               valor = (int) f1.dequeue();
                raiz = arvore.abb_insere(raiz,valor);
                   
            }
              System.out.println(valor);
              
              
              System.out.println("raizz!!");
              arvore.abb_imprime(raiz, "");
              
                	f1 = null;
                
	}

   
}
