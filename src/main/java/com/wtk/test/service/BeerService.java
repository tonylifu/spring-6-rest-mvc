package com.wtk.test.service;

import com.wtk.test.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
