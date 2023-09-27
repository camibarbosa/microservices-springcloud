package com.course.springcloud.mscartoes.application;

import com.course.springcloud.mscartoes.domain.Cartao;
import com.course.springcloud.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {
    private final CartaoRepository repository;

    public Cartao save(Cartao cartao){
        return repository.save(cartao);
    }

    //retornar lista de cartoes
    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
