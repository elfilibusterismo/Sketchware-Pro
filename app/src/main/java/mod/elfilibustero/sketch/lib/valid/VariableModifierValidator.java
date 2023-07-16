package mod.elfilibustero.sketch.lib.valid;

import a.a.a.MB;
import android.content.Context;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;

public class VariableModifierValidator extends MB {
    public static final Pattern PATTERN_MODIFIER = Pattern.compile("\\b((public|protected|private)|static|final)(?!.*\\b\\1\\b)(\\s+((public|protected|private)|static|final)(?!.*\\b\\3\\b)){0,2}\\b");

    public VariableModifierValidator(Context context, TextInputLayout textInputLayout) {
        super(context, textInputLayout);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        String input = charSequence.toString().toLowerCase();
        if (!PATTERN_MODIFIER.matcher(input).matches()) {
            b.setErrorEnabled(true);
            b.setError("Invalid modifier");
            d = false;
            return;
        }
        b.setErrorEnabled(false);
        b.setError(null);
        d = true;
    }

    public boolean isValid() {
        return b();
    }
}
