package br.com.almeida.producerservice.services;

import br.com.almeida.producerservice.configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.almeida.producerservice.configs.RabbitMQConfig.*;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce( String message ) {
        log.info( "Received message " + message );
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }

}
