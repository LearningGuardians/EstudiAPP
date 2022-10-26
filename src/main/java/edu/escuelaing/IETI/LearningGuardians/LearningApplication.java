package edu.escuelaing.IETI.LearningGuardians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.escuelaing.IETI.LearningGuardians"})
public class LearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
    }
}
/**
 * Crear usuario con contraseña
 * Probar el endpoint de /v1/auth con email y constraseña normal (se hashea en ejecucion)
 * https://github.dev/laura-gar/IETI-TaskPlanner-Users/tree/securityJWT
 */