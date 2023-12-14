package com.ismaeldev.integrador.dtos;

import com.ismaeldev.integrador.domain.Financial.FinancialCoin;

public record FinancialDTOS(String paymentMethod,
                            Boolean isMonthly,
                            Double price,
                            FinancialCoin coinType,
                            Byte datePayment,
                            Integer vehiclesLimit,
                            Integer additionalLimit,
                            Float additionalPrice,
                            Long storeId
) {
}
