package achieve;

import lombok.experimental.ExtensionMethod;

/**
 * @author ozawa
 * @version 1.0
 * @date 2022
 * @description achieve
 * @since JDK1.8
 */
@ExtensionMethod({java.util.Arrays.class, Extensions.class})
public class ExtensionMethodStudy {
    private static String testString() {
        String iAmNull = null;
        return iAmNull.or("hELlO, WORlD!".toTitleCase());
    }

    private static int[] testArray() {
        int[] intArray = {5, 3, 8, 2};
        intArray.sort();
        return intArray;
    }

    public static void main(String[] args) {
        for (int i : testArray()) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(testString());
    }
}

class Extensions {
    public static <T> T or(T obj, T ifNull) {
        return obj != null ? obj : ifNull;
    }

    public static String toTitleCase(String in) {
        if (in.isEmpty()) {
            return in;
        }
        return "" + Character.toTitleCase(in.charAt(0)) +
                in.substring(1).toLowerCase();
    }
}
