package thread.modelo;

/**
 * Thread simples que apenas escreve mensagens no console com um intervalo de 1 segundo.
 */
public class ThreadBonita extends Thread {
	
	private String nome;
	
	public ThreadBonita(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void run() {
		System.out.println("[ " + nome + " ] Iniciando Thread.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[ " + nome + " ] Finalizando Thread.");
	}
	
}
