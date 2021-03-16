package com.rakovets.course.design.practice.solid.pizza.view;

public class SupplyServiceViewConsole implements SupplyServiceView {

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
}
