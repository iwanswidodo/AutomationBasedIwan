package StepDef.Integrations.Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class RandomGenerator {

    public static Random rand = new Random();

    /*	To Generate Random Numbers of the Entered Length.*/
    public static String GenerateRandomNumber(int length) {
        StringBuilder output = new StringBuilder(2000);
        output.append("1");
        for (int i = 1; i < length; i++) {
            output.append(0);
        }
        long num = Long.parseLong(output.toString());
        long maxnum = (num * 10) - 1;
        long randnum = num + rand.nextLong(maxnum) + 1;
        return Long.toString(randnum);
    }

    /*	To Generate Random Capitalized Letters of the Entered Length.*/
    public static String GenerateRandomCapitalizedString(int length) {
        StringBuffer output = new StringBuffer(1000);
        output.append((char) (rand.nextInt(26) + 'A'));
        System.out.println(output);

        for (int i = 1; i < 10; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            output.append(c);
        }
        return output.toString();
    }

    /*	To Generate Random Alpha-Numeric Characters of the Entered Length.*/
    public static String GenerateRandomAlphaNumericCharacters(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /*	To Generate Random ASCII Characters of the Entered Length.*/
    public static String GenerateRandomASCIICharacters(int length) {
        return RandomStringUtils.randomAscii(length);
    }

    /*	To Generate Random E-Mail IDs(Auto Generate Domain Names.*/
    public static String GenerateRandomEMAILIDs() {
        String EmailID = RandomStringUtils.randomAlphabetic(15);
        String Domain = RandomStringUtils.randomAlphabetic(7).toLowerCase();
        return EmailID + "@" + Domain + ".com";
    }

    /*	To Generate Random E-Mail IDs.*/
    public static String GenerateRandomEMAILIDs(String DomainName) {
        String EmailID = RandomStringUtils.randomAlphabetic(15);
        return EmailID + "@" + DomainName;
    }

    public static double randomDouble(long min, long max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public static double randomDouble(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public static int randomInteger(int min, int max){
        Random rand = new Random();
        return  rand.nextInt(max-min) + min;
    }
    public static int randomInteger(int length){
        Random rand = new Random();
        return  rand.nextInt(length);
    }
}
