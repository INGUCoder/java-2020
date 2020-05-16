package com.carbuybuy.carbuybuy.service;

import com.carbuybuy.carbuybuy.entity.Cars;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarsService {

    List<Cars> selectAll();

    Cars selectById(Integer id);

    List<Cars> selectByTypes(Integer types);

    void insertCar(Cars cars);

    void deleteCar(Integer id);

    List<Cars> selectByCarName(String name);

}
