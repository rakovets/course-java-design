package com.rakovets.course.design.example.pattern.builder.example.builders;

import com.rakovets.course.design.example.pattern.builder.example.cars.CarType;
import com.rakovets.course.design.example.pattern.builder.example.components.Engine;
import com.rakovets.course.design.example.pattern.builder.example.components.GPSNavigator;
import com.rakovets.course.design.example.pattern.builder.example.components.Transmission;
import com.rakovets.course.design.example.pattern.builder.example.components.TripComputer;

/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации
 * продукта.
 */
public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
