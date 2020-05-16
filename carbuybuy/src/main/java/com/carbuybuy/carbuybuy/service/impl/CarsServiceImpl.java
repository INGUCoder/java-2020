package com.carbuybuy.carbuybuy.service.impl;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.mapper.CarsMapper;
import com.carbuybuy.carbuybuy.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarsMapper carsMapper;

    @Override
    public List<Cars> selectAll() {
        return carsMapper.selectAll();
    }

    @Override
    public Cars selectById(Integer id) {
        return carsMapper.selectById(id);
    }

    @Override
    public List<Cars> selectByTypes(Integer types) {
        return carsMapper.selectByTypes(types);
    }

    @Override
    public void insertCar(Cars cars) {
        this.carsMapper.insertCar(cars);
    }

    @Override
    public void deleteCar(Integer id) {
        this.carsMapper.deleteCar(id);
    }

    @Override
    public List<Cars> selectByCarName(String name) {
        return carsMapper.selectByName(name);
    }
}
