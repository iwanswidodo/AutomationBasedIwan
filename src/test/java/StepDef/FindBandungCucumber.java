package StepDef;

import StepDef.FE.pageobject.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class FindBandungCucumber extends BasePage{



    @Given("As a user already on homepage")
    public void asAUserAlreadyOnHomepage() {
        searchBandung. openWebsiteUrl();
    }

    @When("User click Search button")
    public void userClickSearchButton()throws Exception{
     searchBandung.ClickbtnSearchPlace();

    }

    @And("User search province Jawa Barat")
    public void userSearchProvinceJawaBarat() throws InterruptedException {
       searchBandung.SearchProvinsi();
    }

    @And("User Search Kota Bandung")
    public void userSearchKotaBandung() throws InterruptedException {
        searchBandung.SearchKota();
    }

    @And("User Click simpan button")
    public void userClickSimpanButton() throws InterruptedException {
        searchBandung.ClickbtnSimpan();
    }

    @And("Click Lihat semua Button")
    public void clickLihatSemuaButton() throws InterruptedException {
        searchBandung.ClicklblLihatSemua();

    }

    @Then("As a user should be to see result filter Bandung City")
    public void asAUserShouldBeToSeeResultFilterBandungCity() throws InterruptedException {
       searchBandung.AssertLocation();
    }


    @And("user click lokasi pekerjaan button")
    public void userClickLokasiPekerjaanButton() throws InterruptedException {
        searchBandung.ClickbtnLokasiPekerjaan();
    }
}
