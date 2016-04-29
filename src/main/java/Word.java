import java.util.ArrayList;

public class Word {
  private String mName;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mId;

  public Word(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

}
