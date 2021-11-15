package com.io.handsonWithWcnp1.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {

    private Integer id;
    private Long number;
    private Long paymentId;
    private Double invoiceAmount;
    private String comment;
    private String orderTime;
    private String currency;
    private Integer paymentStatusId;
    private Integer orderStatusId;


    public Orders() {
    }

    public Orders(Integer id, Long number, Long paymentId, Double invoiceAmount,
                  String comment, String orderTime,
                  String currency, Integer paymentStatusId, Integer orderStatusId) {
        this.id = id;
        this.number = number;
        this.paymentId = paymentId;
        this.invoiceAmount = invoiceAmount;
        this.comment = comment;
        this.orderTime = orderTime;
        this.currency = currency;
        this.paymentStatusId = paymentStatusId;
        this.orderStatusId = orderStatusId;
    }


}
