package aleatoriedades.regex;

public class DivideParagrafos {
	
	public static void main(String[] args) {
		
		String texto = "Este é um paragrafo que termina com ponto final. \n"
		        + "Este é um paragrafo que termina com ponto de exclamação! \n"
		        + "Este é um paragrafo que termina com ponto de interrogação? \n"
		        + "Esta é uma linha que termina com vírgula, \n" + "Este é um paragrafo que termina com dois pontos: \n";
		
		// Exemplo 01:
		// Divide a string encontrando os parágrafos, que são delimitados pelas sequências: '. \n', ': \n', '! \n' e '? \n'
		// Na divisão, os pontos finais dos parágrafos são excluídos.
		
		String regex = "[.:!?]\\s\n";
		String[] textoSplitado = texto.split(regex);
		
		for (int i = 0; i < textoSplitado.length; i++) {
			System.out.print(("[ " + i + " = " + textoSplitado[i] + "]").replaceAll("[\n|\r]", ""));
			
			if (i != textoSplitado.length - 1) {
				System.out.println(",");
			}
		}
		System.out.println("\n");
		
		// Exemplo 02:
		// Divide a string encontrando os parágrafos, que são delimitados pelas sequências: '. \n', ': \n', '! \n' e '?
		// \n'
		// Na divisão, os pontos finais dos parágrafos não são excluídos.
		
		regex = "([.:!?])\\s\n";
		String textoReplaceado = texto.replaceAll(regex, "$1<pEnds>");
		textoSplitado = textoReplaceado.replaceAll("[\n|\r]", "").split("<pEnds>");
		
		for (int i = 0; i < textoSplitado.length; i++) {
			System.out.print(("[ " + i + " = " + textoSplitado[i] + "]"));
			
			if (i != textoSplitado.length - 1) {
				System.out.println(",");
			}
		}
		
	}
}
