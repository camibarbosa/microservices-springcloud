package com.course.springcloud.msavaliadorcredito.application.ex;

public class ErroSolicitacaoCartaoException  extends RuntimeException{
    public ErroSolicitacaoCartaoException(String message){
        super(message);
    }
}
