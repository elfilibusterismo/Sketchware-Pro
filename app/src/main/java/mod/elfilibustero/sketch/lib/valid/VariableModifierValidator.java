package mod.elfilibustero.sketch.lib.valid;

import a.a.a.MB;
import android.content.Context;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;

public class VariableModifierValidator extends MB {
  public static final Pattern PATTERN_MODIFIER = Pattern.compile("\\b(private\\s?|public\\s?|protected\\s?)?(static\\s?)?(final\\s?)?\\b");

  public VariableModifierValidator(Context context, TextInputLayout textInputLayout) {
    super(context, textInputLayout);
  }
  
  @Override
  public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    String input = charSequence.toString().toLowerCase();
    String trimmedInput = input.trim();
    String[] words = trimmedInput.split("\\s+");
    String reconsInput = String.join(" ", words);
    if (!input.equals(reconsInput)) {
      b.setErrorEnabled(true);
      b.setError("Error: invalid input");
      d = false;
      return;
    }
    if (!PATTERN_MODIFIER.matcher(input).matches()) {
      b.setErrorEnabled(true);
      b.setError("Error: invalid modifier");
      d = false;
      return;
    }
    b.setErrorEnabled(false);
    d = true;
  }
  
  public boolean isValid(){
    return b();
  }
}