package com.wtk.test.service;

import com.wtk.test.model.Beer;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Optional<Beer> getBeerById(UUID id);

    Beer saveBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, Beer beer);
}
