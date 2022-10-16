package edu.escuelaing.IETI.LearningGuardians.services;

import java.util.List;

import edu.escuelaing.IETI.LearningGuardians.dtos.UserDto;
import edu.escuelaing.IETI.LearningGuardians.entities.User;


public interface UserService {
    User create(User user);

    User findById(String id);

    List<User> getAll();

    boolean deleteById(String id);

    User update(User user, String userId);

    UserDto fromEntityToDto(User user);

    List<UserDto> fromEntityToDtos(List<User> user);

    User fromDtoToEntity(UserDto userDto);

    User findByEmail(String email); 
    
    
}