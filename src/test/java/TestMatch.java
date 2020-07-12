import java.util.function.Predicate;
import static gr.angelo.functional.condition.Matcher.Match;

public class TestMatch {
    public static void main(String[] args) {
        Predicate<Integer> predicate = v -> v>4;
        Predicate<Integer> predicate2 = v -> v<4;
        String match = Match(5).of(predicate).match(() -> "Well Done!");
        String match2 = Match(5).of(predicate2).ifMatch(() -> "Well Done!").orElse("Pitty");
        Match(5).of(predicate2).ifMatch(() -> System.out.println("Well Done!")).orElseRun(() -> System.out.println("Pitty"));
        Match(5).of(t -> t>4).ifMatch(() -> System.out.println("Well Done!")).orElseRun(() -> System.out.println("Pitty"));
        System.out.println(match + " " + match2);
    }
}
