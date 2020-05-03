package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "allanteixeira1";
    public static final String AUTOMATE_KEY = "tyDAJsy6VuEkKB8T6uAS";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "/Users/allanteixeira/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;

    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "83.0 beta");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");

        WebDriver navegador = null;

        try{
            navegador = new RemoteWebDriver(new URL(URL), caps);


        }catch (MalformedURLException e){
            System.out.println("Houveram problemas com a URL:" + e.getMessage());
        }

        return navegador;
    }
}
