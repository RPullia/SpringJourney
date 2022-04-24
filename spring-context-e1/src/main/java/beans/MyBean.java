package beans;

import org.springframework.context.annotation.Bean;

/*
 * A bean class that will be managed by the context.
 *
 * By default it is a Singleton, so if you ask for multiple MyBean in the main, you will always get the same instance
 */

public class MyBean {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
