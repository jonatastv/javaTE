package trabalhoAED;



public class NoArvore {
	int info;
	NoArvore direita;
	NoArvore esquerda;
	NoArvore pai;

	public NoArvore(int info, NoArvore pai) {
		this.info = info;
		this.direita = null;
		this.esquerda = null;
		this.pai = pai;
	}
}
