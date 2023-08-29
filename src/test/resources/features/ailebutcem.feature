@aileButcem
Feature: Aile butcem uygulamasi gorevleri


  Background:

    * ilk ekran ayarlarini yapin ve ardindan "Giriş Yap" login sayfasina ulasin
    * "aileButcemMail" ve "aileButcemPassword" bilgilerini girerek kullanici bilgileriyle "Giriş Yap" yapin
    * uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin

  Scenario Outline: Kullanici aile butcem uygulamasindaki verilen gorevleri yerine getirir
    * sol kisimdaki menuden "Hesabım" bolumune gidin
    * hesabim sayfasindaki bilgileri degistirerek "<isimKutusu>" "<soyisimKutusu>" "<sehirKutusu>" "<yasKutusu>" "<meslekKutusu>" degisikleri "Kaydet" ve dogrulayin
    * kullanici sayfayi kapattir
    Examples:
      | isimKutusu | soyisimKutusu | sehirKutusu | yasKutusu | meslekKutusu |
      | Serpil     | Yilmaz        | New York    | 28        | Ogretmen     |
      | Furkan     | Kara          | Los Angeles | 27        | Ogrenci      |
      | Abdurrahim | Albayrak      | Toronto     | 28        | Doktor       |
