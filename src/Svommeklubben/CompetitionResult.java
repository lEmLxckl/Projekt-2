package Svommeklubben;

import java.util.ArrayList;

public class CompetitionResult {
    private String discipline;
    private int time; // Assuming time is represented in seconds

    public CompetitionResult(String discipline, int time) {
        this.discipline = discipline;
        this.time = time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getTime() {
        return time;
    }
}
