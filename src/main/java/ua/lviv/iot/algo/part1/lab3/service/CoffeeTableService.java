package ua.lviv.iot.algo.part1.lab3.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
import ua.lviv.iot.algo.part1.lab3.models.CoffeeTable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CoffeeTableService {

    private Map<Integer, CoffeeTable> coffeeTableMap = new HashMap<>();
    private AtomicInteger nextAvailableId = new AtomicInteger(1);

}
