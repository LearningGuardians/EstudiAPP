package edu.escuelaing.IETI.LearningGuardians.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.IETI.LearningGuardians.dtos.users.UserDto;
import edu.escuelaing.IETI.LearningGuardians.entities.enumerations.RoleEnum;
import edu.escuelaing.IETI.LearningGuardians.entities.users.User;
import edu.escuelaing.IETI.LearningGuardians.services.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userService.getAll();
        List<UserDto> usersDto = new ArrayList<>();
        for(User user : users){
            UserDto userDto = modelMapper.map(user, UserDto.class);
            usersDto.add(userDto);
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        try{
            User user = userService.findById(id);
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping( "/like/{pattern}" )
    public ResponseEntity<List<UserDto>> findUsersWithNameOrLastNameLike( @PathVariable String pattern ) {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userService.findUsersWithNameOrLastNameLike(pattern);
        List<UserDto> usersDto = new ArrayList<>();
        for(User user : users){
            UserDto userDto = modelMapper.map(user, UserDto.class);
            usersDto.add(userDto);
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping( "/createdAfter/{date}")
    public ResponseEntity<List<UserDto>> findUsersCreatedAfter(  @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date ) {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userService.findUsersCreatedAfter(date);
        List<UserDto> usersDto = new ArrayList<>();
        for(User user : users){
            UserDto userDto = modelMapper.map(user, UserDto.class);
            usersDto.add(userDto);
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        try{
            User user = new User(userDto);
            user.addRole(RoleEnum.ADMIN);
            userService.create(user);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto user, @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        try{
            userService.update(user, id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( "/{id}" )
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try{
            userService.deleteById(id);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }
}