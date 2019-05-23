import by.gsu.pms.Race;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        Race[] races = new Race[]{
                new Race("2008/05/20", 15, true),
                new Race("2008/08/15", 10, true),
                new Race("2008/03/17", 25, false),
                new Race("2008/01/16", 15),
                new Race("2008/02/18", 5, false),
                new Race("2009/08/23", 15, true),
                new Race("2009/11/25", 25, false),
                new Race("2009/10/19", 35, false),
                new Race("2009/09/20", 25, false),
                new Race("2009/04/28", 15)
        };

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
