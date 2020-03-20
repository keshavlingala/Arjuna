package com.DAA;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class FileMerge {
    public static void main(String[] args) {
        List<String> file1;
        List<String> file2;
        List<String> file3;
        try {
            file1 = Files.readAllLines(Paths.get("C:\\Favorites\\Arjuna\\src\\com\\DAA\\file1.txt"));
            file2 = Files.readAllLines(Paths.get("C:\\Favorites\\Arjuna\\src\\com\\DAA\\file2.txt"));
            file3 = Files.readAllLines(Paths.get("C:\\Favorites\\Arjuna\\src\\com\\DAA\\file3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            file1 = file2 = file3 = null;
            System.out.println("Error Reading File");
            return;
        }
        List<Emp> c1 = new ArrayList<>();
        List<Emp> c2 = new ArrayList<>();
        List<Emp> c3 = new ArrayList<>();
        file1.forEach(line -> {
            String[] data = line.split(",");
            c1.add(new Emp(data[0], data[1], data[2]));
        });
        file2.forEach(line -> {
            String[] data = line.split(",");
            c2.add(new Emp(data[0], data[1], data[2]));
        });

        file3.forEach(line -> {
            String[] data = line.split(",");
            c3.add(new Emp(data[0], data[1], data[2]));
        });


        List<Emp> r1 = merge(c1, c2);
        List<Emp> result = merge(r1, c3);
        for (Emp e : result) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSal());
        }
    }

    private static List<Emp> merge(List<Emp> file1, List<Emp> file2) {
        List<Emp> result = new ArrayList<>();
        int fp1 = 0, fp2 = 0;
        while (fp1 < file1.size() && fp2 < file2.size()) {
            if (file1.get(fp1).getId() <= file2.get(fp2).getId()) {
                result.add(file1.get(fp1++));
            } else {
                result.add(file2.get(fp2++));
            }
        }
        if (fp1 == file1.size()) {
            result.addAll(file2.subList(fp2, file2.size()));
        } else if (fp2 == file2.size()) {
            result.addAll(file1.subList(fp1, file1.size()));
        }
        return result;
    }
}

class Emp {
    private String name;
    private int id;
    private float sal;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sal='" + sal + '\'' +
                '}';
    }

    Emp(String id, String name, String sal) {
        this.name = name;
        this.id = Integer.parseInt(id.trim());
        this.sal = Float.parseFloat(sal);
    }

    String getName() {
        return name;
    }

    int getId() {
        return id;
    }

    float getSal() {
        return sal;
    }
}

