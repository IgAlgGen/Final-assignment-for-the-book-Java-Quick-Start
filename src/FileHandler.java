import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList<>();
        String lineRead;
        String[] spliteLine;
        Member mem = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                spliteLine = lineRead.split(", ");
                if (spliteLine[0].equals("S")) {
                    mem = new SingleClubMember('S',
                            Integer.parseInt(spliteLine[1]),
                            spliteLine[2],
                            Double.parseDouble(spliteLine[3]),
                            Integer.parseInt(spliteLine[4]));
                } else if (spliteLine[0].equals("M")) {
                    mem = new MultiClumMember('M',
                            Integer.parseInt(spliteLine[1]),
                            spliteLine[2],
                            Double.parseDouble(spliteLine[3]),
                            Integer.parseInt(spliteLine[4]));

                }

                m.add(mem);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return m;

    }

    public void appendFile(String mem) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("members.csv", true))) {
            bufferedWriter.write(mem + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //overWriteFile();
}
