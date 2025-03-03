package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    public MainLayout() {
        addToNavbar(createHeaderContent());
    }

    private Component createHeaderContent() {
        Header header = new Header();
        header.setSizeFull();

        H3 appName = new H3("CHANGES ARE COMING");
        appName.addClassNames(LumoUtility.Margin.End.AUTO, LumoUtility.FontSize.XLARGE, LumoUtility.Margin.Start.AUTO,
                LumoUtility.Padding.MEDIUM);
        appName.addClassNames(LumoUtility.TextColor.PRIMARY_CONTRAST);
        header.add(appName);
        header.addClassName(LumoUtility.Background.PRIMARY);
        return header;
    }
}
