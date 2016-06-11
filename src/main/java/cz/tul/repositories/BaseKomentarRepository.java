package cz.tul.repositories;

import cz.tul.data.Komentar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Petr on 11.06.2016.
 */
@Repository
public interface BaseKomentarRepository extends CrudRepository<Komentar, Integer> {
}
