package com.wtk.test.controller;

import com.wtk.test.model.Beer;
import com.wtk.test.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BeerController {
    private final BeerService beerService;

    public Beer getBearById(UUID id) {
        log.debug("\n\nGet Beer by id :::: controller\n\n");
        return beerService.getBeerById(id);
    }

}
