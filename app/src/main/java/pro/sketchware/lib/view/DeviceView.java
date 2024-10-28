package pro.sketchware.lib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import a.a.a.GB;

import com.sketchware.remod.databinding.DeviceViewBinding;

import pro.sketchware.utility.SketchwareUtil;

public class DeviceView extends RelativeLayout {
    private DeviceViewBinding binding;
    private ViewGroup statusBar;
    private Toolbar toolbar;

    private Paint paint;

    public DeviceView(Context context) {
        super(context);
        init(context);
    }

    public DeviceView(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        binding = DeviceViewBinding.inflate(LayoutInflater.from(context), this, true);
        statusBar = binding.statusBar;
        statusBar.setLayoutParams(
                new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_PARENT, GB.f(context)));
        toolbar = binding.toolbar;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(SketchwareUtil.getDip(1));
        paint.setColor(Color.parseColor("#5e5e5e"));
    }

    public ViewGroup getStatusBar() {
        return binding.statusBar;
    }

    public TextView getFileName() {
        return binding.fileName;
    }

    public Toolbar getToolbar() {
        return binding.toolbar;
    }

    public void setStatusBarVisibility(boolean isVisible) {
        statusBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public void setToolbarVisibility(boolean isVisible) {
        toolbar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public void addContainer(View view) {
        binding.container.addView(view);
    }
    
    public void removeContainer() {
        binding.container.removeAllViews();
    }
    /*
    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        super.dispatchDraw(canvas);
    }*/
}
