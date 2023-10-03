package com.bloomberg.warehouse.controller;

import com.bloomberg.warehouse.model.dto.FxDealDto;
import com.bloomberg.warehouse.service.FxDealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fx-deal")
@Slf4j
public class FxDealController {
    @Autowired
    private FxDealService fxDealService;

    @PostMapping
    public FxDealDto addFxDeal(@RequestBody @Validated FxDealDto fxDeal) {
        return fxDealService.addFxDeal(fxDeal);
    }
}
