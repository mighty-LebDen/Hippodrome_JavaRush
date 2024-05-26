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
    game.run();
    game.printWinner();
  }
  public void run()  {
    for(int i = 0; i < 100; i++) {
      move();
      print();
      try {
        Thread.sleep(200);
      } catch(InterruptedException ex) {
        ex.fillInStackTrace();
      }
    }
  }
  public void move(){
    for(Horse horse : this.horses) {
      horse.move();
    }
  }
  public void print(){
    for(Horse horse : this.horses) {
      horse.print();
    }
    for(int i = 0; i < 10; i++) {
      System.out.println();
    }
  }
  public Horse getWinner() {
    double max = 0;
    for(Horse horse : horses) {
      max = Math.max(max, horse.getDistance());
    }
    double ERR = 1e-10;
    Object winnerHorse = new Object();
    for(Horse horse : horses) {
      if(Math.abs(max - horse.getDistance()) < ERR) {
        winnerHorse = horse;
      }
    }
    return (Horse) winnerHorse;
  }
  
  public void printWinner() {
    Horse winnerHorse = getWinner();
    System.out.printf("Winner is %s !%n", winnerHorse.getName());
  }
}