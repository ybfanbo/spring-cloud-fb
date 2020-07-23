package com.fanbo.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class FanBoGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String headerToken = request.getHeaders().getFirst("Token");  //请求头的token

        String token = request.getQueryParams().getFirst("token");

        //判断token是否有效
        if ("1234".equals(token)){
            return chain.filter(exchange);  //放行
        }else {
            System.out.println("token无效...........");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.FORBIDDEN);  //403
            return response.setComplete(); //拦截
        }


    }
}
