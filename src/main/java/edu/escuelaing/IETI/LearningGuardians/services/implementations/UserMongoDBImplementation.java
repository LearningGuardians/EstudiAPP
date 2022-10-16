package edu.escuelaing.IETI.LearningGuardians.services.implementations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import edu.escuelaing.IETI.LearningGuardians.dtos.UserDto;
import edu.escuelaing.IETI.LearningGuardians.entities.User;
import edu.escuelaing.IETI.LearningGuardians.repositories.UserRepository;
import edu.escuelaing.IETI.LearningGuardians.services.UserService;

@Service
public class UserMongoDBImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    
    @Override
    public User create(User user) {
        if (user.getId() == ""){
            Random r = new Random();
            user.setId(String.valueOf(r.nextInt(1000)));
        }
        return user;
    }

    @Override
    public User findById(String id) {
        if (userRepository.existsById(id)){
            User user = userRepository.findById(id).get();
            return user;
        }else{return null;}
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
    
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);}
        return !userRepository.existsById(id);
    }

    @Override
    public User update(User user, String userId) {
        if(userRepository.existsById(userId)){
            User oldUser = findById(userId);
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setCreatedAt(user.getCreatedAt());
            return userRepository.save(oldUser);
        }return null;
    }

    @Override
    public UserDto fromEntityToDto(User user) {
        UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail(),
             user.getCreatedAt());
        return userDto;
    }

    @Override
    public List<UserDto> fromEntityToDtos(List<User> user) {
        return user.stream().map(x -> fromEntityToDto(x)).collect(Collectors.toList());
    }

    @Override
    public User fromDtoToEntity(UserDto userDto) {
        User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail(),
                userDto.getCreatedAt());
        return user;
    }

    @Override
    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
