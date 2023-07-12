package com.installfuturecase.InstallFutureBackendCase.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transactions")
@Table(name = "transactions")
public class transactions {

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
}