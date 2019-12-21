package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassSerialization {
    private String fileName;
    ArrayList<SW> objects;

    public ClassSerialization(String str){
        fileName = str;
        objects = new ArrayList<SW>();
    }
    public void writeOneObject(SW obj)throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(obj);
        out.close();
    }
    public SW readObeObject()throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        SW x = (SW) in.readObject();
        in.close();
        return x;
    }
    public void majeCollection() throws Exception{
        Scanner in = new Scanner(System.in);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true));
        SW o;
        System.out.println("Введите количество объектов: ");
        int count = in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; i++){
            System.out.println("Введите строку для объекта №" + (i + 1));
            o = new SW();
            o.inputLine(in.nextLine());
            objects.add(o);
            out.writeObject(o);
        }
        out.close();
    }
    public void readCollection() throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        ArrayList<SW> arr = new ArrayList<SW>();
        try{
            while(true){
                arr.add((SW)in.readObject());
            }
        }
        catch (Exception e){}
        objects = arr;
    }
    public ArrayList<SW> getCollection(){return objects;}
}
