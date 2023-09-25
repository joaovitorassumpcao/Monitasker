package com.monitasker.views.cadastro;

import com.monitasker.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Cadastro")
@Route(value = "cadastro", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class CadastroView extends Composite<VerticalLayout> {

    public CadastroView() {
        H3 h3 = new H3();
        TextField textField = new TextField();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();
        Select select = new Select();
        Button buttonPrimary = new Button();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().addClassName(Gap.XSMALL);
        getContent().addClassName(Padding.XSMALL);
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        h3.setText("Cadastro");
        textField.setLabel("Username");
        emailField.setLabel("Email");
        passwordField.setLabel("Password");
        select.setLabel("Tipo");
        setSelectSampleData(select);
        buttonPrimary.setText("Cadastrar");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(h3);
        getContent().add(textField);
        getContent().add(emailField);
        getContent().add(passwordField);
        getContent().add(select);
        getContent().add(buttonPrimary);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
