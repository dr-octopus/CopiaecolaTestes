package aleatoriedades.regex;

public class DivideParagrafos {
	
	public static void main(String[] args) {
		
		String texto = "Este � um paragrafo que termina com ponto final. \n"
		        + "Este � um paragrafo que termina com ponto de exclama��o! \n"
		        + "Este � um paragrafo que termina com ponto de interroga��o? \n"
		        + "Esta � uma linha que termina com v�rgula, \n" + "Este � um paragrafo que termina com dois pontos: \n";
		
		// Exemplo 01:
		// Divide a string encontrando os par�grafos, que s�o delimitados pelas sequ�ncias: '. \n', ': \n', '! \n' e '? \n'
		// Na divis�o, os pontos finais dos par�grafos s�o exclu�dos.
		
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
		// Divide a string encontrando os par�grafos, que s�o delimitados pelas sequ�ncias: '. \n', ': \n', '! \n' e '?
		// \n'
		// Na divis�o, os pontos finais dos par�grafos n�o s�o exclu�dos.
		
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
