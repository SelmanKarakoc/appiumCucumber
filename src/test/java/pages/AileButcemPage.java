package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class AileButcemPage {
    public AileButcemPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)),this);
    }

    @FindBy(xpath = "//*[@text='E-mail Adresi']")
    private MobileElement emailBox;

    @FindBy(xpath = "//*[@text='Şifre']")
    private MobileElement passwordBox;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[16]")
    public MobileElement girisYapildiText;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isim;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisim;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehir;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement yas;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement meslek;



    public void ilkEkranGecmeMethodu(String girisYapText) throws InterruptedException {
        Thread.sleep(2000);
        for (int i=0; i<6;i++){
            ReusableMethods.screenScroll(924,950,750,150,950);
        }
        ReusableMethods.scrollWithUiScrollableAndClick(girisYapText);
    }

    public void girisYapmaMethodu(String mail,String password,String girisYap) throws InterruptedException {
        emailBox.sendKeys(ConfigReader.getProperty(mail));
        passwordBox.sendKeys(ConfigReader.getProperty(password));
        Thread.sleep(1000);
        ReusableMethods.scrollWithUiScrollableAndClick(girisYap);
    }

    public void boxesClear(){
        isim.clear();
        soyisim.clear();
        sehir.clear();
        yas.clear();
        meslek.clear();
    }
    public void kullaniciBilgileriKontrolMethodu(String kIsim,String kSoyisim,String kSehir,String kYas,String kMeslek,String kaydet){
        boxesClear();
        isim.sendKeys(kIsim);
        soyisim.sendKeys(kSoyisim);
        sehir.sendKeys(kSehir);
        yas.sendKeys(kYas);
        meslek.sendKeys(kMeslek);
        ReusableMethods.scrollWithUiScrollableAndClick(kaydet);


    }

    public void boxesAssertion(){}

}
