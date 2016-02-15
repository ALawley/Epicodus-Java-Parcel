import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Enter your info");
  }
  @Test
  public void calculateTest() {
      goTo("http://localhost:4567/");
      fill("#height").with("12");
      fill("#width").with("12");
      fill("#length").with("12");
      fill("#weight").with("12");
      fill("#distance").with("500");
      find("#express").click();
      find("#no").click();
      submit(".btn");
      assertThat(pageSource()).contains("The total cost to ship your parcel will be: $14.24");
  }
}
