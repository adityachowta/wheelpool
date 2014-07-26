package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.request.LoginRequest;
import models.request.SignupRequest;
import models.response.Message;
import models.user.User;
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
        return ok(views.html.login.render("Login", null));
    }

    public static Result handleLogin() {
        ObjectMapper mapper = new ObjectMapper();


        Map<String, String[]> m = request().body().asFormUrlEncoded();
        if (m == null)
            return badRequest(Json.toJson(new Message(400, "Oops! Invalid login!", Message.MessageType.BAD_REQUEST)));

        //To access form data
        String email = StringUtils.isEmpty(m.get("email")[0]) ? StringUtils.EMPTY : m.get("email")[0];
        String password = StringUtils.isEmpty(m.get("password")[0]) ? StringUtils.EMPTY : m.get("password")[0];
        User user = Ebean.find(User.class).where(
                Expr.and(
                        Expr.eq("email", email),
                        Expr.eq("password", password)
                )
        ).setMaxRows(1).findUnique();
        if(user == null)
            return notFound(Json.toJson(new Message(404, "Oops! Username / password doesn't exists!", Message.MessageType.BAD_REQUEST)));
        try {
            session("user", StringUtils.toString(org.apache.commons.codec.binary.Base64.encodeBase64(mapper.writeValueAsString(user).getBytes()), "UTF-8"));
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
            return internalServerError(Json.toJson(new Message(500, "Oops! Username / password doesn't exists!", Message.MessageType.INTERNAL_SERVER_ERROR)));
        }
        return ok(Json.toJson(new Message(200, "Login successful!", Message.MessageType.SUCCESSFUL)));
    }

    public static Result logout() {
        session().clear();
        return redirect(routes.AuthenticationController.login());
    }
}
