package edu.escuelaing.IETI.LearningGuardians.services;


import java.util.Date;
import java.util.List;

import edu.escuelaing.IETI.LearningGuardians.dtos.users.UserDto;
import edu.escuelaing.IETI.LearningGuardians.entities.users.User;


public interface UserService {
    User create( User user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById(String id);

    User update(UserDto user, String userId);

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);

    User findByEmail(String email);
}
