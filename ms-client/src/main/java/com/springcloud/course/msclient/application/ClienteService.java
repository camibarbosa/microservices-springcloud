package com.springcloud.course.msclient.application;

import com.springcloud.course.msclient.domain.Cliente;
import com.springcloud.course.msclient.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    /*constructor
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }*/

    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return repository.findByCpf(cpf);
    }
}
