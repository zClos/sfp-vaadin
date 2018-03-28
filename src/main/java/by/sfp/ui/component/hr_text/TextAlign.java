package by.sfp.ui.component.hr_text;

public enum TextAlign {
    LEFT("left"),
    RIGHT("right"),
    CENTER("center");

    private String textAlignProperties = "text-align:";
    private String textAlignValue;

    TextAlign(String textAlignValue) {
        this.textAlignValue = textAlignValue;
    }

    public String getTextAlign() {
        return textAlignProperties + textAlignValue;
    }
}
