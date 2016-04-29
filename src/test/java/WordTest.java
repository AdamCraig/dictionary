import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
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

  @Test
  public void clear_emptiesAllWordsFromList_0() {
    Word testWord = new Word("Compassion");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
    public void getId_wordsInstantiateWithAnId_1() {
    Word testWord = new Word("Compassion");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("Compassion");
    Word secondWord = new Word("Understanding");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyList_ArrayList() {
    Word testWord = new Word("Compassion");
    assertEquals(0, testWord.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsDefinitionToList_true() {
    Word testWord = new Word("Compassion");
    Definition testDefinition = new Definition("The ability to empathize with others.");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

}
