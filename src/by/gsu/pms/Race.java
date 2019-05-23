package by.gsu.pms;

public class Race {
    private String date;
    private int numberOfRacers;
    private boolean prize;

    public Race(String date, int numberOfRacers, boolean prize) {
        this.date = date;
        this.numberOfRacers = numberOfRacers;
        this.prize = prize;
    }
    public Race(String date, int numberOfRacers){
        this.date = date;
        this.numberOfRacers = numberOfRacers;
        this.prize = true;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfRacers() {
        return numberOfRacers;
    }

    public void setNumberOfRacers(int numberOfRacers) {
        this.numberOfRacers = numberOfRacers;
    }

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return date+";"+numberOfRacers+";"+prize;
    }
}
