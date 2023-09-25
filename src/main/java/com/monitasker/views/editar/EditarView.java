package com.monitasker.views.editar;

import com.monitasker.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.PermitAll;

@PageTitle("Editar")
@Route(value = "editar", layout = MainLayout.class)
//@PermitAll
@AnonymousAllowed
@Uses(Icon.class)
public class EditarView extends Composite<VerticalLayout> {

    public EditarView() {
        RichTextEditor richTextEditor = new RichTextEditor();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        DateTimePicker dateTimePicker = new DateTimePicker();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Checkbox checkbox = new Checkbox();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        getContent().setFlexGrow(1.0, richTextEditor);
        richTextEditor.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setAlignItems(Alignment.END);
        layoutRow.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setHeightFull();
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth(null);
        dateTimePicker.setLabel("Data de entrega");
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn3.setAlignItems(Alignment.START);
        layoutColumn3.setWidth(null);
        checkbox.setLabel("Feito");
        checkbox.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, checkbox);
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, checkbox);
        getContent().add(richTextEditor);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(dateTimePicker);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(checkbox);
    }
}
