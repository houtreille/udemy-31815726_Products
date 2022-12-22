package org.eblood.ud_31815632.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {

    private Long productId;
    private String productName;
    private Double productPrice;
    private Date creationDate;
}
