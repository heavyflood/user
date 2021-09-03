package com.phs.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping("/user")
    public Mono<String> getUser(ServerHttpRequest request, ServerHttpResponse response) {
        logger.info("User MicroService Start>>>>>>>>");
        HttpHeaders headers = request.getHeaders();
        headers.forEach((k, v) -> {
            logger.info(k + " : " + v);
        });
        logger.info("User MicroService End>>>>>>>>");

        return Mono.just("This is User MicroService!!!!!");
    }
}
