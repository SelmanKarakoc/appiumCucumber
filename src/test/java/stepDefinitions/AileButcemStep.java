package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.AileButcemPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AileButcemStep {
    AileButcemPage aileButcemPage=new AileButcemPage();
    @Given("ilk ekran ayarlarini yapin ve ardindan {string} login sayfasina ulasin")
    public void ilk_ekran_ayarlarini_yapin_ve_ardindan_login_sayfasina_ulasin(String girisYap) throws InterruptedException {
        Driver.getAndroidDriver();
        aileButcemPage.ilkEkranGecmeMethodu(girisYap);

    }
    @Given("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string} yapin")
    public void mail_ve_password_bilgilerini_girerek_kullanici_bilgileriyle_giris_yapin(String mail,String password,String girisYap) throws InterruptedException {
        aileButcemPage.girisYapmaMethodu(mail,password,girisYap);


    }
    @Given("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        Assert.assertTrue(aileButcemPage.girisYapildiText.isDisplayed());
    }
    @Given("sol kisimdaki menuden {string} bolumune gidin")
    public void sol_kisimdaki_menuden_hesabim_bolumune_gidin(String hesabimButon) throws InterruptedException {
        Thread.sleep(4000);

        ReusableMethods.clickWithCoordinates(110,132,750);
        ReusableMethods.scrollWithUiScrollableAndClick(hesabimButon);
    }
    @Given("hesabim sayfasindaki bilgileri degistirerek {string} {string} {string} {string} {string} degisikleri {string} ve dogrulayin")
    public void hesabim_sayfasindaki_bilgileri_degistirerek_degisikleri_kaydedin(String isim,String soyisim,String sehir,String yas,String meslek,String kaydet) {
        aileButcemPage.kullaniciBilgileriKontrolMethodu(isim,soyisim,sehir,yas,meslek,kaydet);
        Assert.assertTrue(aileButcemPage.isim.getText().contains(isim));
        Assert.assertTrue(aileButcemPage.soyisim.getText().contains(soyisim));
        Assert.assertTrue(aileButcemPage.sehir.getText().contains(sehir));
        Assert.assertTrue(aileButcemPage.yas.getText().contains(yas));
        Assert.assertTrue(aileButcemPage.meslek.getText().contains(meslek));

    }
    @Given("kullanici sayfayi kapattir")
    public void kullanici_sayfayi_kapattir() {
        Driver.quitAppiumDriver();
    }

}
