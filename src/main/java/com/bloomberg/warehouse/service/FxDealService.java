package com.bloomberg.warehouse.service;

import com.bloomberg.warehouse.model.dto.FxDealDto;
import com.bloomberg.warehouse.model.entity.FxDeal;
import com.bloomberg.warehouse.repository.FxDealRepositoryImpl;
import com.bloomberg.warehouse.util.exception.FxDealAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FxDealService {
    @Autowired
    private FxDealRepositoryImpl fxDealRepository;

    public FxDealDto addFxDeal(FxDealDto fxDeal) {
        if (fxDealRepository.getFxDeal(fxDeal.getId()).isEmpty()) {
            fxDealRepository.insertFxDeal(mapToFxDeal(fxDeal));
            return fxDeal;
        }
        throw new FxDealAlreadyExistException();
    }

    private FxDeal mapToFxDeal(FxDealDto fxDealDto) {
        return FxDeal.builder()
                .id(fxDealDto.getId())
                .dealAmount(fxDealDto.getDealAmount())
                .dealTimestamp(fxDealDto.getDealTimestamp())
                .fromCurrency(fxDealDto.getFromCurrency().getCode())
                .toCurrency(fxDealDto.getToCurrency().getCode())
                .build();
    }

}
