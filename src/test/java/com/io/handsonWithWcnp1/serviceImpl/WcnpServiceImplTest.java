package com.io.handsonWithWcnp1.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.handsonWithWcnp1.entity.Orders;
import com.io.handsonWithWcnp1.services.WcnpService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class WcnpServiceImplTest {

    @MockBean
    private WcnpService service;

    @Test
    void getOrdersDetails() throws JsonProcessingException {
        String orderDetails = new ObjectMapper().writeValueAsString(
                new Orders(10, 10l, 409l, 102.98,
                        "", new Date().toString(),
                        "EUR", 204, 100));
        when(service.getOrdersDetails())
                .thenReturn(new ObjectMapper().writeValueAsString(
                        new Orders(10, 10l, 409l, 102.98,
                                "", new Date().toString(),
                                "EUR", 204, 100)));
        assertEquals(orderDetails, service.getOrdersDetails());
    }

    @Test
    void saveOrderDetails() {
        Orders order = new Orders(10, 10l, 409l, 102.98,
                "", new Date().toString(),
                "EUR", 204, 100);
        when(service.saveOrderDetails(order)).thenReturn(order);
        assertEquals(order, service.saveOrderDetails(order));
    }
}