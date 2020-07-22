import java.io.*;
import java.lang.reflect.AnnotatedElement;

public class CreatorFile {
    private String fileName;

    public CreatorFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void createFile() {
        setFileName(getFileName()+".txt");
        File file = new File(getFileName());
        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku!");
            }
        }
    }


    public void readThisFile() throws FileNotFoundException {
        var fileReader = new FileReader(fileName);
        var reader = new BufferedReader(fileReader);

        try (fileReader;
             reader;) {
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addToFile() {
        System.out.println("Podaj liczby jakie chcesz wgrać do pliku. " +
                "Program zakoncczy wczytywanie jak podasz zero");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (var fileWriter = new FileWriter(fileName);
             var writer = new BufferedWriter(fileWriter);) {
            int a = -1;
            String b;

            while (a != 0) {
                a = Integer.parseInt(br.readLine());
                b=Integer.toString(a);
                writer.write(b);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Nie udało się zapisać pliku " + fileName);
        }
    }

}
