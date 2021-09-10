package Tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CAndD {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Arguments Required ");
            System.out.println("HOW to USE");
            System.out.println("java CAndD [mode] [fileName]");
            System.out.println("Example $java CAndD compress sample.txt ");
            System.out.println("Example $java CAndD decompress sample.cmp ");
            System.out.println("Alias compress | c");
            System.out.println("Alias decompress | d");
        }
        String mode = args[0].toLowerCase();
        System.out.println(mode);
        String filePath = args[1];
        String output;
        if (args.length > 2) {
            output = args[2];
        } else {
            output = filePath;
        }

        switch (mode) {
            case "compress":
            case "c":
                System.out.println(compressFile(filePath, output));
                break;
            case "decompress":
            case "d":
                System.out.println(decompressFile(filePath, output));
        }

    }

    static String decompressFile(String originalFilePath, String output) {
        String fileName = output;
        try {
            FileInputStream fis = new FileInputStream(fileName + ".cmp");
            FileOutputStream fos = new FileOutputStream(fileName);
            InflaterInputStream iis = new InflaterInputStream(fis);
            int data;
            while ((data = iis.read()) != -1) {
                fos.write(data);
            }
            fos.close();
            iis.close();
        } catch (IOException e) {
            return "Decompression Failed Error: " + e.getMessage();
        }
        return "Decompression Success";
    }

    static String compressFile(String originalFilePath, String output) {
        String fileName = output + ".cmp";
        try {
            FileInputStream fis = new FileInputStream(originalFilePath);
            FileOutputStream fos = new FileOutputStream("compress-" + fileName + ".cmp");
            DeflaterOutputStream dos = new DeflaterOutputStream(fos);
            int data;
            while ((data = fis.read()) != -1) {
                dos.write(data);
            }
            fis.close();
            dos.close();
        } catch (IOException e) {
            return "Compression Failed Error: " + e.getMessage();
        }
        return "Compression Success";
    }

}
