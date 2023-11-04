package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions2 {
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtil excelUtil;
    List<Map<String,String>> excelData;

    @Given("kullanici bilgileri ile {string} giris yapar")
    public void kullanici_bilgileri_ile_giris_yapar(String sheetName) throws IOException {
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx"; // path of the excel sheet(content root)
//        String sheetName ="customer_info";
        excelUtil = new ExcelUtil(path, sheetName); // sheetName i future file dan aldım
        excelData= excelUtil.getDataList();

        for (Map<String,String> eachData :excelData){
//        ana sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

            blueRentalHomePage = new BlueRentalHomePage();
            blueRentalLoginPage =new BlueRentalLoginPage();
// ana sayfa login butonuna tıkla
          blueRentalHomePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
//      email i gönder
          blueRentalLoginPage.userName.sendKeys(eachData.get("username"));
//      sifre i gönder
          blueRentalLoginPage.password.sendKeys(eachData.get("password"));
//         login butonuna tıla
         blueRentalLoginPage.loginButton.click();
//     giris yapıladıgını verify edelim- ID görünürse giris basarılıdır
            ReusableMethods.waitFor(3);
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
        ReusableMethods.getScreenshot("Login_Goruntusu");
//    log out yapalım
            ReusableMethods.waitFor(2);
         blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(2);
         blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(2);
         blueRentalHomePage.OK.click();

        }
        Driver.closeDriver();
        }









}


