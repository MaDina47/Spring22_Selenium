package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumClass {
    public static void main(String[] args) {

    }
    @Test
    public void verify2Plus2(){
        Assert.assertEquals(2+2, 14, "2+2 is not coming as expected");
        }

    @Test
    public void verify3Plus3(){
        Assert.assertEquals(3+3, 7, "3+3 is not coming as expected");
    }



    }



