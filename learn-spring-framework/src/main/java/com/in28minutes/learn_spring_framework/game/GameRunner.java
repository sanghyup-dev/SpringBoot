package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
  private SuperContraGame game; //this is tightly coupled code!
  //we need to make changes in the GameRunner class to be able to run another game

  public GameRunner(SuperContraGame game){
    this.game = game;
  }

  public void run() {
    System.out.println("Running game: "+ game);
    game.up();
    game.down();
    game.left();
    game.right();
  }
}
