package com.ismaeldev.integrador.domain.Financial;

public enum FinancialCoin {

    BRAZIL("R$"),
    AMERICAN("USD"),
    EUROPEAN("€");

    private final String coin;

    FinancialCoin(String coin) {
        this.coin = coin;
    }

    public String getCoin() {
        return coin;
    }
}
