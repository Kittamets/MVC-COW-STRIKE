package CONTROLLER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadController {
    public static String[] findCow(String data) {
        String filePath = "MODEL\\cow.csv";
        String line = "";
        String delimiter = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (String value : values) {
                    if (value.equals(data)) {
                        return values;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void writeCSV(String cowID, String[] newData) {
        String filePath = "MODEL\\cow.csv";
        String line = "";
        String delimiter = ",";
        List<String[]> allRows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values[0].equals(cowID)) {
                    allRows.add(newData);
                } else {
                    allRows.add(values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : allRows) {
                bw.write(String.join(delimiter, row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
