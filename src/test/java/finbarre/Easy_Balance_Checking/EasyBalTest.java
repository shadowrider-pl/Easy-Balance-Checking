package finbarre.Easy_Balance_Checking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EasyBalTest {

    String b1 = "1000.00!=\n125 Market !=:125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10";
    String b1sol = "Original Balance: 1000.00\\r\\n125 Market 125.45 Balance 874.55\\r\\n126 Hardware 34.95 Balance 839.60\\r\\n127 Video 7.45 Balance 832.15\\r\\n128 Book 14.32 Balance 817.83\\r\\n129 Gasoline 16.10 Balance 801.73\\r\\nTotal expense  198.27\\r\\nAverage expense  39.65";

    String b2 = "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" +
        "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?";
    String b2sol = "Original Balance: 1233.00\\r\\n125 Hardware 24.80 Balance 1208.20\\r\\n123 Flowers 93.50 Balance 1114.70\\r\\n127 Meat 120.90 Balance 993.80\\r\\n120 Picture 34.00 Balance 959.80\\r\\n124 Gasoline 11.00 Balance 948.80\\r\\n123 Photos 71.40 Balance 877.40\\r\\n122 Picture 93.50 Balance 783.90\\r\\n132 Tyres 19.00 Balance 764.90\\r\\n129 Stamps 13.60 Balance 751.30\\r\\n129 Fruits 17.60 Balance 733.70\\r\\n129 Market 128.00 Balance 605.70\\r\\n121 Gasoline 13.60 Balance 592.10\\r\\nTotal expense  640.90\\r\\nAverage expense  53.41";

    String b3 = "1181.00\n001 Fruits ;! 13.10 ?;\n002 Fruits ;! 13.10 ?;\n003 Books  34.00 \n004 Flowers  17.60 \n005 Market  20.00 \n006 Car  3.20 \n007 Pen  17.50 \n008 Gasoline  17.00 \n009 Video  34.00 \n010 Grocery ;! 11.00 ?;";
    		String b3sol = "Original Balance: 1181.00\\r\\n001 Fruits 13.10 Balance 1167.90\\r\\n002 Fruits 13.10 Balance 1154.80\\r\\n003 Books 34.00 Balance 1120.80\\r\\n004 Flowers 17.60 Balance 1103.20\\r\\n005 Market 20.00 Balance 1083.20\\r\\n006 Car 3.20 Balance 1080.00\\r\\n007 Pen 17.50 Balance 1062.50\\r\\n008 Gasoline 17.00 Balance 1045.50\\r\\n009 Video 34.00 Balance 1011.50\\r\\n010 Grocery 11.00 Balance 1000.50\\r\\nTotal expense  180.50\\r\\nAverage expense  18.05";
    private static void testing(String book, String exp) {
        System.out.println("Testing book:\n" + book + "\n");
        String ans = EasyBal.balance(book);
        System.out.println("Actual: " + ans + "\n");
        System.out.println("Expect: " + exp);
        assertEquals(exp, ans);
        System.out.println("#");
    }
    @Test
    public void test() {
        testing(b1, b1sol);
        testing(b2, b2sol);
        testing(b3, b3sol);
        
}}
