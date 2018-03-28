package by.sfp.ui.component.combo_box;

import by.sfp.domain.DomainCategory;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.alump.labelbutton.LabelButton;
import org.vaadin.alump.labelbutton.LabelButtonStyles;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DomainCategoryComboBox extends CustomField<DomainCategory> {
    private boolean required;
    private Optional<DomainCategory> checkedDomainCategory;
    private ComboBox<DomainCategory> comboBox = new ComboBox<>();
    private LabelButton label = new LabelButton();
    private CssLayout cssLayout = new CssLayout();

    public DomainCategoryComboBox() {
    }

    public DomainCategoryComboBox(String caption, String placeholder) {
        comboBox.setPlaceholder(placeholder);
        setCaption(caption);

    }

    @Override
    protected void doSetValue(DomainCategory value) {
        comboBox.setValue(value);
    }

    @Override
    protected Component initContent() {
        VerticalLayout components = new VerticalLayout();
        components.setMargin(false);
        components.setSpacing(true);

        CssLayout cssLayout = new CssLayout();
        cssLayout.setWidthUndefined();
        cssLayout.setVisible(false);
        label.setStyleName("closable-label");
        label.setClickable(true);
        cssLayout.addComponent(label);
        components.addComponent(cssLayout);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthUndefined();
        comboBox.setItemCaptionGenerator(DomainCategory::getName);
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(domainCategories());
        comboBox.setEmptySelectionAllowed(false);
        comboBox.setPageLength(0);
        horizontalLayout.addComponent(comboBox);
        components.addComponent(horizontalLayout);

        comboBox.addValueChangeListener(event -> {
            if (!event.getSource().isEmpty()) {
                checkedDomainCategory = event.getSource().getOptionalValue();
                cssLayout.setVisible(true);
                label.setValue(checkedDomainCategory.map(DomainCategory::getName).orElse(null));
            }
        });

        label.addLabelClickListener(event -> {
            checkedDomainCategory = Optional.empty();
            comboBox.setSelectedItem(checkedDomainCategory.orElse(null));
            cssLayout.setVisible(false);
        });

        return components;
    }

    @Override
    public void setEnabled(boolean enabled) {
        comboBox.setEnabled(enabled);
    }

    private List<DomainCategory> domainCategories() {
        List<DomainCategory> list = new LinkedList<>();
        list.add(new DomainCategory("1", "first"));
        list.add(new DomainCategory("2", "second"));
        list.add(new DomainCategory("3", "third"));
        list.add(new DomainCategory("4", "fourth"));
        list.add(new DomainCategory("5", "fifth"));
        list.add(new DomainCategory("6", "fifth"));
        list.add(new DomainCategory("7", "fifth"));
        list.add(new DomainCategory("8", "fifth"));
        list.add(new DomainCategory("9", "fifth"));
        list.add(new DomainCategory("10", "fifth"));
        list.add(new DomainCategory("11", "fifth"));
        list.add(new DomainCategory("12", "fifth"));
        list.add(new DomainCategory("13", "fifth"));
        return list;
    }

    public void setRequired(boolean required) {
        if (required) {
            addStyleName("required");
        } else {
            removeStyleName("required");
        }
        this.required = required;
    }

    @Override
    public DomainCategory getValue() {
        return checkedDomainCategory.orElse(null);
    }

    public ComboBox<DomainCategory> getComboBox() {
        return comboBox;
    }

    private class MyLabel extends CustomComponent {
//        private CssLayout
    }

}


