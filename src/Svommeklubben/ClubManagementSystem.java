package Svommeklubben;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClubManagementSystem {
    private static ArrayList<Member> members = new ArrayList<>();

    public static void addMember(Scanner scanner) {
        System.out.print("Enter member name: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("Enter member age: ");
        int age = scanner.nextInt();
        System.out.print("Enter membership type (active/passive): ");
        String membershipType = scanner.next();
        System.out.print("Enter swimmer type (junior/senior): ");
        String swimmerType = scanner.next();
        boolean isCompetitive = swimmerType.equalsIgnoreCase("senior");

        // Create an empty list of swim disciplines since it's not provided during member creation
        ArrayList<String> swimDisciplines = new ArrayList<>();

        // Assuming you have a Swimmer constructor that takes relevant details
        Swimmer swimmer = new Swimmer(name, age, swimDisciplines, isCompetitive, swimmerType);
        members.add(new Member(name, age, membershipType, swimmerType, isCompetitive));
        SwimClub.addSwimmer(swimmer); // Add the swimmer to the list

        System.out.println("Member added successfully!");
    }

    public static void removeMember(Scanner scanner) {
        System.out.print("Enter member name to remove: ");
        String memberName = scanner.next();

        members.removeIf(member -> member.getName().equalsIgnoreCase(memberName));
        System.out.println("Member removed successfully!");
    }

    public static void calculateAnnualMembershipFee(Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.next();

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                int annualFee = member.calculateAnnualFee();
                System.out.println("Annual Membership Fee for " + member.getName() + ": " + annualFee + " kr");
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public static void applyDiscountForSeniors(Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.next();

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName) && member.getSwimmerType().equalsIgnoreCase("senior")) {
                int annualFee = member.calculateAnnualFee();
                System.out.println("Annual Membership Fee for " + member.getName() + " (with senior discount): " +
                        annualFee + " kr");
                return;
            }
        }

        System.out.println("Member not found or is not a senior swimmer.");
    }

    public static void displayMembersInDebt() {
        System.out.println("Members in Debt:");

        for (Member member : members) {
            if (!member.hasPaid()) {
                System.out.println(member.getName());
            }
        }
    }

    public static void displayDashboard() {
        System.out.println("Displaying Dashboard:");
        System.out.println("Total Members: " + members.size());
        int activeMembers = (int) members.stream().filter(member -> member.getMembershipType().equalsIgnoreCase("active")).count();
        int passiveMembers = (int) members.stream().filter(member -> member.getMembershipType().equalsIgnoreCase("passive")).count();
        System.out.println("Active Members: " + activeMembers);
        System.out.println("Passive Members: " + passiveMembers);
    }

    public static void registerPayment(Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.next();

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                member.setHasPaid(true);
                System.out.println("Payment registered successfully for " + member.getName());
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public static void checkPaymentStatus(Scanner scanner) {
        System.out.print("Enter member name: ");
        String memberName = scanner.next();

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                if (member.hasPaid()) {
                    System.out.println(member.getName() + " has paid the membership fee.");
                } else {
                    System.out.println(member.getName() + " has not paid the membership fee.");
                }
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public static void addSwimmerToCompetitiveStatus(Scanner scanner) {
        System.out.print("Enter swimmer name to add to competitive status: ");
        String swimmerName = scanner.next();
        scanner.nextLine(); // Consume the newline character

        for (Swimmer swimmer : SwimClub.swimmers) {
            if (swimmer.getName().equalsIgnoreCase(swimmerName.trim())) {
                // Assuming that the swimmer class has a method for setting competitive status
                swimmer.setCompetetive(true);
                System.out.println(swimmer.getName() + " is now a competitive swimmer.");
                return;
            }
        }

        System.out.println("Swimmer not found.");
    }

    public static void removeSwimmerFromCompetitiveStatus(Scanner scanner) {
        System.out.print("Enter swimmer name to remove from competitive status: ");
        String swimmerName = scanner.next();

        for (Swimmer swimmer : SwimClub.swimmers) {
            if (swimmer.getName().equalsIgnoreCase(swimmerName.trim())) {
                // Assuming that the swimmer class has a method for setting competitive status
                swimmer.setCompetetive(false);
                System.out.println(swimmer.getName() + " is no longer a competitive swimmer.");
                return;
            }
        }

        System.out.println("Swimmer not found.");
    }

    public static void viewCompetitiveSwimmers() {
        System.out.println("Competitive Swimmers:");

        for (Swimmer swimmer : SwimClub.swimmers) {
            if (swimmer.isCompetetive()) {
                System.out.println(swimmer.getName());
            }
        }
    }

    public static void recordSwimDisciplines() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter swimmer name: ");
        String swimmerName = scanner.next();

        for (Swimmer swimmer : SwimClub.swimmers) {
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

        for (Swimmer swimmer : SwimClub.swimmers) {
            if (swimmer.getName().equals(swimmerName) && swimmer.isCompetetive()) {
                System.out.print("Enter stævne: ");
                String stævne = scanner.next();
                System.out.print("Enter placering: ");
                int placering = scanner.nextInt();
                System.out.print("Enter tid (in seconds): ");
                int tid = scanner.nextInt();

                SwimClub.results.add(new CompetitionResult(stævne, tid));
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
        for (Swimmer swimmer : SwimClub.swimmers) {
            System.out.println("Name: " + swimmer.getName() + ", Age: " + swimmer.getAge() +
                    ", Competitive: " + swimmer.isCompetetive());
        }

        // Display competition results
        System.out.println("\nCompetition Results:");
        for (CompetitionResult result : SwimClub.results) {
            System.out.println("Stævne: " + result.getDiscipline() + ", Tid: " + result.getTime() + " seconds");
        }
    }
}