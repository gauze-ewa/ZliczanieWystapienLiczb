import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFile;

        System.out.println("Witaj w programie!");
        System.out.println("Podaj nazwę plku jaki chcesz storzyć:");
        nameFile = br.readLine();
        CreatorFile creatorFile = new CreatorFile(nameFile);
        creatorFile.setFileName(nameFile);
        creatorFile.createFile();
        creatorFile.addToFile();
        creatorFile.readThisFile();
        ListClass listClass=new ListClass();
        List<String>list=new ArrayList<>();
        listClass.setList(list);
        listClass.addToYourlist(creatorFile);
        listClass.countingRepetion(creatorFile);


    }
}
