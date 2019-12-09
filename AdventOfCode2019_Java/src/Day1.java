import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day1 {

    private Stream<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName));
    }

    private void task1(Stream<String> data){
        Integer summary = data
                .map( number -> (int)Math.floor(Integer.parseInt(number) / 3) - 2 )
                .reduce(0, Integer::sum );

        System.out.println("Solution: " + summary);
    }

    private Integer sumElementInRecursion(Integer number){
        int result = (int)Math.floor(number / 3) - 2;
        if(result <= 0)
            return 0;
        return sumElementInRecursion(result) + result;
    }


    private void task2(Stream<String> data) {
        Integer summary = data
                .map( number -> sumElementInRecursion( Integer.parseInt(number)) )
                .reduce(0, Integer::sum );

        System.out.println("Solution: " + summary);
    }

    public static void main(String[] args) {
        String filename = "input/day1.txt";
        Stream<String> data = Stream.empty();
        Day1 day1 = new Day1();

        try {
            day1.task1(day1.readFile(filename));
            day1.task2(day1.readFile(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
