package com.springcloud.course.msclient.application.representation;

import com.springcloud.course.msclient.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {
    private String cpf;
    private String nome;
    private Integer idade;

    //converter ClienteSaveRequest e Cliente
    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}
