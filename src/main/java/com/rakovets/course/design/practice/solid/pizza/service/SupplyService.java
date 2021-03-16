package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Supplier;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;

public class SupplyService {
    private static final StorageRepository storage;

    static {
        storage = new StorageRepository();
    }

    public void deliveredIngredientsFromSupplier1() {
        storage.changeIngredientQuantity(Supplier.SUPPLIER_1);
    }

    public void deliveredIngredientsFromSupplier2() {
        storage.changeIngredientQuantity(Supplier.SUPPLIER_2);
    }

    public void deliveredIngredientsFromSupplier3() {
        storage.changeIngredientQuantity(Supplier.SUPPLIER_3);
    }

    public void deliveredIngredientsFromSupplier4() {
        storage.changeIngredientQuantity(Supplier.SUPPLIER_4);
    }

    public void deliveredIngredientsFromSupplier5() {
        storage.changeIngredientQuantity(Supplier.SUPPLIER_5);
    }
}
