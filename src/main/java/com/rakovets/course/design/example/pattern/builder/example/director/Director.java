package com.rakovets.course.design.example.pattern.builder.example.director;

import com.rakovets.course.design.example.pattern.builder.example.builders.Builder;
import com.rakovets.course.design.example.pattern.builder.example.cars.CarType;
import com.rakovets.course.design.example.pattern.builder.example.components.Engine;
import com.rakovets.course.design.example.pattern.builder.example.components.GPSNavigator;
import com.rakovets.course.design.example.pattern.builder.example.components.Transmission;
import com.rakovets.course.design.example.pattern.builder.example.components.TripComputer;

/**
 * Директор знает в какой последовательности заставлять работать строителя. Он
 * работает с ним через общий интерфейс Строителя. Из-за этого, он может не
 * знать какой конкретно продукт сейчас строится.
 */
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
