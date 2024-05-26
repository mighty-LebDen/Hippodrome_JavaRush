import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
  private List<Horse> horses;
  private static Hippodrome game;
  
  public List<Horse> getHorses() {
    return this.horses;
  }
  public Hippodrome(List<Horse> horses) {
    this.horses = horses;
  }
  public static void main(String[] args) {
    Horse firstHorse = new Horse("horseOne", 3, 0);
    Horse secondHorse = new Horse("horseTwo", 3, 0);
    Horse thirdHorse = new Horse("horseThree", 3, 0);
    List<Horse> horseList = new ArrayList<>();
    horseList.add(firstHorse);
    horseList.add(secondHorse);
    horseList.add(thirdHorse);
    Hippodrome.game = new Hippodrome(horseList);
  }
}