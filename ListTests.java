import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ListTests {
    public class StringCheckerClass implements StringChecker {
        private String myString;

        public StringCheckerClass(String str) {
            myString = str;
        }

        @Override
        public boolean checkString(String s) {
            return s.equals(myString);
        }
    }

    @Test
    public void testFilterEmptyList() {
        StringCheckerClass scc = new StringCheckerClass("hello");
        List<String> input = new ArrayList<String>();
        assertArrayEquals(new ArrayList<String>().toArray(), ListExamples.filter(input, scc).toArray());
    }

    @Test
    public void testFilterNormalList() {
        StringCheckerClass scc = new StringCheckerClass("abc");
        List<String> input = new ArrayList<String>();
        input.add("test");
        input.add("abc");
        input.add("hello");
        List<String> output = new ArrayList<String>();
        output.add("test");
        output.add("hello");
        assertArrayEquals(output.toArray(), ListExamples.filter(input, scc).toArray());
    }

    @Test
    public void testMergeSameLists() {
        List<String> input1 = new ArrayList<String>();
        List<String> input2 = new ArrayList<String>();
        String[] words = new String[] { "a", "b", "c" };
        for (String word : words) {
            input1.add(word);
            input2.add(word);
        }
        List<String> output = new ArrayList<String>();
        for (String word : words) {
            output.add(word);
            output.add(word);
        }
        assertArrayEquals(output.toArray(), ListExamples.merge(input1, input2).toArray());
    }
}
