import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListClass {
    private CreatorFile creatorFile;
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void addToYourlist(CreatorFile file) {
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(file.getFileName());
            reader = new BufferedReader(fileReader);
            String lines;
            while ((lines = reader.readLine()) != null) {
                list.add(lines);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countingRepetion(CreatorFile file) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
                    String repetion = list.get(i);
                    int frequency = Collections.frequency(list, list.get(i));
                    System.out.println(repetion + "- liczba wystąpień: " + frequency);
                    list.remove(list.get(i));
        }
    }
}
