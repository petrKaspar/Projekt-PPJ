package cz.tul.repositories;

import cz.tul.data.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BaseBillRepository extends CrudRepository<Bill, UUID> {

}
