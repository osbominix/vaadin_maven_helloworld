/**
 * @author yl
 *
 * create a simple vaadin project in maven
 *
 * by click on button, the times will be counted and shown in the label above.
 */
package osbominix.example;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import javax.servlet.annotation.WebServlet;

@Title("My vaadin project in maven")
@Theme("valo")
public class SimpleUI extends UI {
    private static final long serialVersionUID = 511085335415683713L;
    private int count = 0;
    private Label label = new Label("Hello World!");

    @Override
    protected void init(VaadinRequest request) {
        // Create the content root layout for the UI
        HorizontalLayout content = new HorizontalLayout();
        setContent(content);

        // Have a clickable button
        Button btn = new Button("Push Me!");


        btn.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 5808429544582385114L;
            public void buttonClick(ClickEvent event) {
                count = count + 1;
                label.setValue("Pushed " + count + " time!");
            }
        });

        content.addComponent(btn);

        // Display the greeting
        content.addComponent(label);

        content.setWidth("350px");
        content.setMargin(true);


    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = false,
            ui = SimpleUI.class)
    public static class Servlet extends VaadinServlet {
    }

}
