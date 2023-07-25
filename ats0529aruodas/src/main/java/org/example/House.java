package org.example;

import org.openqa.selenium.By;

public class House extends Advertisement{
    private String landArea;
    private String buildYear;

    public House(String city, String microdistrict, String phoNo, String houseSize,String landArea, String price,String buildYear){
        super(city, microdistrict, phoNo, houseSize, price);
        this.landArea = landArea;
        this.buildYear = buildYear;
    }

    public void fillAd(){
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=2&offer_type=1");
        fillGenerics();
        fillLandArea();
        fillBuildYear();
      //  submit();
    }

    public void fillLandArea(){
        Utils.driver.findElement(By.id("fieldFAreaLot")).sendKeys(this.landArea);
    }
    public void fillBuildYear(){
        Utils.driver.findElement(By.name("FBuildYear")).sendKeys(this.buildYear);
    }
}
