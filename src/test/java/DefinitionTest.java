import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("This is the meaning of this word.");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithMeaning_String() {
    Definition myDefinition = new Definition("This is the meaning of this word.");
    assertEquals("This is the meaning of this word.", myDefinition.getMeaning());
  }

}
