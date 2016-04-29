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

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDef = new Definition("One definition");
    Definition secondDef = new Definition("Another definition");
    assertTrue(Definition.all().contains(firstDef));
    assertTrue(Definition.all().contains(secondDef));
  }

}
