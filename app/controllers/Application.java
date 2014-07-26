package controllers;

import actions.Authenticated;
import models.user.User;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(views.html.login.render("Login", null));
    }

}
