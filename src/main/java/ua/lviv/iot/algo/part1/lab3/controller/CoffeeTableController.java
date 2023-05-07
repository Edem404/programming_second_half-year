package ua.lviv.iot.algo.part1.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.algo.part1.lab3.models.CoffeeTable;
import ua.lviv.iot.algo.part1.lab3.service.CoffeeTableService;

import java.util.Collection;

import lombok.Getter;

@Getter
@RestController
@RequestMapping(path = "desks")
public class CoffeeTableController {

    private CoffeeTableService coffeeTableService = new CoffeeTableService();

    @GetMapping(path = "getAll")
    public Collection<CoffeeTable> getCoffeeTables() {
        return coffeeTableService.getCoffeeTableMap().values();
    }

    @GetMapping(path = "getById/{id}")
    public ResponseEntity<CoffeeTable> getCoffeeTableById(@PathVariable("id") Integer coffeeTableId) {
        if(coffeeTableService.getCoffeeTableMap().get(coffeeTableId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(coffeeTableService.getCoffeeTableMap().get(coffeeTableId), HttpStatus.OK);
    }

    @PostMapping(path = "post")
    public CoffeeTable createCoffeeTable(@RequestBody CoffeeTable coffeeTable) {

        coffeeTable.setID(coffeeTableService.getNextAvailableId().getAndIncrement());
        coffeeTableService.getCoffeeTableMap().put(coffeeTable.getID(), coffeeTable);
        return coffeeTable;
    }

    @DeleteMapping(path = "del/{id}")
    public ResponseEntity<CoffeeTable> deleteCoffeeTable(@PathVariable("id") Integer coffeeTableId) {
        if (coffeeTableService.getCoffeeTableMap().remove(coffeeTableId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "put/{id}")
    public ResponseEntity<CoffeeTable> updateCoffeeTable(@RequestBody CoffeeTable coffeeTable, @PathVariable("id") Integer coffeeTableId) {

        if (!coffeeTableService.getCoffeeTableMap().containsKey(coffeeTableId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        coffeeTable.setID(coffeeTableId);
        coffeeTableService.getCoffeeTableMap().put(coffeeTableId, coffeeTable);

        return new ResponseEntity<>(coffeeTableService.getCoffeeTableMap().get(coffeeTableId), HttpStatus.OK);
    }
}
