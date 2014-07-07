package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.request.LoginRequest;
import models.response.Message;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Map;

/**
 * Created by Sagar Gopale on 7/5/14.
 */
public class AuthenticationController extends Controller {

    public static Result login() {
        return ok(views.html.login.render("Login"));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public static Result handleLogin() {
        Map<String, String[]> m = request().body().asFormUrlEncoded();
        if (m == null)
            return badRequest(Json.toJson(new Message(400, "Oops! Invalid login!", Message.MessageType.BAD_REQUEST)));
        String email = StringUtils.isEmpty(m.get("email")[0]) ? StringUtils.EMPTY : m.get("email")[0];
        String password = StringUtils.isEmpty(m.get("password")[0]) ? StringUtils.EMPTY : m.get("password")[0];
        Logger.info("USERNAME : " + email);
        Logger.info("PASSWORD : " + password);
        return ok(Json.toJson(new Message(200, "Login successful!", Message.MessageType.SUCCESSFUL)));
    }

    public static Result signup() {
        return ok(views.html.signup.render("Sign Up"));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public static Result handleSignup() {
        return ok(Json.toJson(new Message(200, "Signup successful!", Message.MessageType.SUCCESSFUL)));
    }

}
