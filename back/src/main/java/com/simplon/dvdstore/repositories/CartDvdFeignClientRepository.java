package com.simplon.dvdstore.repositories;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cart-dvd", url = "http://localhost:9090")
public interface CartDvdFeignClientRepository {



}
