package com.andrey.practical.task6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVHandler {

    public static void save(AppData data, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(String.join(";", data.getHeader()));
            for (int[] row : data.getData()) {
                writer.println(Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(";"))); // Убираем пробелы
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");
            List<int[]> dataList = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int[] row = Arrays.stream(parts)
                        .map(String::trim)  // Удаляет пробелы
                        .mapToInt(Integer::parseInt)
                        .toArray();
                dataList.add(row);
            }

            int[][] data = dataList.toArray(new int[0][]);
            return new AppData(header, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] header = {"Column1", "Column2", "Column3"};
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        AppData appData = new AppData(header, data);

        String filename = "data.csv";
        save(appData, filename);

        AppData loadedData = load(filename);
        if (loadedData != null) {
            System.out.println("Loaded Data:");
            System.out.println(Arrays.toString(loadedData.getHeader()));
            for (int[] row : loadedData.getData()) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
