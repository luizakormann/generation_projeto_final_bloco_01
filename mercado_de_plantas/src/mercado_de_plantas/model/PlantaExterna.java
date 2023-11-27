package mercado_de_plantas.model;

public class PlantaExterna extends Planta {

	private int frutahort;

	public PlantaExterna(int id, String nome, int tipo, float preco, int frutahort) {
		super(id, nome, tipo, preco);
		this.frutahort = frutahort;
	}

	public int getFrutahort() {
		return frutahort;
	}

	public void setFrutahort(int frutahort) {
		this.frutahort = frutahort;
	}

	public void visualizar() {
		super.visualizar();
		String tipoimp = "";

		switch (this.frutahort) {
		case 1 -> tipoimp = "Frutíferas";
		case 2 -> tipoimp = "Hortaliças";
		}
		System.out.println("Essa planta externa é da categoria: " + tipoimp);
	}
}
