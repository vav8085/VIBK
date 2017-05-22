package dagger.vav.com.daggerpractice;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by z179905 on 4/27/17.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginModel.OnLoginFinishedListener {
    LoginView view;
    LoginModel model;
    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        model = new LoginModelImpl();
    }

    @Override
    public void startLogin(String username, String password) {
        view.showGreyScreen();
        view.showProgress();
        model.doLogin(username,password,this);
    }


    @Override
    public void onUsernameError() {
        view.showUserNameError();
        hideLoading();
    }

    @Override
    public void onPasswordError() {
        view.showPasswordError();
       hideLoading();
    }

    @Override
    public void onSuccess() {
        view.showLoginSuccess();
       hideLoading();
    }

    public void hideLoading(){
        view.hideGreyScreen();
        view.hideProgress();
    }
}
