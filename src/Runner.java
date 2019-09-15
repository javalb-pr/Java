import by.gsu.pms.Race;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 3;
        final String FILE_NAME = "race.dat";

        Race[] races = new Race[ARRAY_SIZE];

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)); Scanner in = new Scanner(System.in)){
            int i = 0;
            while (i < ARRAY_SIZE){
                try {
                    System.out.print("Input object params date->number->prize:\n");

                    String date = in.next();
                    int count = in.nextInt();
                    boolean prize = in.nextBoolean();

                    oos.writeObject(new Race(date, count, prize));
                    i++;
                }catch (InputMismatchException ex){
                    System.out.println("Invalid value rewrite last parameter!");
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            for (int i = 0; i < ARRAY_SIZE; i++){
                races[i] = (Race) ois.readObject();
            }
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

        show(races);

        int racersCounter = 0;
        int prizeCounter = 0;
        for (Race race : races){
            racersCounter += race.getNumberOfRacers();
            if (race.isPrize()){
                prizeCounter++;
            }
        }

        System.out.println("Races with prize : "+prizeCounter);
        show(races);
        System.out.println("Number of races : "+racersCounter);
        show(races);
    }
    private static void show(Race[] races){
        Arrays.sort(races, new Comparator<Race>() {
            @Override
            public int compare(Race o1, Race o2) {
                int strComp = o1.getDate().compareTo(o2.getDate());
                if (strComp != 0){
                    return strComp;
                }
                return o1.getNumberOfRacers() - o2.getNumberOfRacers();
            }
        });

        for (Race race : races){
            System.out.println(race);
        }
    }
}
