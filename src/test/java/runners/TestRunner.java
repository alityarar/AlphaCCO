package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber.xml"},

        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@US1",
        dryRun =false

)
public class TestRunner {
    /*
     A single Runner class may be sufficient in a framework
      In the Runner class, nothing happens in the class body
      There are 2 annotations that make our Runner class important.
      @RunWith(Cucumber.class) notation feature to work with Runner class
      train. Because of this demonstration, we'd like to use JUnit in our Cucumber framework.
      We prefer.

      properties : where to find runner files property files
      tariffs.

      glue: shows where to find the step definition files.

      tags: It shows which tag we want to run at that moment.

      dryRun: there are two choices
      dryRun=True= just gives us the missing steps without running our test

      When we type dryRun= false it will run our tests.





      Bir framework'de bir tek Runner sınıfı yeterli olabilir
     Runner class'ında class bodysinde hic bir sey olmaz
     Runner class'ımızı onemli yapan 2 adet anontasyon vardir.
     @RunWith(Cucumber.class) notasyonu Runner class'ina calisma ozelligi
     katar. Bu gösterimin olduğu için Cucumber frameworkumuzde JUnit kullanmayıyi
     tercih ediyoruz.

     özellikler : Runner dosyalarının özellik dosyalarını nereden bulacağını
     tarife eder.

     yapıştırıcı: adım tanımları dosyalarını nerede bulacağımızı gosterir.

     etiketler: o an hangi etiketi calistirmak istiyorsak onu belli eder.

     dryRun: iki seçim var
     dryRun=True= testimizi calistirmadan sadece eksik adimlari bize verir

     dryRun= false yazdigimizda testlerimizi calistirir.
     */
}
