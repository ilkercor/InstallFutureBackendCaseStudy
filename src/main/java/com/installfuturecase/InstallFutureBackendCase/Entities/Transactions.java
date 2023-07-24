package com.installfuturecase.InstallFutureBackendCase.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "transactions")
@Table(name = "transactions")
public class Transactions {

    @Column(name = "transactionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;

    @Column(name = "username")
    private String username;

    @Column(name = "transactionamount")
    private int transactionamount;

    @Column(name = "transactiondescription")
    private String transactiondescription;

    @Column(name = "transactiontype")
    private String transactiontype;

    @Column(name = "transactiondate")
    private LocalDate transactiondate;
}