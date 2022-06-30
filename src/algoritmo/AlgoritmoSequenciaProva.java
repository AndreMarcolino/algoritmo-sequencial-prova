package algoritmo;

import java.util.ArrayList;

public class AlgoritmoSequenciaProva {

    /**
     * Implemente o método que recebe um array de Inteiros de uma maneira que retorne uma String com os
     * números organizados nas seguintes condições:
     * 
     * Condição 1:  "-"(hífen)    Quando os números forem sequenciais, deve-se mostrar o primeiro e o último número do período apenas colocando um "-" no meio deles.
     * Condição 2:  ","(vírgula)  Quando existir uma quebra na sequência dos números, deve-se colocar "," e em seguida o número que quebrou a sequência.
     * Condição 3:  " "(espaço)   Você não precisa se preocupar em colocar o caractere espaço " " entre os números na formatação da sua String.
     * <p>
     * Para melhor entendimento, veja alguns exemplos de entrada/saída do que se espera do algoritmo:
     * <p>
     * Exemplo 1 : Entrada : {1,2,3,4,5,6,7,8,9,10}
     * Saída   : "1-10" - OK
     * 
     * Exemplo 2 : Entrada : {1,2,3,4,6,7,8,9}
     * Saída   : "1-4,6-9" - OK
     * 
     * Exemplo 3 : Entrada : {1,2,3,4,5,8,10,11,12,13,14,15}
     * Saída   : "1-5,8,10-15" - OK
     * 
     * Exemplo 4 : Entrada : {1,2,3,5,7,10,11,12,13,20}
     * Saída   : "1-3,5,7,10-13,20" - OK
     * 
     * Exemplo 5 : Entrada : {1,3,5,6,9,10,11,12}
     * Saída   : "1,3,5-6,9-12" - OK
     */

	public static String obterSequenciaFormatada(int[] n) {
		String sequenciaFormatada = "";
		ArrayList<Integer> numerosSaida = new ArrayList<Integer>();

		for (int i = 0; i < n.length; i++) {
			if (i == 0) {
				sequenciaFormatada = String.valueOf(n[i]);
				numerosSaida.add(n[i]);
			} else {
				if ((n[i] - 1) == numerosSaida.get(numerosSaida.size() - 1)) {
					if (i == n.length - 1) {
						if ((n[i] - 1) == numerosSaida.get(numerosSaida.size() - 1)) {
							sequenciaFormatada += "-" + n[i];
						} else {
							sequenciaFormatada += "," + n[i];
						}
					}

					numerosSaida.add(n[i]);
				} else {
					if (numerosSaida.size() > 1)
						if ((numerosSaida.get(numerosSaida.size() - 1) - 1) == numerosSaida
								.get(numerosSaida.size() - 2))
							sequenciaFormatada += "-" + numerosSaida.get(numerosSaida.size() - 1);
					sequenciaFormatada += "," + n[i];
					numerosSaida.add(n[i]);
				}
			}
		}

		return sequenciaFormatada;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 8, 10, 11, 12, 13, 14, 15 };

		String saida = obterSequenciaFormatada(array);

		System.out.println(saida);
	}
}