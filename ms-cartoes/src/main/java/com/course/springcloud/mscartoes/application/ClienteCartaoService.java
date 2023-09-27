package com.course.springcloud.mscartoes.application;

import com.course.springcloud.mscartoes.domain.ClienteCartao;
import com.course.springcloud.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRepository repository;

    //encontra lista de cartoes por cpf
    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
