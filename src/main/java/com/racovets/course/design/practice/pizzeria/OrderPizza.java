package com.racovets.course.design.practice.pizzeria;

import com.racovets.course.design.practice.pizzeria.model.Ingredients;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

public class OrderPizza {
    private int totalCost;
    private boolean isClosed = false;
    private Map<Pizza, Integer> orderMap = new HashMap<>();
    private LocalDateTime localDateTimeOfOrder;
    private int totalCostWithDiscount = 4000;
    private boolean isDiscount;
    private int discount = 20;
    private int dayOfWeekForDiscount = 4;
    private int pizzaCountForDiscount;
    private int totalPizzaCountInOrder;

    public int getTotalPizzaCountInOrder () {
        for (Map.Entry<Pizza, Integer> item : orderMap.entrySet()) {
            totalPizzaCountInOrder += item.getValue();
        } return totalPizzaCountInOrder;
    }

    public int getTotalCostWithDiscount() {
        if (isDiscount) {
             totalCostWithDiscount = totalCost - (totalCost * discount / 100);
        } else {
            totalCostWithDiscount = totalCost;
        } return totalCostWithDiscount;
    }
    public boolean isDiscount() {
        if ((localDateTimeOfOrder.get(ChronoField.DAY_OF_WEEK) == dayOfWeekForDiscount) ||
                (totalPizzaCountInOrder >= pizzaCountForDiscount)) {
            isDiscount = true;
        } else {
            isDiscount = false;
        }
        return isDiscount;
    }

    public void printOrderCheck() {
        String dateTimeOfOrder = localDateTimeOfOrder.format(DateTimeFormatter.ofPattern("yyyy:MM:dd, HH:mm"));
        StringBuilder orderText = new StringBuilder();
        for (Map.Entry<Pizza, Integer> item : orderMap.entrySet()) {
            orderText.append(item.getKey().toString());
            orderText.append(" Count:" + item.getValue());
            int cost = item.getKey().getPrice() * item.getValue();
            orderText.append(" Cost = " + cost + " \n");
        }
        System.out.println(dateTimeOfOrder);
        System.out.println(orderText.toString() + "\n" + "Total cost: " + totalCost);
        System.out.println("Total cost with discount: " + totalCostWithDiscount);
        File newFile = new File("src" + File.separator +
                "test" + File.separator + "resources" + File.separator + "check.txt");
        try {
            boolean created = newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
            bw.write(dateTimeOfOrder + "\n");
            bw.write(orderText.toString() + "\n" + "Total cost: " + totalCost);
            bw.write("Total cost with discount: " + totalCostWithDiscount);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Pizza, Integer> getOrderMap() {
        return orderMap;
    }

    public LocalDateTime getLocalDateTimeOfOrder() {
        return localDateTimeOfOrder;
    }

    public void setLocalDateTimeOfOrder(LocalDateTime localDateTimeOfOrder) {
        this.localDateTimeOfOrder = localDateTimeOfOrder;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int pizzaCost) {
        totalCost += pizzaCost;
    }

    public int getDayOfWeekForDiscount() {
        return dayOfWeekForDiscount;
    }

    public void setDayOfWeekForDiscount(int dayOfWeekForDiscount) {
        this.dayOfWeekForDiscount = dayOfWeekForDiscount;
    }

    public int getPizzaCountForDiscount() {
        return pizzaCountForDiscount;
    }

    public void setPizzaCountForDiscount(int pizzaCountForDiscount) {
        this.pizzaCountForDiscount = pizzaCountForDiscount;
    }
}
