package dev.calixtolucas.eisentodo.adapters.useCaseImplementations.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.calixtolucas.eisentodo.adapters.gateways.user.FindUserByUsernameGateway;
import dev.calixtolucas.eisentodo.domain.User;
import dev.calixtolucas.eisentodo.infra.entity.UserEntity;
import dev.calixtolucas.eisentodo.infra.mappers.UserMapper;
import dev.calixtolucas.eisentodo.infra.repository.UserEntityRepository;

@Service
public class FindUserByUsernameGatewayImpl implements FindUserByUsernameGateway {

    private UserEntityRepository userEntityRepository;

    public FindUserByUsernameGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User findByUsername(String username) {

        //pesquisa no banco
        Optional<UserEntity> userEntity = userEntityRepository.findByUsername(username);
        if(userEntity.isEmpty()){
            return null;
        }

        //mapeia para classe de domínio e retorna
        User user = UserMapper.toUser(userEntity.get());
        return user;

    }

    
    
}
