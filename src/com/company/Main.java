package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// определение действия при завершении программы
        mainWindow.setSize(800, 600); // размеры окна (ширина, высота)
        mainWindow.setVisible(true); // сделать окно видимым
    }
}
