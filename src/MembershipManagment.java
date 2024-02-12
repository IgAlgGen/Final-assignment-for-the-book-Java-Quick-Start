import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagment {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            try {
                choice = reader.nextInt();
                if (choice == 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: INVALID INPUT. Please try again:");
                reader.nextLine();
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println("WELCOME TO OZONE FITNESS CENTRE");
        System.out.println("===============================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("Please select an option (or Enter -1 to quit):");

        return getIntInput();
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("Введите имя посетителя");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();


        printClubOptions();
        System.out.println("Введите клуб посетителя");
        club = getIntInput();

        while (club < 1 || club > 4) {
            System.out.println("Invalid ClubID. Please try again");
            club = getIntInput();
        }
        if (!m.isEmpty()) {
            memberID = m.getLast().getMemberId() + 1;
        } else {
            memberID = 1;
        }
        if (club != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);

            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("STATUS: Single Club Member added");
        } else {
            // Добавление посетителя нескольких клубов
            cal = (n) -> {
                if (n == 4) {
                    return 1200;
                } else {
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClumMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("STATUS: Multi Club Member added");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.println("Введите ID пользователя");
        memberID = getIntInput();
        for (Member member : m) {
            if (member.getMemberId() == memberID) {
                m.remove(memberID);
                System.out.println("Пользователь с ID " + memberID + " удален");
                return;
            }
        }
        System.out.println("Пользователя с таким ID нет");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberId;
        System.out.println("Введите ID пользователя");
        memberId = getIntInput();
        for (Member member : m) {
            if (member.getMemberId() == memberId) {
                String[] memberInfo = m.get(memberId).toString().split(", ");
                System.out.println("Member Type = " + memberInfo[0]);
                System.out.println("Member ID = " + memberInfo[1]);
                System.out.println("Member name = " + memberInfo[2]);
                System.out.println("Membership Fees = " + memberInfo[3]);
                if (memberInfo[0].equals("S")) {
                    System.out.println("Club ID = " + memberInfo[4]);
                } else {
                    System.out.println("Membership points = " + memberInfo[4]);
                }
                return;
            }
        }
        System.out.println("\nПользователь не найден.");
    }
}
