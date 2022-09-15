package edu.escuelaing.IETI.LearningGuardians.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.IETI.LearningGuardians.entities.User;


public interface UserRepository extends MongoRepository<User, String>{

}