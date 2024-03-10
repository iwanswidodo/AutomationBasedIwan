package StepDef.BE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static StepDef.Integrations.Assertion.Assertions.assertEquals;

@SpringBootTest
public class BETest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MainBaseMethod mainBaseMethod;

    @Test
    public void reqresGetUser (){
        mainBaseMethod.httpGet("https://reqres.in/api/users/2");
        System.out.println(mainBaseMethod.response.getBody().prettyPrint());
        mainBaseMethod.assertStatusCode(200);

    }





}
