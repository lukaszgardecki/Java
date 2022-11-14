package com.mojastrona.zad_51_jee_mvc;

import java.math.BigDecimal;

public class ExchangeResult {
    private BigDecimal base;
    private BigDecimal result;
    private ExchangeType exchangeType;

    public ExchangeResult(BigDecimal base, BigDecimal result, ExchangeType exchangeType) {
        this.base = base;
        this.result = result;
        this.exchangeType = exchangeType;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BigDecimal getResult() {
        return result;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }
}
