package by.sfp.ui.component.buttons;

public enum SfpButtonStyle {
    ONE("one"),
    TWO("two"),
    THREE("tree");

    private String style;
    SfpButtonStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
