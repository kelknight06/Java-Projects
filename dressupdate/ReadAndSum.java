package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: this is a generic class to read a file. it also utilizes an upper bounded wildcard method to recursively find the sum of a list
//list is imported from collections which is a generic interface
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.io.IOException;

public class ReadAndSum<T> {
    private final String filePath;
    //Function is a built-in functional interface. linemapper is transforming raw input string to
    //an object
    private final Function<String, T> lineMapper;

    public ReadAndSum(String filePath, Function<String, T> lineMapper) {
        this.filePath = filePath;
        this.lineMapper = lineMapper;
    }
    //a generic method to process line reading and return what was read from the file
    public List<T> readAllLines() throws IOException {
        List<T> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(lineMapper.apply(line));
            }
        }
        return data;
    }
    //calling the recursive sum list, it is wildcard upper bounded
    public static double sumListRecursive(List<? extends Number> list) {
        return sumListRecursiveHelper(list, 0);
    }
    //the actual recursive method that is wildcard upper bounded
    private static double sumListRecursiveHelper(List<? extends Number> list, int index) {
        if (index == list.size()) {
            return 0.0;
        }
        return list.get(index).doubleValue() + sumListRecursiveHelper(list, index + 1);
    }
}