package dev.calixtolucas.eisentodo.infra.gatewaysImplementations;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import dev.calixtolucas.eisentodo.adapters.gateways.AuthenticationGateway;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.domain.exceptions.InternalServerError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationGatewayImpl implements AuthenticationGateway {

    private PasswordEncoder passwordEncoder;
    private JwtEncoder jwtEncoder;

    public AuthenticationGatewayImpl(PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {

        return passwordEncoder.matches(rawPassword, encodedPassword);

    }

    @Override
    public String generateToken(User user) {

        Instant now = Instant.now();
        long minutesInSeconds = 300L;

        try {

            log.info("Gerando token para o usuário: {}", user.getUsername());

            var claims = JwtClaimsSet.builder()
            .issuer("eisen-todo-api")
            .subject(user.getId().toString())
            .expiresAt(now.plusSeconds(minutesInSeconds))
            .issuedAt(now)
            .build();

            String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
            
            log.info("Token gerado com sucesso para o usuário: {}", user.getUsername());

            return token;
        } catch (Exception e) {
            throw new InternalServerError("Ocorreu algum erro ao realizar seu login");
        }

    }
    
}
