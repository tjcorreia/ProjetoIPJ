package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
* @author Alberto Jorge
*
*/
public class Principal_PROJETO {
	public static void main(String[] args) {
		
		
		//begin_inputs
		Gestao jbGEST=new Gestao();
		
		J_10Login novoLogin = new J_10Login (jbGEST);

		Utilizador aprovado=new Utilizador();
//		do {
			
			novoLogin.open();
			aprovado=novoLogin.utilizadorAprovado();
			
//		} while (aprovado==null);
		
		System.out.println("passou ->>"+novoLogin.utilizadorAprovado().nome);
		jbGEST.Gerir(jbGEST,aprovado);
		
		//end_inputs

		
			
			
			
			
	
	}

}
