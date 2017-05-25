package sheva.serverwork2.mvp.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import sheva.serverwork2.R;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.presenter.activities.RegisterActivityPresenter;
import sheva.serverwork2.mvp.view.interfaces.IRegisterActivityView;

public class RegisterActivity extends MvpAppCompatActivity implements IRegisterActivityView{
    @BindView(R.id.etRegisterEmail)
    EditText etEmail;
    @BindView(R.id.etRegisterPassword)
    EditText etPassword;
    @BindView(R.id.etRegisterUsername)
    EditText etUsername;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.tvRegisterToLogin)
    TextView tvToLogin;
    @InjectPresenter
    RegisterActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        tvToLogin.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        btnRegister.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            presenter.register(username, password, email);
        });
    }

    @Override
    public void onRegistred(TokenEntity tokenEntity) {
        if (tokenEntity == null){
            Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("TOKEN", tokenEntity);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
