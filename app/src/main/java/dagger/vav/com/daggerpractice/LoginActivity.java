package dagger.vav.com.daggerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.user_name) EditText userName;
    @BindView(R.id.password) EditText passWord;
    @BindView(R.id.login_button) Button loginButton;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.grey_screen) FrameLayout greyScreen;
    //Resources
    @BindString(R.string.user_cannot_be_blank) String userNotBlank;
    @BindString(R.string.password_not_blank) String passwordNotBlank;
    @BindString(R.string.login_success) String loginSuccess;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //No Need for Assigning views
        ButterKnife.bind(this);
        //Init Variables
        initVariables();

    }

    @OnClick(R.id.login_button)
    public void loginClicked(View view){
        presenter.startLogin(userName.getText().toString(),passWord.getText().toString());
    }

    private void initVariables() {
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void setUsername(String username) {
        userName.setText(username);
    }

    @Override
    public void setPassword(String password) {
        passWord.setText(password);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showGreyScreen() {
        greyScreen.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideGreyScreen() {
        greyScreen.setVisibility(View.GONE);
    }

    @Override
    public void showUserNameError() {
        Toast.makeText(this,userNotBlank,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError() {
        Toast.makeText(this,passwordNotBlank,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this,loginSuccess,Toast.LENGTH_SHORT).show();
    }

}
