package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.request.SignupRequest;
import models.response.Message;
import models.user.User;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Sagar Gopale on 7/7/14.
 */
public class SignupController extends Controller {

    public static Result signup() {
        return ok(views.html.signup.render("Sign Up", null));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public static Result handleSignup() {
        User u = null;
        SignupRequest sr = null;
        JsonNode body = request().body().asJson();
        if(body != null)
            sr = Json.fromJson(body, SignupRequest.class);
        if(sr == null)
            return badRequest(Json.toJson(new Message(400, "Invalid parameters passed!", Message.MessageType.BAD_REQUEST)));
        u = new User(sr.getFullName(), sr.getEmail(), sr.getPassword(), sr.getPhone());
        u.save();
        return ok(Json.toJson(new Message(200, "Signup successful!", Message.MessageType.SUCCESSFUL)));
    }
}
