package com.io.handsonWithWcnp1.controllers;

import com.io.handsonWithWcnp1.entity.Orders;
import com.io.handsonWithWcnp1.services.WcnpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WcnpController {

    Logger logger= LoggerFactory.getLogger(WcnpController.class);

    @Autowired
    private WcnpService service;

    @GetMapping("/orders")
    public String getOrderDetails() {
        logger.info("Method invoked");
        return service.getOrdersDetails();
    }

    @PostMapping("/order")
    public Orders saveOrder(@RequestBody Orders order) {
        logger.info("Method invoked");
        return service.saveOrderDetails(order);
    }

}
