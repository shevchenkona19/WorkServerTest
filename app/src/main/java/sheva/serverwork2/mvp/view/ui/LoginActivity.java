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
import sheva.serverwork2.mvp.presenter.activities.LoginActivityPresenter;
import sheva.serverwork2.mvp.view.interfaces.ILoginActivityView;

public class LoginActivity extends MvpAppCompatActivity implements ILoginActivityView{
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvRegisterBtn)
    TextView tvRegister;
    @InjectPresenter
    LoginActivityPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(view -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            presenter.login(username, password);
        });

        tvRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onLogged(TokenEntity token) {
        if (token == null){
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("TOKEN", token);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
