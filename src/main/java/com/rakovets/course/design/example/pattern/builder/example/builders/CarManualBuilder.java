package com.rakovets.course.design.example.pattern.builder.example.builders;

import com.rakovets.course.design.example.pattern.builder.example.cars.CarType;
import com.rakovets.course.design.example.pattern.builder.example.cars.Manual;
import com.rakovets.course.design.example.pattern.builder.example.components.Engine;
import com.rakovets.course.design.example.pattern.builder.example.components.GPSNavigator;
import com.rakovets.course.design.example.pattern.builder.example.components.Transmission;
import com.rakovets.course.design.example.pattern.builder.example.components.TripComputer;

/**
 * В отличие от других создающих паттернов, Строители могут создавать совершенно
 * разные продукты, не имеющие общего интерфейса.
 * <p>
 * В данном случае мы производим руководство пользователя автомобиля с помощью
 * тех же шагов, что и сами автомобили. Это устройство позволит создавать
 * руководства под конкретные модели автомобилей, содержащие те или иные фичи.
 */
public class CarManualBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
