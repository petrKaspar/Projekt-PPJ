package cz.tul.repositories;

import cz.tul.data.Komentar;
import cz.tul.data.Obrazek;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Petr on 12.06.2016.
 */
@Repository
public interface BaseObrazekRepository extends CrudRepository<Obrazek, Integer> {
}