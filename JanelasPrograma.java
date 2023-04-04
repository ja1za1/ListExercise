package curso.list.exercicio.gui;

import javax.swing.JOptionPane;

public class JanelasPrograma {
	
	public static int exibirOpcoes(String mensagem, String titulo, Object opcoes[]) {
		return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	public static String exibirEntradaDadosString(String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	
	public static int exibirEntradaDadosInt(String mensagem, String titulo) throws NumberFormatException {
		int dadoDigitado;
		try {
			dadoDigitado = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE));
		} catch (Exception e) {
			throw e;
		}
		return dadoDigitado;
	}
	
	public static float exibirEntradaDadosFloat(String mensagem, String titulo) throws NumberFormatException {
		float dadoDigitado;
		try {
			dadoDigitado = Float.parseFloat(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE));
		} catch (Exception e) {
			throw e;
		}
		return dadoDigitado;
	}
	
	public static void exibirMensagemErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void exibirMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

}
