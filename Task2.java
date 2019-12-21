package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void save(String fileName)throws Exception{
        Scanner in = new Scanner(System.in);
        int count, excoursionNumber, price;
        String tourName, country, city, accommodations, hotelName, dateIn, dateOut, companyName;

        File file = new File(fileName);
        if(file.exists())
            System.out.println("Файл " + fileName + " уже существует");
        else {
            file.createNewFile();
            System.out.println("Файл " + fileName + " был создан");
        }

        DataOutputStream out = new DataOutputStream((new FileOutputStream(file, true)));
        System.out.println("Введите количество туров:");
        //count = 0;
        count = in.nextInt();
        in.nextLine();
        for(int i = 0; i < count; i++){
            System.out.println("Введите нвименование тура №" + (i + 1));
            tourName = in.nextLine();
            System.out.println("Введите страну тура №" + (i + 1));
            country = in.nextLine();
            System.out.println("Введите город тура №" + (i + 1));
            city = in.nextLine();
            System.out.println("Введите условия проживания рождения тура №" + (i + 1));
            accommodations = in.nextLine();
            System.out.println("Введите название отеля тура №" + (i + 1));
            hotelName = in.nextLine();
            System.out.println("Введите дату прибытия тура №" + (i + 1));
            dateIn = in.nextLine();
            System.out.println("Введите дату отправления тура №" + (i + 1));
            dateOut = in.nextLine();
            System.out.println("Введите количество экскурсий тура №" + (i + 1));
            excoursionNumber = in.nextInt();
            System.out.println("Введите стоимость тура №" + (i + 1));
            price = in.nextInt();
            in.nextLine();
            System.out.println("Введите название компании тура №" + (i + 1));
            companyName = in.nextLine();
            out.writeUTF(tourName);
            out.writeUTF(country);
            out.writeUTF(city);
            out.writeUTF(accommodations);
            out.writeUTF(hotelName);
            out.writeUTF(dateIn);
            out.writeUTF(dateOut);
            out.writeInt(excoursionNumber);
            out.writeInt(price);
            out.writeUTF(companyName);
        }
        out.close();
    }
    public static ArrayList<Tour> load(String filename){
        ArrayList<Tour> tours = new ArrayList<Tour>();
        try{
            DataInputStream in = new DataInputStream(new FileInputStream(filename));
            while (true) {
                tours.add(new Tour(in.readUTF(), in.readUTF(),in.readUTF(), in.readUTF(), in.readUTF(),
                        in.readUTF(), in.readUTF(), in.readInt(), in.readInt(),in.readUTF()));
                //System.out.println("iteration");
            }
        }
        catch (Exception e){
            //System.out.println(e);
        }
        System.out.println("Введите название компании список которой хотите получить");
        return Tour.getOneCompany(tours, new Scanner(System.in).nextLine());
    }
    public static ArrayList<Tour> randomAccess(ArrayList<Tour> tours)throws Exception{
        RandomAccessFile rf = new RandomAccessFile("FileForRandomAccess.txt", "rw");
        int buf = tours.size();
        for(Tour tour: tours){
            tour.increase();
            rf.writeUTF(tour.getTourName());
            rf.writeUTF(tour.getCountry());
            rf.writeUTF(tour.getCity());
            rf.writeUTF(tour.getAccommodations());
            rf.writeUTF(tour.getHotelName());
            rf.writeUTF(tour.getDateIn());
            rf.writeUTF(tour.getDateOut());
            rf.writeInt(tour.getExcoursionNumber());
            rf.writeInt(tour.getPrice());
            rf.writeUTF(tour.getCompanyName());
        }
        tours.clear();
        rf.seek(0);
        for(int i = 0; i < buf; i++){
            tours.add(new Tour(rf.readUTF(), rf.readUTF(),rf.readUTF(), rf.readUTF(), rf.readUTF(),
                    rf.readUTF(), rf.readUTF(), rf.readInt(), rf.readInt(),rf.readUTF()));
        }
        System.out.println("Введите номер тура цену которого хотите увеличить(0 <= номер < " + tours.size() + ")");
        return Tour.upPrise(tours, new Scanner(System.in).nextInt());
    }


}
