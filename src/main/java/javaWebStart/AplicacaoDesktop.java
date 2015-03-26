package javaWebStart;

import javax.swing.JOptionPane;

/**
 * Java Web Start é uma tecnologia que possibilita oferecer uma aplicação java para o cliente, com a certeza que o .jar
 * sempre executará na última versão, ou seja, sempre estará atualizado, pois, a cada execução, comunica-se com o
 * servidor para verificar se há atualizações. <br>
 * Mostrou-se uma tecnologia inviável para utilizar com os usuários do Copia e Cola, pois possui muitas validações de
 * segurança e é geralmente bloqueado pelo sistema operacional e pelo próprio java.<br>
 * Passos:<br>
 * <ul>
 * <li>Ao realizar downlaod, Browser avisa que o arquivo pode danificar o computador;</li>
 * <li>SO bloqueia a aplicação por ser originada da internet;</li>
 * <li>Java bloqueia o .jnlp por ser de um servidor desconhecido (precisa adicionar exceção nas configurações do Java);</li>
 * <li>Java bloqueia o .jar por não estar assinado e/ou com certificação válida;</li>
 * <li>Java requisita permissão do usuário para executar a aplicação.</li>
 * </ul>
 * 
 * @author Luiz Felipe Nazari
 */
public class AplicacaoDesktop {
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Qualquer coisa!");
	}
	
}
