package com.classes_pet.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.classes_pet.repository.PetRepository;
import com.classes_pet.entities.Endereco;

@Service
public class EnderecoService {

	private final PetRepository petRepository;
	
	
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public Endereco savePet (Endereco endereco) {
		return petRepository.save(endereco);
	}
	
	public Endereco getPetById(Long id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public List<Endereco> getAllPet(){
		return enderecoRepository.findAll();
	}
	
	public Endereco alteraPet (Long id, Endereco alteraPet) {
		Optional<Endereco> existePet = enderecoRepository.findById(id);
		if (existePet.isPresent()) {
			alteraPet.setId(id);
			return petRepository.save(alteraPet);
		}else {
			return null;
		}
}
	
	public boolean deletePet (Long id) {
		Optional<Endereco> existePet = petRepository.findById(id);
		if (existePet.isPresent()) {
			petRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}