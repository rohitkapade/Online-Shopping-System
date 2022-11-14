package com.Shopping.Services;

import com.Shopping.Exception.LoginException;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Login;

public interface LoginServices {

	public CurrentUserSession login(Login log) throws LoginException;

	public String Logout(String uuid) throws LoginException;
}
