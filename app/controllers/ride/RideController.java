package controllers.ride;

import actions.Authenticated;
import models.user.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

/**
 * Created by Aditya on 7/26/14.
 */
public class RideController extends Controller {

    @With(Authenticated.class)
    public static Result postRide(){
        User loggedInUser = (User) ctx().args.get("user");
        return ok(views.html.ride.post.render("Post Ride", loggedInUser));
    }

    @With(Authenticated.class)
    public static Result handlePostRide() {
        User loggedInUser = (User) ctx().args.get("user");
        return ok();
    }
}
