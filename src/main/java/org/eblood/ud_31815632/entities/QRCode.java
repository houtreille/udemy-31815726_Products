package org.eblood.ud_31815632.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Data
@Entity
public class QRCode {

    @Id
    @Column(name="KEY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="CODE")
    private String code;

    @OneToOne(mappedBy = "qrCode")
    private Product product;


}
