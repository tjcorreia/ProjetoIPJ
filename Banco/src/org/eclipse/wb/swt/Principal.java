package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Principal {

	public static void main(String[] args) {
		
		
		//begin_inputs
		Gestao Machado=new Gestao();
		
		J_10Login novoLogin = new J_10Login (Machado);

		Utilizador aprovado=new Utilizador();
		do {
			
			novoLogin.open();
			aprovado=novoLogin.utilizadorAprovado();
		} while (aprovado==null);
		
		System.out.println("passou ->>"+novoLogin.utilizadorAprovado().nome);
		Machado.Gerir(Machado,aprovado);
		
		//end_inputs

		
			
			
			
			
	
	}

}
