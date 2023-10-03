package com.bloomberg.warehouse;

import com.bloomberg.warehouse.model.dto.FxDealDto;
import com.bloomberg.warehouse.model.enums.Currency;
import com.bloomberg.warehouse.repository.FxDealRepositoryImpl;
import com.bloomberg.warehouse.service.FxDealService;
import com.bloomberg.warehouse.util.exception.FxDealAlreadyExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class FxDealsApplicationTests {


    @Autowired
    private FxDealService fxDealService;
    @Autowired
    private FxDealRepositoryImpl repository;

    @Test
    public void testInsertFxDeal() {
        FxDealDto validFxDeal = FxDealDto.builder()
                .id(50)
                .dealAmount(BigDecimal.valueOf(100))
                .dealTimestamp(LocalDateTime.now())
                .fromCurrency(Currency.CAD)
                .toCurrency(Currency.EUR).build();

        FxDealDto insertedDeal = fxDealService.addFxDeal(validFxDeal);

        assertNotNull(insertedDeal.getId());
    }

    @Test
    public void testInsertFxDealDuplicate() {
        when(repository.getFxDeal(1).isPresent()).thenReturn(true);

        assertThrows(FxDealAlreadyExistException.class, () -> {
            FxDealDto validFxDeal = FxDealDto.builder()
                    .id(50)
                    .dealAmount(BigDecimal.valueOf(100))
                    .dealTimestamp(LocalDateTime.now())
                    .fromCurrency(Currency.CAD)
                    .toCurrency(Currency.EUR).build();
            fxDealService.addFxDeal(validFxDeal);
        });

    }

}
