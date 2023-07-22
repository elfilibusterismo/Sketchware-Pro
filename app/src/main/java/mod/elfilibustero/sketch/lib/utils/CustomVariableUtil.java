package mod.elfilibustero.sketch.lib.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomVariableUtil {
    public static final Pattern PATTERN_CUSTOM_VARIABLE = Pattern.compile(
            "\\b((private|public|protected|static|final|transient|volatile)\\s+)*([\\w$]+(?:\\s*,\\s*[\\w$]+)*(?:\\[\\])*)(?:\\s*<[^>]+>)?\\s+([\\w$]+)\\b"
    );

    private static final int VARIABLE_TYPE = 3;
    private static final int VARIABLE_NAME = 4;

    public static String getVariableModifier(String input) {
        String variableType = getVariableType(input);
        if (variableType != null) {
            int equalIndex = input.indexOf(variableType);
            int varLength = variableType.length();
            if (equalIndex != -1) {
                String modifier = input.substring(0, equalIndex).trim();
                return modifier;
            }
        }
        return null;
    }

    public static String getVariableType(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.matches()) {
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
        int equalIndex = input.indexOf('=');
        if (equalIndex != -1) {
            String initializer = input.substring(equalIndex + 1).trim();
            return initializer;
        } else {
            return null;
        }
    }

    private static Matcher getMatcher(String input) {
        return PATTERN_CUSTOM_VARIABLE.matcher(input);
    }
}
