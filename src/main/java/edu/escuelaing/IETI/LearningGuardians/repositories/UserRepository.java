package edu.escuelaing.IETI.LearningGuardians.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.IETI.LearningGuardians.entities.users.User;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameLikeOrLastNameLike(String queryText, String sQueryText);

    List<User> findByCreatedAtAfter(Date startDate);

    User findByEmail(String email);
}
