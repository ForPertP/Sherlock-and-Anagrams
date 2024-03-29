import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

private static int sherlockAndAnagrams_ByString(String s) {
        int result = 0;
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                char[] subChars = s.substring(i, j + 1).toCharArray();
                Arrays.sort(subChars);
                String sub = new String(subChars);
                frequencyMap.put(sub, frequencyMap.getOrDefault(sub, 0) + 1);
            }
        }

        for (int count : frequencyMap.values()) {
            result += (count * (count - 1)) / 2;
        }

        return result;
    }

    private static int sherlockAndAnagrams_ByArray(String s) {
        int result = 0;
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            int[] arr = new int[26];

            for (int j = i; j < s.length(); ++j) {
                arr[s.charAt(j) - 'a']++;
                String charFrequency = Arrays.toString(arr);
                frequencyMap.put(charFrequency, frequencyMap.getOrDefault(charFrequency, 0) + 1);
            }
        }

        for (int count : frequencyMap.values()) {
            result += (count * (count - 1)) / 2;
        }

        return result;
    }

    public static int sherlockAndAnagrams(String s) {
        if (s.length() < 50) {
            return sherlockAndAnagrams_ByString(s);
        } else {
            return sherlockAndAnagrams_ByArray(s);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
