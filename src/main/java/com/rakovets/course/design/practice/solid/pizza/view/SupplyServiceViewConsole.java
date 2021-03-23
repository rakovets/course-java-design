package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Supplier;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;

public class SupplyServiceViewConsole implements SupplyServiceView {
    private static final StorageRepository storageRepository;

    static {
        storageRepository = new StorageRepository();
    }

    public void suppliersMenu() {
        System.out.println("Choose supplier from which you got delivery:");
        System.out.println("1. Supplier_1");
        System.out.println("2. Supplier_2");
        System.out.println("3. Supplier_3");
        System.out.println("4. Supplier_4");
        System.out.println("5. Supplier_5");
        System.out.println("6. Supplier_6");
        System.out.println("7. Supplier_7");
        System.out.println("8. Supplier_8");
    }

    public void supplierDeliveredQuantity() {
        System.out.println("Enter delivered quantity of ingredients from supplier");
    }

    public void supplier1IngredientBefore() {
        System.out.println("SUPPLIER_1 delivered " + Supplier.SUPPLIER_1.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_1.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_1.getIngredient()));
    }

    public void supplier1IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_1.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_1.getIngredient()));
    }

    public void supplier2IngredientBefore() {
        System.out.println("SUPPLIER_2 delivered " + Supplier.SUPPLIER_2.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_2.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_2.getIngredient()));
    }

    public void supplier2IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_2.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_2.getIngredient()));
    }

    public void supplier3IngredientBefore() {
        System.out.println("SUPPLIER_3 delivered " + Supplier.SUPPLIER_3.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_3.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_3.getIngredient()));
    }

    public void supplier3IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_3.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_3.getIngredient()));
    }

    public void supplier4IngredientBefore() {
        System.out.println("SUPPLIER_4 delivered " + Supplier.SUPPLIER_4.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_4.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_4.getIngredient()));
    }

    public void supplier4IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_4.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_4.getIngredient()));
    }

    public void supplier5IngredientBefore() {
        System.out.println("SUPPLIER_5 delivered " + Supplier.SUPPLIER_5.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_5.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_5.getIngredient()));
    }

    public void supplier5IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_5.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_5.getIngredient()));
    }

    public void supplier6IngredientBefore() {
        System.out.println("SUPPLIER_6 delivered " + Supplier.SUPPLIER_6.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_6.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_6.getIngredient()));
    }

    public void supplier6IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_6.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_6.getIngredient()));
    }

    public void supplier7IngredientBefore() {
        System.out.println("SUPPLIER_7 delivered " + Supplier.SUPPLIER_7.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_7.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_7.getIngredient()));
    }

    public void supplier7IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_7.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_7.getIngredient()));
    }

    public void supplier8IngredientBefore() {
        System.out.println("SUPPLIER_8 delivered " + Supplier.SUPPLIER_8.getIngredient());
        System.out.println("Current quantity of " + Supplier.SUPPLIER_8.getIngredient() + " in storage: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_8.getIngredient()));
    }

    public void supplier8IngredientAfter() {
        System.out.println("Quantity of " + Supplier.SUPPLIER_8.getIngredient() + " has been changed to: "
                + storageRepository.getIngredientQuantity(Supplier.SUPPLIER_8.getIngredient()));
    }

    public void chooseOtherSupplier() {
        System.out.println("\nDo you want to choose another supplier? (Type y or n)");
    }

    public void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }
}
