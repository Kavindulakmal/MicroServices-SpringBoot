package com.payment.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "amount")
    private String amount;
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Column(name = "card_no")
    private String cardNo;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "exp_date")
    private String expDate;
}
