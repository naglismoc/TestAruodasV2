package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Advertisement {

    private String city;
    private String microdistrict;
    private String street;
    private String phoNo;
    private String area;
    private String price;

    public Advertisement(String city, String microdistrict, String phoNo, String area, String price) {
        this.city = city;
        this.microdistrict = microdistrict;
        this.phoNo = phoNo;
        this.area = area;
        this.price = price;
    }

    public void fillGenerics(){
        selectRegion();
        selectDistrict();
        fillArea();
        fillPrice();
        fillPhone();
    }

    public void fillArea(){
        if(this.getArea().equals("")){
            return;
        }
        Utils.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.getArea());
    }
    public void fillPrice(){
        if(this.getPrice().equals("")){
            return;
        }
        Utils.driver.findElement(By.id("priceField")).sendKeys(this.getPrice());
    }
    public void fillPhone(){
        if(this.getPhoNo().equals("")){
            return;
        }
        Utils.driver.findElement(By.name("phone")).sendKeys(this.getPhoNo());
    }
    public void selectDistrict(){
        if(this.getMicrodistrict().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/input[2]")).click();
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElement(By.tagName("input")).sendKeys(this.getMicrodistrict());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rows = Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).size() - 1;
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).get(rows).click();
    }
    public void selectRegion(){
        if(this.getCity().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/span")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(this.getCity());
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[63]"),this.getCity()));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }
    public void submit(){
        Utils.driver.findElement(By.id("submitFormButton")).click();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMicrodistrict() {
        return microdistrict;
    }

    public void setMicrodistrict(String microdistrict) {
        this.microdistrict = microdistrict;
    }

    public String getPhoNo() {
        return phoNo;
    }

    public void setPhoNo(String phoNo) {
        this.phoNo = phoNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
