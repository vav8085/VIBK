package dagger.vav.com.daggerpractice;

/**
 * Created by z179905 on 4/27/17.
 */

public interface LoginView {
    public void setUsername(String username);
    public void setPassword(String password);
    public void showProgress();
    public void hideProgress();
    public void showGreyScreen();
    public void hideGreyScreen();
    public void showUserNameError();
    public void showPasswordError();
    public void showLoginSuccess();

}

