package by.sfp.ui.component.buttons;


import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

public class SfpButton extends Button {
    public SfpButton() {
    }

    public SfpButton(SfpButtonStyle style) {
        setSfpStyle(style);
    }

    public SfpButton(String caption, SfpButtonStyle style) {
        super(caption);
        setSfpStyle(style);
    }

    public SfpButton(Resource icon, SfpButtonStyle style) {
        super(icon);
        setSfpStyle(style);
    }

    public SfpButton(String caption, Resource icon, SfpButtonStyle style) {
        super(caption, icon);
        setSfpStyle(style);
    }

    public SfpButton(String caption, ClickListener listener, SfpButtonStyle style) {
        super(caption, listener);
        setSfpStyle(style);
    }

    public SfpButton(Resource icon, ClickListener listener, SfpButtonStyle style) {
        super(icon, listener);
        setSfpStyle(style);
    }

    public String getSfpStyle() {
        return super.getStyleName();
    }

    public void setSfpStyle(SfpButtonStyle sfpButtonStyle) {
        super.setStyleName(sfpButtonStyle.getStyle());
    }
}