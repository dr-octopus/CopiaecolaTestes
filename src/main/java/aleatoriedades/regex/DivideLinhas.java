package aleatoriedades.regex;

import java.util.regex.Pattern;

public class DivideLinhas {
	
	static String s1 = "123456789,\n123456789.\n123456789:\n123456789;\n123456789!\n123456789?\n";
	
	public static void main(String[] args) {}
	
	public static String[] removeLinhasPequenas(String str) {
		// Remove as linhas menores que 50 caracteres (títulos) e que nÃ£o sejam finais de parágrafos.
		StringBuilder sBuilder = new StringBuilder();
		Pattern p = Pattern.compile("^.*[.:;!?]\\s*$");
		for (String s : str.split("[\n|\r]")) {
			if (s.length() < 50 && !p.matcher(s).matches()) {
				continue;
			}
			
			sBuilder.append(s + "\n");
		}
		str = sBuilder.toString();
		
		// Separa o texto em parágrafos
		String regex = "([.:;!?])\\s*\n";
		String textoTag = str.replaceAll(regex, "$1<pEnds>");
		String[] paragrafos = textoTag.replaceAll("[\n|\r]", "").split("<pEnds>");
		
		return paragrafos;
	}
}
