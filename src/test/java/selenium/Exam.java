package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Exam {

    public static void main(String[] args) {
        /**
         * Ques-2:
         * Create a method to return factorial value of input-int-value
         * points: 10
         * eg:
         * input -> 5
         * returned value -> (5*4*3*2*1) = 120
         *
         * input -> 1
         * returned value -> (1) = 1
         *
         * input -> 3
         * returned value -> (3*2*1) = 6
         *
         * input -> 10
         * returned value -> (10*9*8*7*6*5*4*3*2*1) =
         */

        System.out.println(Exam.calculateFactorial(5));
        System.out.println(Exam.calculateFactorial(1));
        System.out.println(Exam.calculateFactorial(6));
        System.out.println(Exam.calculateFactorial(10));

        /**
         * Ques-3:
         * Create a method to return the common Strings values in two input-String-arrays
         * points: 30
         * Note: two input-String-arrays can be of same size or different size
         * eg:
         * input -> {"happY", "king", "peace", "living standard"} , {"king kong", "Happy", "PEACE"}
         * returned value -> [happy, peace]
         *
         * input -> {“ab”, “abcd”, “abc”, “abcde”, “defg”, "koli”} , {“abcde”, “jhuy”, “plot”, “koli”}
         * returned value -> [abcde, koli]
         */
        String[] a = {"happY", "king", "peace", "living standard"};
        String[] b = {"king kong", "Happy", "PEACE"};
        HashSet<String> set = Exam.commonString(a,b);
        System.out.println(set);

        String[] aa = {"ab", "abcd", "abc", "abcde", "defq", "koli"};
        String[] bb = {"abcde", "jhuy", "plot", "koli"};
        HashSet<String> set1 = Exam.commonString(aa,bb);
        System.out.println(set1);

        /**              I couldn't do Ques-4
         * Ques-4:
         * Create a method to return missing smallest positive integer (greater than 0) from given int-array.
         * points: 40
         *
         * eg:
         * 	input -> : {3, 5, 1, 4, 2, 7}
         * 	returned value : 6
         *
         * 	input -> : {3, 5, 1, 4, 2}
         * 	returned value : 6
         *
         * 	input -> {3, 5, 1, 4, 2}
         * 	returned value : 1
         *
         * 	input -> {0, 5, -1, 1, 2, 5, 3, 7, 1, 2}
         * 	returned value : 4
         *
         * 	input -> {-2, -5, -1, -10, -6}
         * 	returned value : 1
         *
         */
        int[] val = {3, 5, 1, 4, 2, 7};
        System.out.println(Exam.MissingPositiveNumber(val));
        int[] val1 = {3, 5, 1, 4, 2};
        System.out.println(Exam.MissingPositiveNumber(val1));;
        int[] val2 = {3, 5, 1, 4, 2,7};
        System.out.println(Exam.MissingPositiveNumber(val2));
        int[] val3 = {0, 5, -1, 1, 2, 5, 3, 7, 1, 2};
        System.out.println(Exam.MissingPositiveNumber(val3));
        int[] val4 = {-2, -5, -1, -10, -6};
        System.out.println(Exam.MissingPositiveNumber(val4));

    }

    /**
     * Ques-1:
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */
    @Test
    public void darkSkyTemp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://www.darksky.net");
        String temp = driver.findElement(By.xpath("//span[@class='feels-like-text']")).getText();
        String newtemp = temp.substring(0, 2);
        int tt = Integer.parseInt(newtemp);
        System.out.println(tt);

        String temp1 = driver.findElement(By.xpath("//span[@class='low-temp-text']")).getText();
        String newtemp1 = temp1.substring(0, 2);
        int tt1 = Integer.parseInt(newtemp1);
        System.out.println(tt1);

        String temp2 = driver.findElement(By.xpath("//span[@class='high-temp-text']")).getText();
        String newtemp2 = temp2.substring(0, 2);
        int tt2 = Integer.parseInt(newtemp2);
        System.out.println(tt2);

        boolean abc = tt > tt1 && tt < tt2;
        Assert.assertTrue(abc);

//        if (tt > tt1 && tt < tt2) {
//            System.out.println("The current temperature is in between the low and high temp");
//            Assert.assertTrue(true);
//
//        } else {
//            System.out.println("The current temperature is not between the low and high temp");
//            Assert.assertTrue(false);
//        }
        driver.quit();
    }
    // Question 2
    @Test
    public static int calculateFactorial(int input) {
        int factorial =1;
     for (int i=1; i<=input; i++){
         factorial*=i;
     }
        return factorial;
    }

     // Queastion 3
    public static HashSet<String> commonString(String[] value1, String[] vaslue2){
        HashSet<String> set = new HashSet<String>();
        for (int i=0; i<value1.length; i++){
            for (int j=0; j<vaslue2.length; j++){
                if (value1[i].equalsIgnoreCase(vaslue2[j])){
                    set.add(value1[i]);
                }
            }
        }
       return set;

    }
       //  Question 4
    static int MissingPositiveNumber(int[] numbers) {
        int sum = 0;
        for(int i: numbers) {
            sum += i;
        }

        int num = numbers.length+1;
        return (num *(num - 1)/2) - sum;
        }


    }




