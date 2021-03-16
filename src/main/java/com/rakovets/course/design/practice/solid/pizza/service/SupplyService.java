package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.UserInputException;
import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Supplier;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;
import com.rakovets.course.design.practice.solid.pizza.view.SupplyServiceViewConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SupplyService {
    private static final Map<Integer, Supplier> suppliers;
    private static final StorageRepository storage;
    private static final SupplyServiceViewConsole supplyServiceViewConsole;

    static {
        suppliers = new HashMap<>();
        suppliers.put(1, Supplier.SUPPLIER_1);
        suppliers.put(2, Supplier.SUPPLIER_2);
        suppliers.put(3, Supplier.SUPPLIER_3);
        suppliers.put(4, Supplier.SUPPLIER_4);
        suppliers.put(5, Supplier.SUPPLIER_5);
        suppliers.put(6, Supplier.SUPPLIER_6);
        suppliers.put(7, Supplier.SUPPLIER_7);
        suppliers.put(8, Supplier.SUPPLIER_8);

        storage = new StorageRepository();
        supplyServiceViewConsole = new SupplyServiceViewConsole();
    }

    public void start() {
        supplyServiceViewConsole.suppliersMenu();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        try {
            switch (suppliers.get(choice)) {
                case SUPPLIER_1:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_1.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_1.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_2:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_2.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_2.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_3:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_3.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_3.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_4:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_4.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_4.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_5:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_5.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_5.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_6:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_6.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_6.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_7:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_7.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_7.getIngredient())
                                    + scan.nextInt());
                    break;
                case SUPPLIER_8:
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_8.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_8.getIngredient())
                                    + scan.nextInt());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new UserInputException(choice);
            } catch (UserInputException ex) {
                ex.printStackTrace();
            }
        }
    }
}
