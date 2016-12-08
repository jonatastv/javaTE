package trabalhoAED;

import Fila.*;

public class FilaDinamica 
{
	NoFila inicio;
	NoFila fim;
	
	public FilaDinamica()
	{
		inicio = null;
		fim = null;
	}
	
	public void enqueue(double valor) 
	{
  
		NoFila p = new NoFila(valor);

		if (filaEstaVazia()) // caso a fila esteja vazia
		{ 
			inicio = p;  
		} 
			  
		else // caso contrario
		{  
			fim.proximo = p;
		}
		 
		fim = p; // fim da fila aponta para novo elemento
		
	}
	
	public double dequeue() 
	{
		
		double v;
		  
		if (filaEstaVazia()) 
		{
			System.out.println("Fila vazia.");
			System.exit(1); // aborta programa 
		}
		  
		v = inicio.info;
		inicio = inicio.proximo;
		  
		if (inicio == null) // fila ficou vazia?
		{
			fim = null; // fim tambem deve receber null
		}
		  
		return v;
	  
	}
	
	public void imprime()
	{
		NoFila q;

		for (q = inicio; q != null; q = q.proximo)
		{
			System.out.print(q.info + " ");
		}

		System.out.println();
	} 
        
        public int get_fist(){
            double v;
       v = inicio.info;
       
        
            
            return  (int) v;
        }
        
        
        public double clear() 
	{
		
		double v;
		  
		if (filaEstaVazia()) 
		{
			System.out.println("Fila vazia.");
			System.exit(1); // aborta programa 
		}
		  
		v = inicio.info;
		inicio = inicio.proximo;
		  
		if (inicio == null) // fila ficou vazia?
		{
			fim = null; // fim tambem deve receber null
		}
		  
		return v;
	  
	}
        
        
        
        
        
        
	public boolean filaEstaVazia()
	{
		return (inicio == null);
	}

}
