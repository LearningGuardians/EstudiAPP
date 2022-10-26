package edu.escuelaing.IETI.LearningGuardians.controllers.auth;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.IETI.LearningGuardians.dtos.users.LoginDto;
import edu.escuelaing.IETI.LearningGuardians.dtos.users.TokenDto;
import edu.escuelaing.IETI.LearningGuardians.entities.users.User;
import edu.escuelaing.IETI.LearningGuardians.exceptions.InvalidCredentialsException;
import edu.escuelaing.IETI.LearningGuardians.services.UserService;

import java.util.Calendar;
import java.util.Date;

import static edu.escuelaing.IETI.LearningGuardians.entities.constants.Constants.TOKEN_DURATION_MINUTES;
import static edu.escuelaing.IETI.LearningGuardians.entities.constants.Constants.CLAIMS_ROLES_KEY;

/**
 * @author Laura Garcia
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping( "/api/v1/auth" )
public class AuthController {

    @Value( "${app.secret}" )
    String secret;

    private final UserService userService;

    public AuthController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        User user = userService.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            return generateTokenDto(user);
        } else {
            throw new InvalidCredentialsException();
        }
    }

    private String generateToken(User user, Date expirationDate) {
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(User user) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}