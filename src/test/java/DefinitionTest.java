import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @After
  public void tearDown() {
    Definition.clear();
  }

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

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("Look, another definition!");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void getId_definitionsInstantiateWithAnID_1() {
    Definition myDefinition = new Definition("Wow, another definition...");
    assertEquals(1, myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDef = new Definition("A definition. Did you think there would be something else here?");
    Definition secondDef = new Definition("Another definition. Oh boy!");
    assertEquals(Definition.find(secondDef.getId()), secondDef);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }

}
