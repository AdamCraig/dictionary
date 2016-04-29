import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    // Word.clear();
    Definition.clear();
  }

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Compassion");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_wordInstantiatesWithName_Compassion() {
   Word testWord = new Word("Compassion");
   assertEquals("Compassion", testWord.getName());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Compassion");
    Word secondWord = new Word("Understanding");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }




}
