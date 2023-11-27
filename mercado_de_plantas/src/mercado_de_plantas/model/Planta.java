package mercado_de_plantas.model;

public abstract class Planta {

	private int id;
	private String nome;
	private int tipo;
	private float preco;

	public Planta(int id, String nome, int tipo, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void visualizar() {
		String tipoimp = "";

		switch (this.tipo) {
		case 1 -> tipoimp = "Externa";
		case 2 -> tipoimp = "Interna";
		}

		System.out.println("\n\n❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁");
		System.out.println("           Dados da planta        ");
		System.out.println("❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁ ❀ ✿ ❁");
		System.out.println(" ID da planta: " + this.id);
		System.out.println(" Nome da planta: " + this.nome);
		System.out.println(" Tipo da planta: " + tipoimp);
		System.out.printf(" Preço de venda da planta: R$%.2f\n", this.preco);
	}

}
