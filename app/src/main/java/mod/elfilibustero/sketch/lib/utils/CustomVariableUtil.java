package mod.elfilibustero.sketch.lib.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomVariableUtil {
  public static final Pattern PATTERN_VARIABLE = Pattern.compile("\\b(private|public|protected)?\\s?(static)?\\s?(final)?\\s?([\\w\\d_$<>]+(?:\\s*,\\s*[\\w\\d_$<>]+)*(?:\\[\\])*)\\s+([\\w\\d_$]+)\\b");
  public static final int VARIABLE_TYPE = 4;
  public static final int VARIABLE_NAME = 5;

  public static String getVariableType(String input) {
    Matcher matcher = getMatcher(input);
    if (matcher.find()) {
      return matcher.group(VARIABLE_TYPE);
    }
    return input;
  }

  public static String getVariableName(String input) {
    Matcher matcher = getMatcher(input);
    if (matcher.find()) {
      return matcher.group(VARIABLE_NAME);
    }
    return input;
  }

  private static Matcher getMatcher(String input) {
    return PATTERN_VARIABLE.matcher(input);
  }
}