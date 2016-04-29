import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("This is the meaning of this word.");
    assertEquals(false, myDefinition instanceof Definition);
  }

}
