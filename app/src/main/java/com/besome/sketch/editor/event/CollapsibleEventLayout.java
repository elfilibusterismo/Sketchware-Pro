package com.besome.sketch.editor.event;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;

import com.besome.sketch.lib.base.CollapsibleLayout;
import com.sketchware.remod.R;

import java.util.Set;

public class CollapsibleEventLayout extends CollapsibleLayout {
    private CollapsibleButton delete;
    private CollapsibleButton addToCollection;

    public CollapsibleEventLayout(Context context) {
        super(context);
    }

    public CollapsibleEventLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected Set<CollapsibleButton> initializeButtons(@NonNull Context context) {
        CollapsibleButton reset = CollapsibleButton.create(context, 0, R.drawable.ic_reset_color_32dp, R.string.common_word_reset);
        delete = CollapsibleButton.create(context, 1, R.drawable.delete_96, R.string.common_word_delete);
        addToCollection = CollapsibleButton.create(context, 2, R.drawable.ic_bookmark_red_48dp, R.string.logic_list_menu_add_to_collection);
        addToCollection.setVisibility(GONE);
        return Set.of(reset, delete, addToCollection);
    }

    public void b() {
        delete.setVisibility(GONE);
    }

    public void c() {
        addToCollection.setVisibility(GONE);
    }

    public void e() {
        delete.setVisibility(VISIBLE);
    }

    public void f() {
        addToCollection.setVisibility(VISIBLE);
    }
}