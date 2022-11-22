package bddweb.projet.services;

import bddweb.projet.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
  {
    "id": 100000,
    "prenom": "Aurelien",
    "nom": "Pietrzak",
    "dateNaissance": "2022-11-28T18:46:19UTC",
    "telephone": "0646214525",
    "adressePostale": "75 rue de Paris",
    "dateCreation": "2022-11-28T18:46:19UTC"
  }
 */
@Service
public class CLientService {
    @Autowired
    private ClientsRepository clientRepository;

    public List<GetTodosResponse> getAllTodos(Long idAuteur) {
        return this.todoRepository
                .findByAuteurId(idAuteur)
                .stream()
                .map(this::buildGetTodosResponse)
                .collect(Collectors.toList());
    }


}
