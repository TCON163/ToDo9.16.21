package utils;

import models.ToDoItem;

public class PrintView {
    public static void printMyView(int i , ToDoItem obj) {
        System.out.print((i+1) + ") [" );
        if (obj.isComplete()) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
        System.out.println("] " + obj.getToDoText());
    }
}
