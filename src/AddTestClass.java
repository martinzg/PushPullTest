public class MyTask implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    // Here the actor performs the actions to complete the task
  }
}
