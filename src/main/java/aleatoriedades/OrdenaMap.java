package aleatoriedades;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class OrdenaMap {
	
	public static void imprimeMap(String msg, Map<?, String> mapa) {
		System.out.println("\n" + msg);
		for (Entry<?, String> m : mapa.entrySet()) {
			System.out.println(m.getKey() + " | " + m.getValue());
		}
	}
	
	public static void TesteHashMap() {
		Map<String, String> mapaString = new HashMap<>();
		mapaString.put("1", "Um");
		mapaString.put("2", "Dois");
		mapaString.put("10", "Dez");
		mapaString.put("100", "Cem");
		imprimeMap("Mapeamento com Key String", mapaString);
		
		mapaString.clear();
		mapaString.put("1 1", "Um Um");
		mapaString.put("1 2", "Um Dois");
		mapaString.put("1 10", "Um Dez");
		mapaString.put("2 1", "Dois Um");
		imprimeMap("Mapeamento com Key String", mapaString);
		
		Map<Integer, String> mapaInteger = new HashMap<>();
		mapaInteger.put(1, "Um");
		mapaInteger.put(2, "Dois");
		mapaInteger.put(10, "Dez");
		mapaInteger.put(100, "Cem");
		imprimeMap("Mapeamento com Key Integer", mapaInteger);
		
		Map<List<Integer>, String> mapaListInteger = new HashMap<>();
		mapaListInteger.put(Arrays.asList(1, 2), "Um");
		mapaListInteger.put(Arrays.asList(1, 2), "Dois");
		mapaListInteger.put(Arrays.asList(1, 2), "Dez");
		mapaListInteger.put(Arrays.asList(1, 2), "Cem");
		imprimeMap("Mapeamento com Key List de Integer", mapaListInteger);
	}
	
	public static void TesteTreeMap() {
		Map<String, String> mapaString = new TreeMap<>();
		mapaString.put("1", "Um");
		mapaString.put("2", "Dois");
		mapaString.put("10", "Dez");
		mapaString.put("100", "Cem");
		imprimeMap("Mapeamento com Key String", mapaString);
		
		mapaString.clear();
		mapaString.put("1 1", "Um Um");
		mapaString.put("1 2", "Um Dois");
		mapaString.put("1 10", "Um Dez");
		mapaString.put("2 1", "Dois Um");
		imprimeMap("Mapeamento com Key String", mapaString);
		
		Map<Integer, String> mapaInteger = new TreeMap<>();
		mapaInteger.put(1, "Um");
		mapaInteger.put(2, "Dois");
		mapaInteger.put(10, "Dez");
		mapaInteger.put(100, "Cem");
		imprimeMap("Mapeamento com Key Integer", mapaInteger);
		
//		Map<List<Integer>, String> mapaListInteger = new TreeMap<>();
//		mapaListInteger.put(Arrays.asList(1, 2), "Um");
//		mapaListInteger.put(Arrays.asList(1, 2), "Dois");
//		mapaListInteger.put(Arrays.asList(1, 2), "Dez");
//		mapaListInteger.put(Arrays.asList(1, 2), "Cem");
//		imprimeMap("Mapeamento com Key List de Integer", mapaListInteger);
	}
	
	public static void TesteLinkedHashMap() {
		Map<String, String> mapaString = new LinkedHashMap<>();
		mapaString.put("1", "Um");
		mapaString.put("2", "Dois");
		mapaString.put("10", "Dez");
		mapaString.put("100", "Cem");
		imprimeMap("Mapeamento com Key String", mapaString);
		
		mapaString.clear();
		mapaString.put("1 1", "Um Um");
		mapaString.put("1 2", "Um Dois");
		mapaString.put("1 10", "Um Dez");
		mapaString.put("2 1", "Dois Um");
		imprimeMap("Mapeamento com Key String", mapaString);
		
		Map<Integer, String> mapaInteger = new LinkedHashMap<>();
		mapaInteger.put(1, "Um");
		mapaInteger.put(2, "Dois");
		mapaInteger.put(10, "Dez");
		mapaInteger.put(100, "Cem");
		imprimeMap("Mapeamento com Key Integer", mapaInteger);
		
		Map<List<Integer>, String> mapaListInteger = new LinkedHashMap<>();
		mapaListInteger.put(Arrays.asList(1, 2), "Um");
		mapaListInteger.put(Arrays.asList(1, 2), "Dois");
		mapaListInteger.put(Arrays.asList(1, 2), "Dez");
		mapaListInteger.put(Arrays.asList(1, 2), "Cem");
		imprimeMap("Mapeamento com Key List de Integer", mapaListInteger);
	}
	
	public static void main(String[] args) {
//		TesteHashMap(); // Ordem aleatória
//		TesteTreeMap(); // Ordenado crescentemente 
		TesteLinkedHashMap(); // Ordem de incerção
	}
	
}
