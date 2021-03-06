package algoritmo;

import java.util.ArrayList;

public class AlgoritmoSequenciaProva {

    /**
     * Implemente o m?todo que recebe um array de Inteiros de uma maneira que retorne uma String com os
     * n?meros organizados nas seguintes condi??es:
     * 
     * Condi??o 1:  "-"(h?fen)    Quando os n?meros forem sequenciais, deve-se mostrar o primeiro e o ?ltimo n?mero do per?odo apenas colocando um "-" no meio deles.
     * Condi??o 2:  ","(v?rgula)  Quando existir uma quebra na sequ?ncia dos n?meros, deve-se colocar "," e em seguida o n?mero que quebrou a sequ?ncia.
     * Condi??o 3:  " "(espa?o)   Voc? n?o precisa se preocupar em colocar o caractere espa?o " " entre os n?meros na formata??o da sua String.
     * <p>
     * Para melhor entendimento, veja alguns exemplos de entrada/sa?da do que se espera do algoritmo:
     * <p>
     * Exemplo 1 : Entrada : {1,2,3,4,5,6,7,8,9,10}
     * Sa?da   : "1-10" - OK
     * 
     * Exemplo 2 : Entrada : {1,2,3,4,6,7,8,9}
     * Sa?da   : "1-4,6-9" - OK
     * 
     * Exemplo 3 : Entrada : {1,2,3,4,5,8,10,11,12,13,14,15}
     * Sa?da   : "1-5,8,10-15" - OK
     * 
     * Exemplo 4 : Entrada : {1,2,3,5,7,10,11,12,13,20}
     * Sa?da   : "1-3,5,7,10-13,20" - OK
     * 
     * Exemplo 5 : Entrada : {1,3,5,6,9,10,11,12}
     * Sa?da   : "1,3,5-6,9-12" - OK
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