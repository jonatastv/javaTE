package tes;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		
		ArrayList<Telefone> at = new ArrayList<Telefone>();
		
		Pessoa p = new Pessoa();
		Telefone t;
		p.setNome("teste");
		
		for (int i = 0; i <= 4; i++) {
			t = new Telefone();
			t.setNum(i+1);
			at.add(t);
		}
		
		p.setFone(at);
		
		
		System.out.println("Nome: "+p.getNome());
		System.out.println("Fones:");
		
		at= p.getFone();
		
		for (int i = 0; i < at.size(); i++) {
			
			System.out.println(at.get(i).getNum());
			
		}
		
		
		
	}

}
