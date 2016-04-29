import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("The Galactic Dictionary");
    assertThat(pageSource()).contains("View Word List");
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Compassion");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void allWordsPageIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Compassion");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("All words");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Compassion");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Compassion");
  }

  @Test
  public void wordShowPageDisplaysName() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Compassion");
    submit(".btn");
    click("a", withText("View words"));
    goTo("http://localhost:4567/words/1");
    assertThat(pageSource()).contains("Compassion");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Compassion");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Compassion"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Compassion");
  }

  @Test
  public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Compassion");
    submit(".btn");
    click("a", withText("View words"));
    goTo("http://localhost:4567/words/1");
    click("a", withText("Add a new definition"));
    fill("#definition").with("The ability to empathize with others.");
    submit(".btn");
    click("a", withText("View words"));
    goTo("http://localhost:4567/words/1");
    assertThat(pageSource()).contains("The ability to empathize with others.");
  }

}
