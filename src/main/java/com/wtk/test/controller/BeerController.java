package com.wtk.test.controller;

import com.wtk.test.exception.NotFoundException;
import com.wtk.test.model.Beer;
import com.wtk.test.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BeerController {
    private final BeerService beerService;

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    @PatchMapping(value = BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId")UUID beerId, @RequestBody Beer beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

        beerService.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId")UUID beerId, @RequestBody Beer beer){

        beerService.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = BEER_PATH)
    public ResponseEntity<?> saveBeer(@RequestBody Beer beer) {
        Beer beerResponse = beerService.saveBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/"+ beerResponse.getId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .headers(headers)
                .body(beerResponse);
    }

    @GetMapping(value = BEER_PATH_ID)
    public ResponseEntity<?> getBearById(@PathVariable("beerId") UUID beerId) {
        log.debug("\n\nGet Beer by id :::: controller => {}\n\n", beerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(beerService.getBeerById(beerId)
                        .orElseThrow(NotFoundException::new));
    }

    @GetMapping(value = BEER_PATH)
    public List<Beer> listBeer() {
        log.debug("\n\nList Beers :::: controller\n\n");
        return beerService.listBeers();
    }

}
