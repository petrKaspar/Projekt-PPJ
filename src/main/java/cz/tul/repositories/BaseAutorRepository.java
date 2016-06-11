package cz.tul.repositories;

/**
 * Created by Petr on 11.06.2016.
 */

import cz.tul.data.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Spring data JPA automaticky vytvoři úložiště implementace.
interface BaseAutorRepository rozšiřuje CrudRepository rozhraní,
 jehož parametry - Typ entity a ID, v tomto pripade Autor a Integer
BaseAutorRepository dědí několik metod pro práci s Autorem perzistenci,
 včetně metody pro ukládání, mazání a hledání v entite Autora.
*/
@Repository
public interface BaseAutorRepository extends CrudRepository<Autor, Long> {
       // List<Autor> findByID(int id);
       // List<Autor> findByName(String jmeno);
       List<Autor> findAll();
}

