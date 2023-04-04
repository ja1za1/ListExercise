package curso.list.exercicio;

import java.util.ArrayList;
import java.util.List;


public class ListaFuncionario {
	
	public ListaFuncionario() {
		listaFuncionarios = new ArrayList<>();
	}
	
	public ListaFuncionario(int capacidadeInicial) {
		listaFuncionarios = new ArrayList<>(capacidadeInicial);
	}
	
	public List<Funcionario> getListaFuncionario() {
		return new ArrayList<>(listaFuncionarios);
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
	}
	
	public Funcionario obterFuncionario(int indiceFuncionario) {
		return listaFuncionarios.get(indiceFuncionario);
	}
	
	public int obterIndiceFuncionario(Funcionario funcionario) {
		return listaFuncionarios.indexOf(funcionario);
	}
	
	public int obterIndiceFuncionario(String nomeFuncionario) {
		return obterIndiceFuncionario(listaFuncionarios.stream().filter(x -> x.getNome().equalsIgnoreCase(nomeFuncionario)).findFirst().orElse(null));
	}
	
	public int obterIndiceFuncionario(int idFuncionario) {
		return obterIndiceFuncionario(listaFuncionarios.stream().filter(x -> x.getId() == idFuncionario).findFirst().orElse(null));
	}
	
	public int obterTamanho() {
		return listaFuncionarios.size();
	}
	
	public String listarFuncionarios() {
		int tamanhoLista = obterTamanho();
		if(tamanhoLista > 0) {
			StringBuilder informacoesFuncionarios = new StringBuilder();
			for(int i = 0; i < tamanhoLista; i++) {
				informacoesFuncionarios.append(String.format("Funcionário #%d\n", i+1));
				informacoesFuncionarios.append(String.format("ID = %d\n", obterFuncionario(i).getId()));
				informacoesFuncionarios.append(String.format("Nome = %s\n", obterFuncionario(i).getNome()));
				informacoesFuncionarios.append(String.format("Salário = R$%.2f\n\n", obterFuncionario(i).getSalario()));
			}
			return informacoesFuncionarios.toString();
		}
		return "Não há funcionários cadastrados";
	}
	
	private List<Funcionario> listaFuncionarios;
}
