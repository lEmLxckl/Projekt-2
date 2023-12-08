package Svommeklubben;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class SwimClub {
    static ArrayList<Swimmer> swimmers = new ArrayList<>();
    static ArrayList<CompetitionResult> results = new ArrayList<>();

    // ... (other methods)

    private static ArrayList<String> getDistinctDisciplines(ArrayList<CompetitionResult> results) {
        ArrayList<String> distinctDisciplines = new ArrayList<>();

        for (CompetitionResult result : results) {
            if (!distinctDisciplines.contains(result.getDiscipline())) {
                distinctDisciplines.add(result.getDiscipline());
            }
        }

        return distinctDisciplines;
    }

    private static ArrayList<CompetitionResult> getResultsByDiscipline(ArrayList<CompetitionResult> results, String discipline) {
        ArrayList<CompetitionResult> disciplineResults = new ArrayList<>();

        for (CompetitionResult result : results) {
            if (result.getDiscipline().equals(discipline)) {
                disciplineResults.add(result);
            }
        }

        return disciplineResults;
    }

    public static void displayTopSwimmers() {
        for (String discipline : getDistinctDisciplines(results)) {
            ArrayList<CompetitionResult> disciplineResults = getResultsByDiscipline(results, discipline);
            Collections.sort(disciplineResults, Comparator.comparingInt(CompetitionResult::getTime));

            System.out.println("Top 5 Swimmers in " + discipline + ":");
            int count = Math.min(5, disciplineResults.size());
            for (int i = 0; i < count; i++) {
                CompetitionResult result = disciplineResults.get(i);
                System.out.println((i + 1) + ". " + result.getTime() + " seconds");
            }
            System.out.println();
        }
    }
        public static void manageSwimmers() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Managing Swimmers:");
            System.out.println("1. Add Swimmer to Competitive Status\n2. Remove Swimmer from Competitive Status\n" +
                    "3. View Competitive Swimmers\n4. Go Back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSwimmerToCompetitiveStatus(scanner);
                    scanner.nextLine();
                    break;
                case 2:
                    removeSwimmerFromCompetitiveStatus(scanner);
                    scanner.nextLine();
                    break;
                case 3:
                    viewCompetitiveSwimmers();
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Returning to main menu.");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid choice. Returning to main menu.");
            }
        }

    private static void addSwimmerToCompetitiveStatus(Scanner scanner) {
        System.out.print("Enter swimmer name to add to competitive status: ");
        String swimmerName = scanner.next();
        scanner.nextLine(); // Consume the newline character

        for (Swimmer swimmer : swimmers) {
            if (swimmer.getName().equalsIgnoreCase(swimmerName.trim())) {
                // Assuming that the swimmer class has a method for setting competitive status
                swimmer.setCompetetive(true);
                System.out.println(swimmer.getName() + " is now a competitive swimmer.");
                return;
            }
        }

        System.out.println("Swimmer not found.");
    }

        private static void removeSwimmerFromCompetitiveStatus(Scanner scanner) {
            System.out.print("Enter swimmer name to remove from competitive status: ");
            String swimmerName = scanner.next();

            for (Swimmer swimmer : swimmers) {
                if (swimmer.getName().equals(swimmerName)) {
                    // Assuming that the swimmer class has a method for setting competitive status
                    swimmer.setCompetetive(false);
                    System.out.println(swimmer.getName() + " is no longer a competitive swimmer.");
                    return;
                }
            }

            System.out.println("Swimmer not found.");
        }

        private static void viewCompetitiveSwimmers() {
            System.out.println("Competitive Swimmers:");

            for (Swimmer swimmer : swimmers) {
                if (swimmer.isCompetetive()) {
                    System.out.println(swimmer.getName());
                }
            }
        }

        public static void recordSwimDisciplines() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter swimmer name: ");
            String swimmerName = scanner.next();

            for (Swimmer swimmer : swimmers) {
                if (swimmer.getName().equals(swimmerName) && swimmer.isCompetetive()) {
                    System.out.print("Enter swim disciplines (comma-separated): ");
                    String disciplinesInput = scanner.next();
                    String[] disciplines = disciplinesInput.split(",");

                    // Assuming that the swimmer class has a method for setting swim disciplines
                    swimmer.setSwimDisciplines(new ArrayList<>(Arrays.asList(disciplines)));
                    System.out.println("Swim disciplines recorded successfully.");
                    return;
                }
            }

            System.out.println("Swimmer not found or is not a competitive swimmer.");
        }

        public static void enterCompetitionDetails() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter swimmer name: ");
            String swimmerName = scanner.next();

            for (Swimmer swimmer : swimmers) {
                if (swimmer.getName().equals(swimmerName) && swimmer.isCompetetive()) {
                    System.out.print("Enter stævne: ");
                    String stævne = scanner.next();
                    System.out.print("Enter placering: ");
                    int placering = scanner.nextInt();
                    System.out.print("Enter tid (in seconds): ");
                    int tid = scanner.nextInt();

                    results.add(new CompetitionResult(stævne, tid));
                    System.out.println("Competition details recorded successfully.");
                    return;
                }
            }

            System.out.println("Swimmer not found or is not a competitive swimmer.");
        }

        public static void generateReport() {
            System.out.println("Generating Report:");
            // Display swimmer information
            System.out.println("Swimmers:");
            for (Swimmer swimmer : swimmers) {
                System.out.println("Name: " + swimmer.getName() + ", Age: " + swimmer.getAge() +
                        ", Competitive: " + swimmer.isCompetetive());
            }

            // Display competition results
            System.out.println("\nCompetition Results:");
            for (CompetitionResult result : results) {
                System.out.println("Stævne: " + result.getDiscipline() + ", Tid: " + result.getTime() + " seconds");
            }

        }
    public static void addSwimmer(Swimmer swimmer) {
        swimmers.add(swimmer);
    }    }