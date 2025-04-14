package dev.calixtolucas.eisentodo.infra.gatewaysImplementations;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.calixtolucas.eisentodo.adapters.gateways.user.CreateUserGateway;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.domain.exceptions.InternalServerError;
import dev.calixtolucas.eisentodo.infra.entity.RoleEntity;
import dev.calixtolucas.eisentodo.infra.entity.UserEntity;
import dev.calixtolucas.eisentodo.infra.mappers.UserMapper;
import dev.calixtolucas.eisentodo.infra.repository.RoleEntityRepository;
import dev.calixtolucas.eisentodo.infra.repository.UserEntityRepository;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway{

    private UserEntityRepository userEntityRepository;
    private RoleEntityRepository roleEntityRepository;
    private PasswordEncoder passwordEncoder;
    
    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository,
     RoleEntityRepository roleEntityRepository,
     PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.roleEntityRepository = roleEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Boolean createUser(User user) {
        
        try{
            //criando userEntity
            Optional<RoleEntity> roleEntity = roleEntityRepository.findByRoleName(user.getRole());
            
            //criptografa senha
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            UserEntity userToBeSaved = UserMapper.toEntity(user, roleEntity.get());

            //salva no banco
            userEntityRepository.save(userToBeSaved);

            return true;
        }catch(Exception e){
            throw new InternalServerError("Ocorreu um erro ao criar o usuário, contate um desenvolvedor");
        }
        

    }
    
}
