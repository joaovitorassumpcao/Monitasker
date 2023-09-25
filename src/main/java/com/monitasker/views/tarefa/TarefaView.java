package com.monitasker.views.tarefa;

import com.monitasker.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.PermitAll;

@PageTitle("Tarefa")
@Route(value = "tarefa", layout = MainLayout.class)
//@PermitAll
@AnonymousAllowed
@Uses(Icon.class)
public class TarefaView extends Composite<VerticalLayout> {

    public TarefaView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H4 h4 = new H4();
        Paragraph textMedium = new Paragraph();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Paragraph textSmall = new Paragraph();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        Paragraph textSmall2 = new Paragraph();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().addClassName(Padding.XSMALL);
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidthFull();
        h4.setText("Titulo");
        textMedium.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.LARGE);
        layoutRow.addClassName(Padding.XSMALL);
        textSmall.setText("Criado: 00/00/0000");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        textSmall2.setText("Entrega: 00/00/0000");
        textSmall2.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h4);
        layoutColumn2.add(textMedium);
        getContent().add(layoutRow);
        layoutRow.add(textSmall);
        layoutRow.add(layoutRow2);
        layoutRow2.add(textSmall2);
    }
}