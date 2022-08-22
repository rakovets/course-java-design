package com.rakovets.course.design.practice.solid;

import com.rakovets.course.design.practice.solid.service.view.MainViewer;
import com.rakovets.course.design.practice.solid.service.view.impl.MainViewerImpl;

public class Main {
    public static void main(String[] args) {
        MainViewer mainViewer = new MainViewerImpl();

        String operation = mainViewer.showMenu();
        System.out.println(operation);

        operation = mainViewer.chooseOperation();
        System.out.println(operation);
    }
}
