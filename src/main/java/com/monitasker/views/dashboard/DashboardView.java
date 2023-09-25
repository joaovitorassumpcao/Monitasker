package com.monitasker.views.dashboard;

import com.monitasker.model.entity.Task;
import com.monitasker.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Dashboard")
@Route(value = "dashboard", layout = MainLayout.class)
//@PermitAll
@AnonymousAllowed
@Uses(Icon.class)
public class DashboardView extends Composite<VerticalLayout> {


    public static Grid minimalistGrid = new Grid(Task.class);

    public DashboardView() {
        TabSheet tabSheet = new TabSheet();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().addClassName(Gap.XSMALL);
        getContent().addClassName(Padding.XSMALL);
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        tabSheet.setWidthFull();
        getContent().setFlexGrow(1.0, tabSheet);
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, tabSheet);
        setTabSheetData(tabSheet);
        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        setGridSampleData(minimalistGrid);
        getContent().add(tabSheet);
        //getContent().add(minimalistGrid);
    }

    private void setTabSheetData(TabSheet tabSheet) {
        tabSheet.add("Tarefas", new Div(minimalistGrid));
        tabSheet.add("Grupos", new Div(new Text("Placeholder")));
    }

    private void setGridSampleData(Grid grid) {
        // TODO grid.setItems(query -> list(
        //                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
        //        .stream());
    }

}
