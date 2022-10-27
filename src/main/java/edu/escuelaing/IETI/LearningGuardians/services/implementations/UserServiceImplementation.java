package edu.escuelaing.IETI.LearningGuardians.services.implementations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.IETI.LearningGuardians.dtos.users.UserDto;
import edu.escuelaing.IETI.LearningGuardians.entities.users.User;
import edu.escuelaing.IETI.LearningGuardians.repositories.UserRepository;
import edu.escuelaing.IETI.LearningGuardians.services.UserService;

import java.util.Date;
import java.util.List;


@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        if(findById(id) == null){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User update(UserDto user, String userId) {
        User userUpdate = findById(userId);
        userUpdate.update(user);
        return userRepository.save(userUpdate);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return userRepository.findByNameLikeOrLastNameLike(queryText, queryText);
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findByCreatedAtAfter( startDate);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}