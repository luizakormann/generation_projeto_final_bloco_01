package mercado_de_plantas.model;

public class PlantaInterna extends Planta {

	private int florsamamb;

	public PlantaInterna(int id, String nome, int tipo, float preco, int florsamamb) {
		super(id, nome, tipo, preco);
		this.florsamamb = florsamamb;
	}

	public int getFlorsamamb() {
		return florsamamb;
	}

	public void setFlorsamamb(int florsamamb) {
		this.florsamamb = florsamamb;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		String tipoimp = "";

		switch (this.florsamamb) {
		case 1 -> tipoimp = "Flores";
		case 2 -> tipoimp = "Samambaias";
		}
		System.out.println("Essa planta interna é da categoria: " + tipoimp);
	}

}
