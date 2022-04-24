package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean {
    private String text;

    @PostConstruct
    private void init(){
        this.text = "Hello I'm a Component";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
