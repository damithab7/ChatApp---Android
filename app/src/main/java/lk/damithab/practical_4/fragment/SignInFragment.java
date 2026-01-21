package lk.damithab.practical_4.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lk.damithab.practical_4.R;
import lk.damithab.practical_4.activity.HomeActivity;

public class SignInFragment extends Fragment {

    private EditText emailEditText, passwordEditText;
    private Button signInBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailEditText = view.findViewById(R.id.signInFragmentEmail);
        passwordEditText = view.findViewById(R.id.signInFragmentPassword);
        signInBtn = view.findViewById(R.id.signInBtn);
        signIn();
    }

    private void signIn() {
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email.isEmpty()) {
                    emailEditText.setError("Invalid email format. Please use the format: name@example.com.");
                    return;
                }
                if (password.isEmpty()) {
                    passwordEditText.setError("Password is required.");
                    return;
                }

                Intent intent = new Intent(getContext(), HomeActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}