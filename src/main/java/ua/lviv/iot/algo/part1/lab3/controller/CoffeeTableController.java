package ua.lviv.iot.algo.part1.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.iot.algo.part1.lab3.models.CoffeeTable;
import ua.lviv.iot.algo.part1.lab3.service.CoffeeTableService;

import java.util.List;

@RestController
@RequestMapping(path = "desks")
public class CoffeeTableController {

    @Autowired
    private CoffeeTableService coffeeTableService;

    @GetMapping
    public List<CoffeeTable> getCoffeeTables() {
        return coffeeTableService.getAllCoffeeTables();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CoffeeTable> getCoffeeTableById(@PathVariable("id") final Integer coffeeTableId) {
        if (coffeeTableService.getCoffeeTableById(coffeeTableId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(coffeeTableService.getCoffeeTableById(coffeeTableId), HttpStatus.OK);
    }

    @PostMapping
    public CoffeeTable createCoffeeTable(@RequestBody final CoffeeTable coffeeTable) {
        coffeeTableService.addToMap(coffeeTable);

        return coffeeTable;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CoffeeTable> deleteCoffeeTable(@PathVariable("id") final Integer coffeeTableId) {
        if (coffeeTableService.deleteCoffeeTable(coffeeTableId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CoffeeTable> updateCoffeeTable(@RequestBody final CoffeeTable coffeeTable,
                                                         @PathVariable("id") final Integer coffeeTableId) {
        if (coffeeTableService.getCoffeeTableById(coffeeTableId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        coffeeTableService.updateCoffeeTable(coffeeTable, coffeeTableId);

        return new ResponseEntity<>(coffeeTableService.getCoffeeTableById(coffeeTableId), HttpStatus.OK);
    }
}
