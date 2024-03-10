package StepDef.FE.pageobject;

import StepDef.Integrations.SpringBoot.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static StepDef.Integrations.Assertion.Assertions.verifyWebElementIsDisplayed;
import static StepDef.Integrations.Assertion.Assertions.verifyWebElementText;

@Page
public class SearchBandung extends BasePage {


    @FindBy(xpath = "//strong[contains(text(),'Mau kerja dimana?')]")
    private WebElement btnSearchPlace;
    @FindBy(xpath = "//span[contains(text(),'Lokasi Pekerjaan')]")
    private WebElement btnLokasiPekerjaan;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div")
    private WebElement btnProvinsi;
    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/input[1]")
    private WebElement inputCariProvinsi;
    @FindBy(xpath = "//span[contains(text(),'Jawa Barat')]")
    private WebElement lblJawaBarat;
    @FindBy(xpath = "//div[@data-testid='testid-molecule-collapsable-panel']/div[2]/div/div/div[2]//div[@class='ant-space-item'][2]/div")
    private WebElement btnCariKota;
    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/input[1]")
    private WebElement inputlCariKota;

    @FindBy(xpath = "//span[contains(text(),'Kabupaten Bandung')]")
    private WebElement checkbox1;
    @FindBy(xpath = "//span[contains(text(),'Kota Bandung')]")
    private WebElement checkbox2;
//    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/input[1]")
//    private WebElement inputlCariKota;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div[2]/div[3]/div/div[3]/div/div[1]/button/div")
    private WebElement btnSimpan;
	@FindBy(xpath="/html/body/div/div[1]/div/div/div[3]/div/div[2]/div/div[1]/button/div")
	private WebElement btnsimpanPrefKerja;

    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[3]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/span[1]")
    private WebElement lblLihatSemua;

    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/span[1]")
    private WebElement assertBandungTxt;

    public SearchBandung openWebsiteUrl(){
       driver.get(propertiesReader.getWebsiteUrl());
        return this;
    }

    public SearchBandung ClickbtnSearchPlace() throws InterruptedException {
        Thread.sleep(2000);
        click(btnSearchPlace);
        return this;
    }

    public SearchBandung ClickbtnLokasiPekerjaan() throws InterruptedException {
        Thread.sleep(2000);
        click(btnLokasiPekerjaan);
        return this;
    }

    public SearchBandung SearchProvinsi() throws InterruptedException {
        Thread.sleep(5000);
        click(btnProvinsi);
        Thread.sleep(2000);
        sendKeys( inputCariProvinsi, "Jawa barat");
        Thread.sleep(2000);
        click(lblJawaBarat);
        return this;
    }

    public SearchBandung SearchKota() throws InterruptedException {
        Thread.sleep(2000);
        JSclick(btnCariKota);
        Thread.sleep(2000);
        JSclick(btnCariKota);
        Thread.sleep(2000);
        sendKeys( inputlCariKota, "Bandung");
        Thread.sleep(2000);
        click(checkbox1); //click Kabupaten bandung & Kabupaten Bandung barat
        Thread.sleep(2000);
        click(checkbox2);
        return this;
    }

    public SearchBandung ClickbtnSimpan() throws InterruptedException {
        Thread.sleep(2000);
        click(btnSimpan); // save search city
        Thread.sleep(2000);
        click(btnsimpanPrefKerja); // save for search the preference work
        return this;
    }

   // this action for see all filter
    public SearchBandung ClicklblLihatSemua() throws InterruptedException {
        Thread.sleep(2000);
        click(lblLihatSemua);
        return this;
    }

    // for validation if testing is success
    // for validation using Assert
    public SearchBandung AssertLocation() throws InterruptedException {
        Thread.sleep(4000);//Verify the system already filter the category based on Location Bandung
        verifyWebElementIsDisplayed(assertBandungTxt);
        verifyWebElementText(assertBandungTxt, "Kota Bandung");
        return this;
    }

}