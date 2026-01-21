package lk.damithab.practical_4.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import lk.damithab.practical_4.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button continueBtn;

    public CustomDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        if(window != null){
            window.setDimAmount(0.7f);
        }
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        continueBtn = findViewById(R.id.WelcomeScreenContinueBtn);
        continueBtn.setOnClickListener(this);
        setCanceledOnTouchOutside(false);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.WelcomeScreenContinueBtn) {
            dismiss();
        }
    }
}
