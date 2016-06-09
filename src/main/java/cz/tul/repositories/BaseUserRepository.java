package cz.tul.repositories;

import cz.tul.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BaseUserRepository extends CrudRepository<User, UUID> {

    List<User> findByName(String name);
}