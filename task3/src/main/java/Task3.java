import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Аргументов должно быть 2");
            return;
        }
        try (FileReader fileReader = new FileReader(args[0]);
             FileReader fileReader1 = new FileReader(args[1]);
             Writer writer = Files.newBufferedWriter(Paths.get("report.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Tests test1 = gson.fromJson(fileReader, Tests.class);
            Values values = gson.fromJson(fileReader1, Values.class);
            HashMap<Integer, String> map = new HashMap<>();
            for (int i = 0; i < values.values.size(); i++) {
                map.put(values.values.get(i).id, values.values.get(i).value);
            }
            putIn(map, test1.tests);
            gson.toJson(test1, writer);
        } catch (JsonIOException | JsonSyntaxException | NullPointerException | IOException e) {
            System.out.println("Некорректные входные данные\n" + e);
        }
    }

    static void putIn(HashMap<Integer, String> map, List<Test> testList) {
        for (Test test : testList) {
            if (map.containsKey(test.id))
                test.value = map.get(test.id);
            if (test.values != null)
                putIn(map, test.values);
        }
    }
}


