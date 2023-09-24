package com.monitasker.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import elemental.json.Json;
import elemental.json.JsonObject;

@CssImport("./styles/styles.css")
@PageTitle("Login")
@Route(value = "/login")
public class LoginView extends HorizontalLayout {

    private TextField username;
    private PasswordField password;
    private Button loginButton;

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        username = new TextField("Usuário");
        password = new PasswordField("Senha");
        loginButton = new Button("Login", event -> login());

        add(username, password, loginButton);
    }

    private void login() {
        // Substitua com o endpoint correto e o método HTTP
        String endpoint = "http://localhost:8080/api/login";

        // Crie um objeto com os dados do formulário
        JsonObject json = Json.createObject();
        json.put("username", username.getValue());
        json.put("password", password.getValue());

        // Faça a chamada REST
        fetch(endpoint, json);
    }

    private void fetch(String endpoint, JsonObject json) {
        // Implemente a chamada HTTP e o tratamento da resposta
    }
}