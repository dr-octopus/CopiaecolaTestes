package thread.modelo;

import java.util.concurrent.Executor;

public class AdicionaFilaThread implements Runnable {
	
	private Executor executor;
	
	private ThreadBonita threadBonita;
	
	public AdicionaFilaThread(Executor executor, ThreadBonita threadBonita) {
		this.executor = executor;
		this.threadBonita = threadBonita;
	}
	
	@Override
	public void run() {
		executor.execute(threadBonita);
	}
	
}
