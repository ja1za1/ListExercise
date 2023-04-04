package curso.list.exercicio.gui;

import javax.swing.JOptionPane;

import curso.list.exercicio.Funcionario;
import curso.list.exercicio.ListaFuncionario;

import static curso.list.exercicio.gui.JanelasPrograma.*;

public class Programa {
	
	private static final int CADASTRAR = 0,
					   		 EXCLUIR = 1,
					   		 AUMENTAR_SALARIO = 2,
					   		 LISTAR = 3;
	
	private static final String TITULO_CADASTRO_FUNCIONARIO = "Cadastro de funcionário",
								TITULO_LISTAR_FUNCIONARIOS = "Lista de funcionários";
	
	private static ListaFuncionario funcionarios;
	
	private Programa() {
		iniciarPrograma();
	}

	private void iniciarPrograma() {
		int opcao;
		final String ESCOLHA_OPCAO = "Escolha uma opção";
		final String TITULO = "Controle de Funcionários";
		final String OPCOES[] = {"Cadastrar Funcionário", "Excluir Funcionário", "Aumentar Salário", "Listar Funcionários"};
		funcionarios = new ListaFuncionario();
		do {
			opcao = exibirMenuOpcoes(ESCOLHA_OPCAO, TITULO, OPCOES);
			switch (opcao) {
			
			case CADASTRAR:
				cadastrarFuncionario();
				break;
			
			case EXCLUIR:
				excluirFuncionario();
				break;
			
			case AUMENTAR_SALARIO:
				aumentarSalarioFuncionario();
				break;
				
			case LISTAR:
				listarFuncionarios();
				break;
			}
		}while(opcao != JOptionPane.CLOSED_OPTION);
	}

	private void listarFuncionarios() {
		if(funcionarios.obterTamanho() > 0) {
			exibirMensagem(funcionarios.listarFuncionarios(), TITULO_CADASTRO_FUNCIONARIO);
		}
		else {
			final String NAO_HA_FUNCIONARIOS = "Não há funcionários cadastrados";
			exibirMensagemErro(NAO_HA_FUNCIONARIOS,TITULO_LISTAR_FUNCIONARIOS);
		}
		
	}

	private void aumentarSalarioFuncionario() {
		// TODO Auto-generated method stub
		
	}

	private void excluirFuncionario() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarFuncionario() {
		final String DIGITE_QUANTIDADE_FUNCIONARIOS = "Digite a quantidade de funcionários que deseja cadastrar";
		int quantidadeFuncionariosCadastrar;
		quantidadeFuncionariosCadastrar = obterQuantidadeFuncionariosCadastrar(DIGITE_QUANTIDADE_FUNCIONARIOS, TITULO_CADASTRO_FUNCIONARIO);
		if(quantidadeFuncionariosCadastrar <= 0) {
			final String QUANTIDADE_INVALIDA = "Quantidade inserida inválida.\nPor favor insira uma quantidade válida";
			exibirMensagemErro(QUANTIDADE_INVALIDA, TITULO_CADASTRO_FUNCIONARIO);
		}
		else {
			for(int i = 0; i < quantidadeFuncionariosCadastrar; i++) {
				cadastroFuncionario();
			}
		}
	}

	private void cadastroFuncionario() {
		final String DIGITE_ID_FUNCIONARIO = "Digite o ID do funcionário",
					 DIGITE_NOME_FUNCIONARIO = "Digite o nome do funcionário",
					 DIGITE_SALARIO_FUNCIONARIO = "Digite o salário do funcionário";
		
		Funcionario funcionario = new Funcionario();
		
		int idFuncionario;
		float salarioFuncionario;
		String nomeFuncionario;
		
		do {
			nomeFuncionario = obterNomeFuncionario(DIGITE_NOME_FUNCIONARIO, TITULO_CADASTRO_FUNCIONARIO);
			if(nomeFuncionario.contentEquals("") || nomeFuncionario == null) {
				final String NOME_INSERIDO_INVALIDO = "Nome inserido é inválido.\nPor favor digite um nome válido";
				exibirMensagemErro(NOME_INSERIDO_INVALIDO, TITULO_CADASTRO_FUNCIONARIO);
			}
		}while(nomeFuncionario.contentEquals("") || nomeFuncionario == null);
		
		funcionario.setNome(nomeFuncionario);
	
		do {
			idFuncionario = obterIdFuncionario(DIGITE_ID_FUNCIONARIO, TITULO_CADASTRO_FUNCIONARIO);
			if(idFuncionario <= 0) {
				final String ID_INSERIDO_INVALIDO = "ID inserido é inválido.\nPor favor digite um ID válido";
				exibirMensagemErro(ID_INSERIDO_INVALIDO, TITULO_CADASTRO_FUNCIONARIO);
			}
		}while(idFuncionario <= 0);
		
		funcionario.setId(idFuncionario);
		
		do {
			salarioFuncionario = obterSalarioFuncionario(DIGITE_SALARIO_FUNCIONARIO, TITULO_CADASTRO_FUNCIONARIO);
			if(salarioFuncionario <= 0) {
				final String SALARIO_INSERIDO_INVALIDO = "Salário inserido é inválido.\nPor favor digite um salário válido";
				exibirMensagemErro(SALARIO_INSERIDO_INVALIDO, TITULO_CADASTRO_FUNCIONARIO);
			}
		}while(salarioFuncionario <= 0);
		
		funcionario.setSalario(salarioFuncionario);
		
		funcionarios.adicionarFuncionario(funcionario);
		
		final String FUNCIONARIO_CADASTRADO_SUCESSO = "Funcionário cadastrado com sucesso.";
		
		exibirMensagem(FUNCIONARIO_CADASTRADO_SUCESSO, TITULO_CADASTRO_FUNCIONARIO);
	}

	private int exibirMenuOpcoes(String mensagem, String titulo, Object opcoes[]) {
		return exibirOpcoes(mensagem, titulo, opcoes);
	}
	
	private int obterQuantidadeFuncionariosCadastrar(String mensagem, String titulo) {
		int quantidadeFuncionarios;
		try {
			quantidadeFuncionarios = exibirEntradaDadosInt(mensagem, titulo);
		}catch (Exception e) {
			quantidadeFuncionarios = 0;
		}
		return quantidadeFuncionarios;
	}
	
	private String obterNomeFuncionario(String mensagem, String titulo) {
		return exibirEntradaDadosString(mensagem, titulo);
	}
	
	private int obterIdFuncionario(String mensagem, String titulo) {
		int idFuncionario;
		try {
			idFuncionario = exibirEntradaDadosInt(mensagem, titulo);
		} catch (Exception e) {
			idFuncionario = 0;
		}
		return idFuncionario;
	}
	
	private float obterSalarioFuncionario(String mensagem, String titulo) {
		float salarioFuncionario;
		try {
			salarioFuncionario = exibirEntradaDadosFloat(mensagem, titulo);
		} catch (Exception e) {
			salarioFuncionario = 0f;
		}
		return salarioFuncionario;
	}
	
	public static void main(String[] args) {
		new Programa();
		System.exit(0);
	}
}
