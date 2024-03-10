package StepDef.Integrations.SpringBoot;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PropertiesReader {

    @Value("${spring.profiles.active}")
    private String environment;

    //device
    @Value("${device}")
    private String device;
    @Value("${device.headless}")
    private boolean deviceHeadless;
    @Value("${device.size}")
    private String deviceSize;


    @Value("${highlight.element}")
    private boolean highlightElement;
    @Value("${maxPageLoadTime}")
    private int maxPageLoadTime;
    @Value("${screenshot.element}")
    private boolean screenshotElement;
    @Value("${record.mode}")
    private String recordMode;


    @Value("${website.url}")
    private String websiteUrl;

}
