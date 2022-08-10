package com.slayerd.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

//@Order(value = 0)
@Component
public class TestFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        System.out.println(request.getQueryParams());
        System.out.println(request.getHeaders().get("TEST"));
        List<String> value = request.getQueryParams().get("test");
//        List<String> value1 = request.getHeaders().get("test");
        if(!Objects.equals(null,value) && value.contains("1")){
            return chain.filter(exchange);
        }else {
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
