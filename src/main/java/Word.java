import java.util.ArrayList;

public class Word {
  private String mName;
  private static ArrayList<Word> instances = new ArrayList<Word>();

  public Word(String name) {
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Word> all() {
    return instances;
  }
}
