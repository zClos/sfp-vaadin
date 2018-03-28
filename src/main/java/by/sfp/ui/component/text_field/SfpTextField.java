package by.sfp.ui.component.text_field;

import com.vaadin.ui.TextField;

public class SfpTextField extends TextField {
    private boolean required;


    public SfpTextField() {
    }

    public SfpTextField(String caption) {
        super(caption);
    }

    public SfpTextField(String caption, String placeholder) {
        setPlaceholder(placeholder);
        setCaption(caption);
    }

    public SfpTextField(ValueChangeListener<String> valueChangeListener) {
        super(valueChangeListener);
    }

    public SfpTextField(String caption, ValueChangeListener<String> valueChangeListener) {
        super(caption, valueChangeListener);
    }

    public SfpTextField(String caption, String value, ValueChangeListener<String> valueChangeListener) {
        super(caption, value, valueChangeListener);
    }

    public void setRequired(boolean required) {
        if (required) {
            addStyleName("required");
        } else {
            removeStyleName("required");
        }
        this.required = required;
    }
}
