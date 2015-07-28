package thread.modelo;

import java.util.TimerTask;

/**
 * TimerTask simples que apenas escreve mensagens no console com um intervalo de 1 segundo.
 */
public class TaskBonita extends TimerTask {
	
	private String nome;
	
	public TaskBonita(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void run() {
		System.out.println("[ " + nome + " ] Iniciando Task.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[ " + nome + " ] Finalizando Task.");
	}
	
}
