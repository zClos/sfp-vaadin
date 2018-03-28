package by.sfp.ui.component.text_field;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import java.util.ArrayList;
import java.util.List;

public class AddressField extends CustomField<List<String>> {
    private TextField street = new TextField();
    private TextField building = new TextField();
    private TextField block = new TextField();

    @Override
    protected Component initContent() {
        HorizontalLayout components = new HorizontalLayout();
        components.setWidth(100, Unit.PERCENTAGE);
        components.setSpacing(true);
        components.setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);
        street.setStyleName("street");
        building.setStyleName("address-detail");
        block.setStyleName("address-detail");
        building.setEnabled(false);
        block.setEnabled(false);

        street.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                building.setEnabled(false);
            } else {
                building.setEnabled(true);
            }
        });

        building.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                block.setEnabled(false);
            } else {
                block.setEnabled(true);
            }
        });

        components.addComponents(street, building, block);
        return components;
    }

    @Override
    protected void doSetValue(List<String> value) {
        if (value != null) {
            if (value.size() == 1) {
                street.setValue(value.get(0));
            } else if (value.size() == 2) {
                street.setValue(value.get(0));
                building.setValue(value.get(1));
            } else {
                street.setValue(value.get(0));
                building.setValue(value.get(1));
                block.setValue(value.get(2));
            }
        }
    }

    public void setDefaultCaptionAndPlaceholders() {
        street.setCaption("Адрес");
        street.setPlaceholder("Улица/проспект");
        building.setPlaceholder("Дом");
        block.setPlaceholder("Корпус");
    }

    @Override
    public List<String> getValue() {
        List<String> list = new ArrayList<>(3);
        list.add(street.getValue());
        list.add(building.getValue());
        list.add(block.getValue());
        return list;
    }

    @Override
    public String getCaption() {
        return street.getCaption();
    }

    @Override
    public void setCaption(String caption) {
        street.setCaption(caption);
    }

    public String getStreetPlaceholder() {
        return street.getPlaceholder();
    }

    public void setStreetPlaceholder(String placeholder) {
        street.setPlaceholder(placeholder);
    }

    public String getBuildingPlaceholder() {
        return building.getPlaceholder();
    }

    public void setBuildingPlaceholder(String placeholder) {
        building.setPlaceholder(placeholder);
    }

    public String getBlockPlaceholder() {
        return block.getPlaceholder();
    }

    public void setBlockPlaceholder(String placeholder) {
        block.setPlaceholder(placeholder);
    }
}
