package javafx.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class IndexMB {
	
	public void index() {
		System.out.println("Passou no índex!");
	}
	
}
