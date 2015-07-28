package thread.modelo;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor, Serializable {
	private static final long serialVersionUID = -6494274069960667662L;
	
	final private Queue<Runnable> tasks = new ArrayDeque<Runnable>();
	
	final private Executor executor;
	
	private Runnable active;
	
	public SerialExecutor(Executor executor) {
		this.executor = executor;
	}
	
	@Override
	public synchronized void execute(final Runnable r) {
		tasks.offer(new Runnable() {
			@Override
			public void run() {
				try {
					r.run();
				} finally {
					scheduleNext();
				}
			}
		});
		if (active == null) {
			scheduleNext();
		}
	}
	
	protected synchronized void scheduleNext() {
		if ((active = tasks.poll()) != null) {
			executor.execute(active);
		}
	}
	
}