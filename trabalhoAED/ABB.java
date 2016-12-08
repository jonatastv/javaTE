package trabalhoAED;



public class ABB {

	NoArvore abb_insere (NoArvore a, int v)
	{    
	    return abb_insere (a, null, v);
	}
	
	NoArvore abb_insere (NoArvore a, NoArvore pai, int v)
	{
	    if (a==null) {
	       a = new NoArvore(v, pai);
	    }
	    
	    else if (v < a.info)
	       a.esquerda = abb_insere(a.esquerda, a, v);
	    
	    else /* v >= a->info */
	       a.direita = abb_insere(a.direita, a, v);
	    
	    return a;
	}
	
	NoArvore abb_retira (NoArvore r, int v)
	{
		if (r == null)
			return null;
		
		else if (r.info > v)
			r.esquerda = abb_retira(r.esquerda, v);
		
		else if (r.info < v)
			r.direita = abb_retira(r.direita, v);
		
		else { 	/* achou o nó a remover */
			
			/* nó sem filhos */
			if (r.esquerda == null && r.direita == null) {
				//free (r);
				r = null;
			}
			
			/* nó só tem filho à direita */
			else if (r.esquerda == null) {
				NoArvore t = r;
				r.direita.pai = r.pai;
				r = r.direita;
				//free (t);
			}
			
			/* só tem filho à esquerda */
			else if (r.direita == null) {
				NoArvore t = r;
				r.esquerda.pai = r.pai;
				r = r.esquerda;
				//free (t);
			}
			
			/* nó tem os dois filhos */
			else {
				NoArvore f = r.esquerda;
				
				while (f.direita != null) {
					f = f.direita;
				}
				
				r.info = f.info; /* troca as informações */
				f.info = v;
				r.esquerda = abb_retira(r.esquerda,v);
			}
	    }
		
		return r;
    }


	
	public void abb_imprime (NoArvore a, String espaco)
	{
	   if (a != null) { // pré-fixa
	      abb_imprime(a.esquerda, espaco + "\t");
	      
		  System.out.println(espaco + a.info+"\n");
	      
	      abb_imprime(a.direita, espaco + "\t");
	   }
	}

	public NoArvore abb_busca (NoArvore r, int v)
	{
	    if (r == null)
	        return null;
	    
	    else if (v < r.info)
	        return abb_busca (r.esquerda, v);
	    
	    else if (v > r.info)
	        return abb_busca (r.direita, v);
	    
	    else return r;
	}

}
