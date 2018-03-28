package by.sfp.ui.component.combo_box;

import by.sfp.domain.ClassCategory;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addons.ComboBoxMultiselect;
import org.vaadin.alump.labelbutton.LabelButton;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class ClassCategoryComboBox extends CustomField<Set<ClassCategory>> {
    private boolean required;
    private Set<ClassCategory> checkedClassCategorySet = new HashSet<>();
    private ComboBoxMultiselect<ClassCategory> comboBox = new ComboBoxMultiselect<>();
    private CssLayout cssLayout;

    public ClassCategoryComboBox() {
    }

    public ClassCategoryComboBox(String caption, String placeholder) {
        setCaption(caption);
        comboBox.setPlaceholder(placeholder);
    }

    @Override
    protected Component initContent() {
        VerticalLayout components = new VerticalLayout();
        components.setMargin(false);
        components.setSpacing(true);

        cssLayout = new CssLayout();
        cssLayout.setWidth("100%");
        cssLayout.setVisible(false);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthUndefined();
        comboBox.setItemCaptionGenerator(ClassCategory::getName);
        comboBox.setTextInputAllowed(false);
        comboBox.setItems(classCategory());
        horizontalLayout.addComponent(comboBox);
        components.addComponents(cssLayout, horizontalLayout);

        addListener();
        return components;
    }

    @Override
    public void doSetValue(Set<ClassCategory> value) {
        checkedClassCategorySet = value;
        if (value != null)
            comboBox.setValue(value);
    }

    @Override
    public Set<ClassCategory> getValue() {
        return checkedClassCategorySet;
    }

    @Override
    public void setEnabled(boolean enabled) {
        comboBox.setEnabled(enabled);
    }

    private Set<ClassCategory> classCategory() {
        Set<ClassCategory> list = new TreeSet<>();
        list.add(new ClassCategory("1", "Item"));
        list.add(new ClassCategory("2", "Item"));
        list.add(new ClassCategory("3", "Item"));
        list.add(new ClassCategory("4", "Item"));
        list.add(new ClassCategory("5", "Item"));
        list.add(new ClassCategory("6", "Item"));
        list.add(new ClassCategory("7", "Item"));
        list.add(new ClassCategory("8", "Item"));
        list.add(new ClassCategory("9", "Item"));
        list.add(new ClassCategory("10", "Item"));
        list.add(new ClassCategory("11", "Item"));
        list.add(new ClassCategory("12", "Item"));
        list.add(new ClassCategory("13", "Item"));
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

    public ComboBoxMultiselect<ClassCategory> getComboBox() {
        return comboBox;
    }

    private void addListener() {
        comboBox.addSelectionListener(event -> {
            if (event.getAllSelectedItems().size() == 0) {
                if (cssLayout.getComponentCount() != 0) {
                    while (cssLayout.getComponentCount() != 0) {
                        cssLayout.removeComponent(cssLayout.getComponent(0));
                    }
                    cssLayout.setVisible(false);
                }
                checkedClassCategorySet = new HashSet<>();
            }
            Optional.of(event.getValue()).get().stream()
                    .filter(classCategory -> !checkedClassCategorySet.contains(classCategory))
                    .forEach(classCategory -> {
                        if (!cssLayout.isVisible()) {
                            cssLayout.setVisible(true);
                        }
                        LabelButton labelButton = new LabelButton(classCategory.getName(), (labelClickEvent) -> {
                            checkedClassCategorySet.remove(classCategory);
                            comboBox.deselect(classCategory);
                            if (checkedClassCategorySet.size() == 0) {
                                cssLayout.setVisible(false);
                            }
                            labelClickEvent.getLabelButton().setVisible(false);
                        });
                        labelButton.setStyleName("closable-label");
                        labelButton.setClickable(true);
                        cssLayout.addComponents(labelButton);
                    });
            checkedClassCategorySet.addAll(event.getValue());
        });
    }
}
