package com.example.przyklad_4.domain.user.port;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@Table(name="t_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private Long id;
    private UUID uuid;
    private BigDecimal realAmount;
    private BigDecimal freeAmount;
    private Long addressId;

    public UserEntity(UUID uuid, BigDecimal realAmount, BigDecimal freeAmount) {
    }


    public void creditBalance(BigDecimal creditRealAmount,
                              BigDecimal creditFreeAmount) {
        this.realAmount = realAmount.add(creditRealAmount);
        this.freeAmount = freeAmount.add(creditFreeAmount);
    }

    public void debitBalance(BigDecimal creditRealAmount,
                             BigDecimal creditFreeAmount) {
        validateBalance(realAmount, freeAmount);
        this.realAmount = realAmount.subtract(creditRealAmount);
        this.freeAmount = freeAmount.subtract(creditFreeAmount);
    }

    public void linkAddressToUser(Long id) {
        this.addressId = id;
    }

    private void validateBalance(BigDecimal realAmount, BigDecimal freeAmount) {

    }
}
