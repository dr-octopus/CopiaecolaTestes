package thread.main;

import java.util.Timer;
import java.util.TimerTask;

import thread.modelo.TaskBonita;

public class MainTimer {
	
	/**
	 * Executa a task (que leva +-1 segundo) e dorme por 2 segundos, então repete o ciclo indefinidamente. <br>
	 * Caso o tempo de espera entre a execução de duas tasks for menor do que o tempo de execução de uma task, a
	 * seguinte será executada imediatamente após o término da atual.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TimerTask task = new TaskBonita("Bu");
		
		Timer t = new Timer();
		t.schedule(task, 0L, 3000L);
	}
}
