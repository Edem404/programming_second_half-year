package ua.lviv.iot.algo.part1.lab3.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
import ua.lviv.iot.algo.part1.lab3.models.CoffeeTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CoffeeTableService {

    private final Map<Integer, CoffeeTable> coffeeTableMap = new HashMap<>();
    private final AtomicInteger nextAvailableId = new AtomicInteger(1);

    public List<CoffeeTable> getAllCoffeeTables() {
        return new ArrayList<>(coffeeTableMap.values());
    }

    public CoffeeTable getCoffeeTableById(final Integer id) {
        return coffeeTableMap.get(id);
    }

    public void addToMap(final CoffeeTable coffeeTable) {
        coffeeTable.setId(nextAvailableId.getAndIncrement());
        coffeeTableMap.put(coffeeTable.getId(), coffeeTable);
    }

    public CoffeeTable deleteCoffeeTable(final Integer id) {
        return coffeeTableMap.remove(id);
    }

    public void updateCoffeeTable(final CoffeeTable coffeeTable, final Integer id) {
        coffeeTable.setId(id);
        coffeeTableMap.put(id, coffeeTable);
    }
}
