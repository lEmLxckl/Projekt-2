package Svommeklubben;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<CompetitionResult> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Member");
            System.out.println("2. Remove Member");
            System.out.println("3. Calculate Annual Membership Fee");
            System.out.println("4. Apply Discount for Seniors");
            System.out.println("5. Display Members in Debt");
            System.out.println("6. Display Dashboard");
            System.out.println("7. Register Payment");
            System.out.println("8. Check Payment Status");
            System.out.println("9. Display Top 5 Swimmers");
            System.out.println("10. Manage Swimmers");
            System.out.println("11. Record Swim Disciplines");
            System.out.println("12. Enter Competition Details");
            System.out.println("13. Generate Report");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("\n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ClubManagementSystem.addMember(scanner);
                    scanner.nextLine();

                    break;
                case 2:
                    ClubManagementSystem.removeMember(scanner);
                    scanner.nextLine();
                    break;
                case 3:
                    ClubManagementSystem.calculateAnnualMembershipFee(scanner);
                    scanner.nextLine();
                    break;
                case 4:
                    ClubManagementSystem.applyDiscountForSeniors(scanner);
                    scanner.nextLine();
                    break;
                case 5:
                    ClubManagementSystem.displayMembersInDebt();
                    scanner.nextLine();
                    break;
                case 6:
                    ClubManagementSystem.displayDashboard();
                    scanner.nextLine();
                    break;
                case 7:
                    ClubManagementSystem.registerPayment(scanner);
                    scanner.nextLine();
                    break;
                case 8:
                    ClubManagementSystem.checkPaymentStatus(scanner);
                    scanner.nextLine();
                    break;
                case 9:
                    SwimClub.displayTopSwimmers();
                    scanner.nextLine();
                    break;
                case 10:
                    SwimClub.manageSwimmers();
                    scanner.nextLine();
                    break;
                case 11:
                    SwimClub.recordSwimDisciplines();
                    scanner.nextLine();
                    break;
                case 12:
                    SwimClub.enterCompetitionDetails();
                    scanner.nextLine();
                    break;
                case 13:
                    SwimClub.generateReport();
                    scanner.nextLine();
                    break;
                case 14:
                    System.out.println("Exiting program. Bye!");
                    System.exit(0);
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
