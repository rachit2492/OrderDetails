package com.io.handsonWithWcnp1.services;

import com.io.handsonWithWcnp1.entity.Orders;
import org.springframework.stereotype.Service;

@Service
public interface WcnpService {

    public String getOrdersDetails();

    public Orders saveOrderDetails(Orders order);
}
