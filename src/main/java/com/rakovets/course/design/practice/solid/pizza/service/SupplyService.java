package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.SupplierNumberException;
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
    private static final Scanner scanner;
    public int enteredInt;
    public int supplierChoice;

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
        scanner = new Scanner(System.in);
    }

    public void start() {
        supplyServiceViewConsole.suppliersMenu();
        try {
            supplierChoice = checkInt();
            switch (suppliers.get(supplierChoice)) {
                case SUPPLIER_1:
                    supplyServiceViewConsole.supplier1IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_1.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_1.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier1IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_2:
                    supplyServiceViewConsole.supplier2IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_2.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_2.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier2IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_3:
                    supplyServiceViewConsole.supplier3IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_3.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_3.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier3IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_4:
                    supplyServiceViewConsole.supplier4IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_4.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_4.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier4IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_5:
                    supplyServiceViewConsole.supplier5IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_5.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_5.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier5IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_6:
                    supplyServiceViewConsole.supplier6IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_6.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_6.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier6IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_7:
                    supplyServiceViewConsole.supplier7IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_7.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_7.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier7IngredientAfter();
                    addChoiceQuestion();
                    break;
                case SUPPLIER_8:
                    supplyServiceViewConsole.supplier8IngredientBefore();
                    supplyServiceViewConsole.supplierDeliveredQuantity();
                    storage.changeIngredientQuantity(Supplier.SUPPLIER_8.getIngredient(),
                            storage.getIngredientQuantity(Supplier.SUPPLIER_8.getIngredient())
                                    + scanner.nextInt());
                    supplyServiceViewConsole.supplier8IngredientAfter();
                    addChoiceQuestion();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new SupplierNumberException();
            } catch (SupplierNumberException ex) {
                ex.printStackTrace();
                addChoiceQuestion();
            }
        }
    }

    public void addChoiceQuestion() {
        supplyServiceViewConsole.chooseOtherSupplier();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }

    public int checkInt() {
        do {
            while (!scanner.hasNextInt()) {
                supplyServiceViewConsole.invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }
}
