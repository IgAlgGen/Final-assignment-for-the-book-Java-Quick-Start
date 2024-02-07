import java.util.LinkedList;
import java.io.*;
public class FileHandler {

    public LinkedList<Member> readFile(){
        LinkedList<Member> m = new LinkedList<>();
        String lineRead;
        String[] spliteLine;
        Member mem = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))){
            lineRead = reader.readLine();
            while (lineRead!=null){
                spliteLine = lineRead.split(" ");
                if(spliteLine[0].equals("S")){
                    mem = new SingleClubMember('S',
                            Integer.parseInt(spliteLine[1]),
                            spliteLine[2],
                            Double.parseDouble(spliteLine[3]),
                            Integer.parseInt(spliteLine[4]));
                } else if (spliteLine[0].equals("M")) {
                    mem=new MultiClumMember('M',
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
    };
    appendFile();
    overWriteFile();
}
