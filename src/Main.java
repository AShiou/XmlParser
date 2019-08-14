import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Need to input one xml file name and one file name for output");
            return;
        }
        //args[0] = "/Users/shiou/IdeaProjects/xmlParser/src/test.txt";
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        Scanner sc = null;
        try {
            sc = new Scanner(inputFile);
            while (sc.hasNextLine()) {
                String oneLineData = sc.nextLine();
                String data = xmlParse(oneLineData);
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + " not exist.");
        } finally {
            sc.close();
        }

    }

    public static String xmlParse(String oneLineData) {
        String[] tokens = oneLineData.split("&[gl]t;");
        if (tokens.length < 4) return null;
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(tokens[1]);
        keyValue.append("=");
        for (int i = 2; i < tokens.length - 1; i++) {
            keyValue.append(tokens[i]);
        }
        return keyValue.toString();
    }
}
