package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.SupplierNumberException;
import com.rakovets.course.design.practice.solid.pizza.model.Supplier;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;
import com.rakovets.course.design.practice.solid.pizza.util.CheckInt;
import com.rakovets.course.design.practice.solid.pizza.view.SupplyServiceViewConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SupplyService {
    private static final Map<Integer, Supplier> SUPPLIERS;
    private static final StorageRepository STORAGE;
    private static final SupplyServiceViewConsole SUPPLY_SERVICE_VIEW;
    private static final Scanner SCANNER;
    public int supplierChoice;
    public static final CheckInt CHECK_INT;

    static {
        SUPPLIERS = new HashMap<>();
        SUPPLIERS.put(1, Supplier.SUPPLIER_1);
        SUPPLIERS.put(2, Supplier.SUPPLIER_2);
        SUPPLIERS.put(3, Supplier.SUPPLIER_3);
        SUPPLIERS.put(4, Supplier.SUPPLIER_4);
        SUPPLIERS.put(5, Supplier.SUPPLIER_5);
        SUPPLIERS.put(6, Supplier.SUPPLIER_6);
        SUPPLIERS.put(7, Supplier.SUPPLIER_7);
        SUPPLIERS.put(8, Supplier.SUPPLIER_8);

        STORAGE = new StorageRepository();
        SUPPLY_SERVICE_VIEW = new SupplyServiceViewConsole();
        SCANNER = new Scanner(System.in);
        CHECK_INT = new CheckInt();
    }

    public void start() {
        SUPPLY_SERVICE_VIEW.suppliersMenu();
        try {
            supplierChoice = CHECK_INT.checkInt();
            switch (SUPPLIERS.get(supplierChoice)) {
                case SUPPLIER_1:
                    SUPPLY_SERVICE_VIEW.supplier1IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_1.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_1.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier1IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_2:
                    SUPPLY_SERVICE_VIEW.supplier2IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_2.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_2.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier2IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_3:
                    SUPPLY_SERVICE_VIEW.supplier3IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_3.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_3.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier3IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_4:
                    SUPPLY_SERVICE_VIEW.supplier4IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_4.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_4.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier4IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_5:
                    SUPPLY_SERVICE_VIEW.supplier5IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_5.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_5.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier5IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_6:
                    SUPPLY_SERVICE_VIEW.supplier6IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_6.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_6.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier6IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_7:
                    SUPPLY_SERVICE_VIEW.supplier7IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_7.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_7.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier7IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_8:
                    SUPPLY_SERVICE_VIEW.supplier8IngredientBefore();
                    SUPPLY_SERVICE_VIEW.supplierDeliveredQuantity();
                    STORAGE.changeIngredientQuantity(Supplier.SUPPLIER_8.getIngredient(),
                            STORAGE.getIngredientQuantity(Supplier.SUPPLIER_8.getIngredient())
                                    + SCANNER.nextInt());
                    SUPPLY_SERVICE_VIEW.supplier8IngredientAfter();
                    addChoiceQuestion();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new SupplierNumberException();
            } catch (SupplierNumberException ex) {
                SUPPLY_SERVICE_VIEW.supplierNumberException();
                addChoiceQuestion();
            }
        }
    }

    public void addChoiceQuestion() {
        SUPPLY_SERVICE_VIEW.chooseOtherSupplier();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }
}
