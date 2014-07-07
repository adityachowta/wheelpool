package controllers.home;

import actions.Authenticated;
import models.user.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

/**
 * Created by Sagar Gopale on 7/7/14.
 */
public class HomeController extends Controller {

    @With(Authenticated.class)
    public static Result home() {
        User loggedInUser = (User) ctx().args.get("user");
        return ok(views.html.home.render("Home", loggedInUser));
    }


}
