package com.course.springcloud.msavaliadorcredito.application;

import com.course.springcloud.msavaliadorcredito.application.ex.DadosClienteNotFoundException;
import com.course.springcloud.msavaliadorcredito.application.ex.ErroComunicacaoMicroservicesException;
import com.course.springcloud.msavaliadorcredito.domain.model.CartaoCliente;
import com.course.springcloud.msavaliadorcredito.domain.model.DadosCliente;
import com.course.springcloud.msavaliadorcredito.domain.model.SituacaoCliente;
import com.course.springcloud.msavaliadorcredito.infra.clients.CartoesResourceClient;
import com.course.springcloud.msavaliadorcredito.infra.clients.ClienteResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private  final ClienteResourceClient clientesClient;
    private final CartoesResourceClient cartoesCliente;
    public SituacaoCliente obterSituacaoCliente(String cpf)
            throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
        // obterDadosCliente - MSCLIENTES
        // obter cartoes do cliente - MsCartoes
        try {
            ResponseEntity<DadosCliente> dadosClienteResponseEntity = clientesClient.dadosCliente(cpf);

            ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesCliente.getCartoesByCliente(cpf);
            return SituacaoCliente
                    .builder()
                    .cliente(dadosClienteResponseEntity.getBody())
                    .cartoes(cartoesResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }
}
