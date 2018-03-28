package by.sfp.ui.component.combo_box;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class DomainAndClassCategoryComponent extends CustomComponent {
    private DomainCategoryComboBox domainCategory;
    private ClassCategoryComboBox classCategory;

    public DomainAndClassCategoryComponent() {
        VerticalLayout components = new VerticalLayout();
        components.setMargin(false);
        domainCategory = new DomainCategoryComboBox("Сфера услуг компании:", "Выбрать категорию сферы услуг");
        classCategory = new ClassCategoryComboBox("Вид услуг компании:", "Выбрать категорию вида услуг");
        classCategory.setEnabled(false);
        addListeners();
        components.addComponents(domainCategory, classCategory);
        setCompositionRoot(components);
    }

    public DomainAndClassCategoryComponent(boolean domainCategoryRequired, boolean classCategoryRequired) {
        this();
        domainCategory.setRequired(domainCategoryRequired);
        classCategory.setRequired(classCategoryRequired);
    }

    private void addListeners() {
        domainCategory.getComboBox().addSelectionListener(event -> {
            if (event.getSource().isEmpty()) {
                classCategory.getComboBox().setEnabled(false);
                classCategory.getComboBox().deselectAll();
            } else {
                classCategory.getComboBox().setEnabled(true);
            }
        });
    }

}
