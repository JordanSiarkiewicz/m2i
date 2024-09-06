package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class ProductTest {
    private Product product;
    private Shop shop;

    @Test
    public void testProductWhenPeremptionDate_0_ThenQualityDegradeTwoTimesFaster() {
        //ARRANGE
        product = new Product("Cereales","Cherios",0,10);
        int resultAwait = 8;

        //ACT
        shop.update(product);
        int result = product.getQuality();

        //ASSERT
        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void testProductWhenQualityProductNeverNegative(){
        //ARRANGE
        product = new Product("Cereales","Cherios",0,0);
        int resultAwait = 0;

        //ACT
        shop.update(product);
        int result = product.getQuality();

        //ASSERT
        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void testProductWhenQualityNeverUpperThan_50(){
        product = new Product("Cereales","Cherios",10,50);
        int resultAwait = 50;
        
        shop.update(product);
    }
}
