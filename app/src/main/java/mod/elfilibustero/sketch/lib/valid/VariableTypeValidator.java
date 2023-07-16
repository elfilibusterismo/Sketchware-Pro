package mod.elfilibustero.sketch.lib.valid;

import a.a.a.MB;
import android.content.Context;
import android.text.TextUtils;
import java.util.regex.Pattern;
import com.google.android.material.textfield.TextInputLayout;

public class VariableTypeValidator extends MB {
    public static final Pattern PATTERN_TYPE = Pattern.compile("^([a-zA-Z0-9]+)(<([a-zA-Z<>]+(?:\\s*,(?!.*?,)\\s*[a-zA-Z<>]+)*)>)?(\\[\\])?$");

    public VariableTypeValidator(Context context, TextInputLayout textInputLayout) {
        super(context, textInputLayout);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        String variableName = charSequence.toString().trim();
        if (!TextUtils.isEmpty(charSequence)) {
            if (!Character.isLetter(charSequence.charAt(0))) {
                b.setErrorEnabled(true);
                b.setError("Variable type must start with letter");
                d = false;
            }
        }
        if (!PATTERN_TYPE.matcher(variableName).matches()) {
            b.setErrorEnabled(true);
            b.setError("Invalid variable type");
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
