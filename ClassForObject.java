package com.company;

import java.util.Scanner;

public class ClassForObject {
    private SW str = new SW();
    public void consoleInput(){
        System.out.println("Введите данные ");
        str.inputLine(new Scanner(System.in).nextLine());
    }
    public void dataStream(String fileName)throws Exception{
        ClassTextFile obj = new ClassTextFile(fileName);
        str = obj.getText();
    }
    public SW getObject(){
        return str;
    }
}
