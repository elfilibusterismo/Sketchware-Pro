package mod.elfilibustero.sketch.lib.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomVariableUtil {
    public static final Pattern PATTERN_CUSTOM_VARIABLE = Pattern.compile("\\b((private|public|protected|static|final)\\s*)*([\\w$<>]+(?:\\s*,\\s*[\\w$<>]+)*(?:\\[\\])*)(?:\\s+([\\w$]+))(?:\\s*=\\s*(.*?))?\\b");

    private static final int VARIABLE_TYPE = 3;
    private static final int VARIABLE_NAME = 4;
    private static final int VARIABLE_INITIALIZER = 5;

    public static String getVariableType(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return matcher.group(VARIABLE_TYPE);
        }
        return null;
    }

    public static String getVariableName(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return matcher.group(VARIABLE_NAME);
        }
        return null;
    }

    public static String getVariableInitializer(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return matcher.group(VARIABLE_INITIALIZER);
        }
        return null;
    }

    private static Matcher getMatcher(String input) {
        return PATTERN_CUSTOM_VARIABLE.matcher(input);
    }

}
