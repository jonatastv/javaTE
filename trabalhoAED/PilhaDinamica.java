package trabalhoAED;

import pilha.*;

public class PilhaDinamica
{
	NoPilha topo;
	
	public PilhaDinamica()
	{
		this.topo = null;
	}
	
	public void push(double valor)
	{
		NoPilha aux = new NoPilha(valor);
		aux.proximo = topo;
		topo = aux;
	}
	
	public double pop()
	{
		double valor;
		NoPilha aux;
		
		if (pilhaEstaVazia()) 
		{
			System.out.println("Pilha vazia.");
			System.exit(1); /*aborta o programa*/
		}
		
		valor = topo.info;
		
		aux = topo;
		topo = aux.proximo;
		
		return valor;
	}
	
	public void imprime() 
	{
		for(NoPilha q = topo; q!=null; q = q.proximo)
		{
			System.out.println(q.info);
		}
	}

	public boolean pilhaEstaVazia()
	{
		return (topo == null);
	}


         public char fecho(char c)
        {
        if(c == '}') return '{';
        if(c == ']') return '[';
        if(c == ')') return '(';
        return ' ';
        }
        
        public boolean verifica(String exp) {
        char caractere;
        for(int i = 0; i < exp.length(); i++)
        {
        if(exp.charAt(i) == '{' ||
        exp.charAt(i) == '[' ||
        exp.charAt(i) == '(')
        {
        caractere = exp.charAt(i);
        push(caractere);
        } 
        else if(exp.charAt(i) == '}' ||
        exp.charAt(i) == ']' ||
        exp.charAt(i) == ')')
        {
        if(pilhaEstaVazia())
        return false;
        //caractere = pop();
          caractere = (char) pop();
        if(caractere!=fecho(exp.charAt(i)) )
        return false;
        }
        }
        if(!pilhaEstaVazia()) return false;
        return true;
        
        
        }   



        
        

	
}