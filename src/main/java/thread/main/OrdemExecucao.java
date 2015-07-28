package thread.main;

import java.util.concurrent.Executor;

import thread.modelo.DirectExecutor;
import thread.modelo.SerialExecutor;
import thread.modelo.ThreadBonita;

public class OrdemExecucao {
	
	public static void executaAleatoriamente() {
		System.out.println("\nExecutando aleatoriamente:");
		Thread t1 = new ThreadBonita("Um");
		Thread t2 = new ThreadBonita("Dois");
		Thread t3 = new ThreadBonita("Três");
		Thread t4 = new ThreadBonita("Quatro");
		Thread t5 = new ThreadBonita("Cinco");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	public static void executaSequencialmente() {
		System.out.println("\nExecutando sequencialmente:");
		DirectExecutor direct = new DirectExecutor();
		Executor executor = new SerialExecutor(direct);
		executor.execute(new ThreadBonita("Um"));
		executor.execute(new ThreadBonita("Dois"));
		executor.execute(new ThreadBonita("Três"));
		executor.execute(new ThreadBonita("Quatro"));
		executor.execute(new ThreadBonita("Cinco"));
	}
	
	public static void main(String[] args) {
		executaSequencialmente();
		executaAleatoriamente();
	}
	
}
