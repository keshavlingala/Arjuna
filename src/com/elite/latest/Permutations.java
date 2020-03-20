package com.elite.latest;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
    static ArrayList<String> list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        list = new ArrayList<>();
        rec(s, "");
        list.sort(String::compareTo);
        System.out.println(list);
    }

    static void rec(String s, String ans) {
        if (s.isEmpty()) {
            list.add(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            rec(s.substring(0, i) + s.substring(i + 1), ans + s.charAt(i));
        }
    }
}

/* case =1
    2 input =bacd
    3 output =abcd abdc acbd acdb adbc adcb bacd badc bcad bcda bdac bdca cabd cadb cbad cbda cdab cdba dabc dacb dbac dbca dcab dcba
    4 case =2
    5 input =AAAA
    6 output =AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA AAAA
    7
    8 case =3
    9 input =DbEcA
   10 output =ADEbc ADEcb ADbEc ADbcE ADcEb ADcbE AEDbc AEDcb AEbDc AEbcD AEcDb AEcbD AbDEc AbDcE AbEDc AbEcD AbcDE AbcED AcDEb AcDbE AcEDb AcEbD AcbDE AcbED DAEbc DAEcb DAbEc DAbcE DAcEb DAcbE DEAbc DEAcb DEbAc DEbcA DEcAb DEcbA DbAEc DbAcE DbEAc DbEcA DbcAE DbcEA DcAEb DcAbE DcEAb DcEbA DcbAE DcbEA EADbc EADcb EAbDc EAbcD EAcDb EAcbD EDAbc EDAcb EDbAc EDbcA EDcAb EDcbA EbADc EbAcD EbDAc EbDcA EbcAD EbcDA EcADb EcAbD EcDAb EcDbA EcbAD EcbDA bADEc bADcE bAEDc bAEcD bAcDE bAcED bDAEc bDAcE bDEAc bDEcA bDcAE bDcEA bEADc bEAcD bEDAc bEDcA bEcAD bEcDA bcADE bcAED bcDAE bcDEA bcEAD bcEDA cADEb cADbE cAEDb cAEbD cAbDE cAbED cDAEb cDAbE cDEAb cDEbA cDbAE cDbEA cEADb cEAbD cEDAb cEDbA cEbAD cEbDA cbADE cbAED cbDAE cbDEA cbEAD cbEDA
   11
   12 case =4
   13 input =aba
   14 output =aab aab aba aba baa baa
   15
   16 case =5
   17 input =a
   18 output =a
   19
   20 case =6
   21 input =xmaz
   22 output =amxz amzx axmz axzm azmx azxm maxz mazx mxaz mxza mzax mzxa xamz xazm xmaz xmza xzam xzma zamx zaxm zmax zmxa zxam zxma


*/