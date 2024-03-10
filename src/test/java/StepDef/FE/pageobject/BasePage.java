package StepDef.FE.pageobject;

import StepDef.FE.WebBaseMethod;
import StepDef.Integrations.SpringBoot.LazyAutowired;
import StepDef.Integrations.SpringBoot.Page;
import StepDef.Integrations.SpringBoot.PropertiesReader;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;

@Page
public class BasePage extends WebBaseMethod {

    @PostConstruct
    public void initPageObject() {
        PageFactory.initElements(driver, this);
    }

    @LazyAutowired
    public PropertiesReader propertiesReader;
    //autowiring
    @LazyAutowired
    public SearchBandung searchBandung;



}
