package Svommeklubben;
import java.util.ArrayList;

public class Swimmer {
        private String name;
        private int age;
        public ArrayList<String> swimDisciplines;
        private ArrayList<Integer> trainingResults;
        public boolean isCompetetive;


        public Swimmer(String name, int age, ArrayList<String> swimDisciplines, boolean isCompetetive, String swimmerType) {
            this.name = name;
            this.age = age;
            this.swimDisciplines = swimDisciplines;
            this.trainingResults = new ArrayList<>();
            this.isCompetetive = false;
        }

    public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public ArrayList<String> getSwimDisciplines() {
            return swimDisciplines;
        }

        public ArrayList<Integer> getTrainingResults() {
            return trainingResults;
        }

        public void setSwimDisciplines(ArrayList<String> swimDisciplines) {
            this.swimDisciplines = swimDisciplines;
        }

    public boolean isCompetetive() {
        return false;
    }

    public void setCompetetive(boolean competetive) {
        isCompetetive = competetive;
    }
}