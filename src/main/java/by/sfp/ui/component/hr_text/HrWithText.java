package by.sfp.ui.component.hr_text;

import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;

public class HrWithText extends CustomField<String> {
    private String dataContent;
    private TextAlign textAlign;
    private Label label;

    public HrWithText(String dataContent, TextAlign textAlign) {
        this.dataContent = dataContent;
        this.textAlign = textAlign;
    }

    public HrWithText(String dataContent) {
        this(dataContent, null);
    }

    public HrWithText() {
        this("", null);
    }

    public TextAlign getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(TextAlign textAlign) {
        this.textAlign = textAlign;
    }

    @Override
    protected Component initContent() {
        label = new Label("<hr class=\"v-label-hr-text\" " +
                "data-content=\"" + dataContent + "\" " +
                "style=\"" +
                ((textAlign != null) ? textAlign.getTextAlign() : "") +
                "\"/>", ContentMode.HTML);
        label.setStyleName("hr");
        return label;
    }

    @Override
    public String getValue() {
        return dataContent;
    }

    @Override
    public void doSetValue(String value) {
        dataContent = value;
    }
}
