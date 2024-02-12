import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        String mem;
        MembershipManagment mm = new MembershipManagment();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();

        while (choice!= -1){
            switch (choice){
                case 1:
                    mem = mm.addMembers(members);
                    fh.appendFile(mem);
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overWriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("\nВы выбрали недопуситмое значение");
                    break;
            }
            choice=mm.getChoice();
        }
        System.out.println("\nGood bye");
    }
}
