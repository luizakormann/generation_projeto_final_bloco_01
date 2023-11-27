package mercado_de_plantas.repository;

import mercado_de_plantas.model.Planta;

public interface PlantaRepository {

	// Implementação do CRUD
	public void cadastrar(Planta planta);

	public void listarTodas();

	public void buscarPlanta(int id);

	public void atualizar(Planta planta);

	public void deletar(int id);
}
