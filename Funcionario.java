package curso.list.exercicio;

public class Funcionario {
	
	public Funcionario() {
		this.id = 0;
		this.nome = "";
		this.salario = 0.0f;
	}
	
	public Funcionario(int id, String nome, float salario) {
		this();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	public Funcionario(int id, String nome) {
		this();
		this.id = id;
		this.nome = nome;
	}
	
	public Funcionario(String nome) {
		this();
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public void aumentarSalario(float porcentagemAumento) {
		setSalario(salario/porcentagemAumento+salario);
	}
	
	private int id;
	private String nome;
	private float salario;
}
