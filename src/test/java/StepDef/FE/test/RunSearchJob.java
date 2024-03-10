package StepDef.FE.test;

import StepDef.FE.pageobject.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class RunSearchJob extends AbstractTestNGSpringContextTests {

 @Autowired
 private BasePage basePage;
    @Test
    public void SearchJob() throws Exception {
      basePage.searchBandung. openWebsiteUrl().
              ClickbtnSearchPlace().
              ClickbtnLokasiPekerjaan().
              SearchProvinsi().
              SearchKota().
              ClickbtnSimpan().
              ClicklblLihatSemua().
              AssertLocation();
    }



}
