package mercado_de_plantas.controller;

import java.util.ArrayList;
import java.util.Optional;

import mercado_de_plantas.model.Planta;
import mercado_de_plantas.repository.PlantaRepository;

public class PlantaController implements PlantaRepository {

	// Criar collection
	private ArrayList<Planta> listaPlantas = new ArrayList<Planta>();

	// variável para gerar os IDs
	int id = 0;

	@Override
	public void cadastrar(Planta planta) {
		listaPlantas.add(planta);
		System.out.println("A planta " + planta.getNome() + " foi cadastrada com sucesso!");

	}

	@Override
	public void listarTodas() {
		for (var planta : listaPlantas) {
			planta.visualizar();
		}

	}

	@Override
	public void buscarPlanta(int id) {
		Optional<Planta> plantas = buscarNaCollection(id);
		if (plantas.isPresent()) {
			plantas.get().visualizar();
		} else
			System.out.println("Nenhuma planta com id " + id + "foi localizada.");

	}

	@Override
	public void atualizar(Planta planta) {
		Optional<Planta> buscaPlanta = buscarNaCollection(planta.getId());

		if (buscaPlanta.isPresent()) {
			listaPlantas.set(listaPlantas.indexOf(buscaPlanta.get()), planta);
			System.out.println("A planta " + planta.getNome() + "foi atualizada com sucesso!");
		} else
			System.out.println("Nenhuma planta com id " + id + "foi localizada.");

	}

	@Override
	public void deletar(int id) {
		Optional<Planta> plantas = buscarNaCollection(id);

		if (plantas.isPresent()) {
			listaPlantas.remove(plantas.get());
			System.out.println("A planta com id " + id + "foi removida com sucesso!");
		}

	}

	// métodos auxiliares

	public int gerarId() {
		return ++id;
	}

	public Optional<Planta> buscarNaCollection(int id) {

		for (var planta : listaPlantas) {
			if (planta.getId() == id) {
				return Optional.of(planta);
			}
		}
		return Optional.empty();
	}

}
