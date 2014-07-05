package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.request.LoginRequest;
import play.Logger;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

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
        LoginRequest lr = null;
        JsonNode body = request().body().asJson();
        if(body != null)
            lr = Json.fromJson(body, LoginRequest.class);
        if(lr == null)
            return badRequest();
        Logger.info("USERNAME : " + lr.getUsername());
        Logger.info("PASSWORD : " + lr.getPassword());
        return ok();
    }
}
