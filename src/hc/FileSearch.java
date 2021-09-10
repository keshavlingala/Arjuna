package hc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileSearch {
    public static void main(String[] args) throws IOException {
        File f1 = new File("/Users/keshav/Favs/CPStuff/Python/payment/datalist");
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        Pattern p = Pattern.compile("Mahmoud Seyyed|Seyyed Mahmoud");
        while ((s = br.readLine()) != null) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                System.out.println("Matched : " + m.toString());
            }
        }
    }
    static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }
}
