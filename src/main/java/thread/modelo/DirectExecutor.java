package thread.modelo;

import java.io.Serializable;
import java.util.concurrent.Executor;

public class DirectExecutor implements Executor, Serializable {
	private static final long serialVersionUID = -7014057448879138353L;
	
	@Override
	public void execute(Runnable r) {
		r.run();
	}
}