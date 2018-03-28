package by.sfp.ui.service_provider.creation;

import by.sfp.ui.component.buttons.SfpButton;
import by.sfp.ui.component.buttons.SfpButtonStyle;
import by.sfp.ui.component.combo_box.DomainAndClassCategoryComponent;
import by.sfp.ui.component.hr_text.HrWithText;
import by.sfp.ui.component.hr_text.TextAlign;
import by.sfp.ui.component.text_field.AddressField;
import by.sfp.ui.component.text_field.SfpTextField;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("sfp")
public class ServiceProviderCreationPage extends UI {

    private HorizontalLayout root;
    private SfpTextField serviceProvider;
    private SfpTextField city;
    private AddressField address;
    private SfpTextField mobile;
    private SfpTextField phone;
    private SfpTextField email;
    private SfpTextField site;
    private Button saveButton;
    private DomainAndClassCategoryComponent categoryComponent;

    @Override
    protected void init(VaadinRequest request) {
        root = new HorizontalLayout();
        addForm();
        root.setMargin(true);
        setContent(root);
    }

    private void addForm() {

        VerticalLayout form = new VerticalLayout();
        form.setStyleName("service_provider_creation");

        HrWithText hrRequired = new HrWithText("Обязательные поля", TextAlign.RIGHT);

        serviceProvider = new SfpTextField("Наименование компании:", "Наименование поставщика услуг");
        serviceProvider.setRequired(true);
        categoryComponent = new DomainAndClassCategoryComponent(true,true);
        city = new SfpTextField("Город:", "Город поставщика услуг");
        city.setRequired(true);

        HrWithText hrOneOfRequired = new HrWithText("Минимум одно из пяти полей должно быть заполнено", TextAlign.RIGHT);

        address = new AddressField();
        address.setDefaultCaptionAndPlaceholders();
        mobile = new SfpTextField("Номер мобильного телефона", "+ ___ (__) ___-__-__");
        phone = new SfpTextField("Номер стационарного телефона", "+ ___ (__) ___-__-__");
        email = new SfpTextField("E-mail поставщика услуг", "name@example.com");
        site = new SfpTextField("Сайт поставщика услуг", "www.name.com");

        CheckBoxGroup<String> boxGroup = new CheckBoxGroup<>();
        boxGroup.setItems("one", "two", "three");
        saveButton = new SfpButton("Сохранить", SfpButtonStyle.ONE);


        form.addComponents(hrRequired, serviceProvider, categoryComponent, city);
        form.addComponents(hrOneOfRequired, address, mobile, phone, email, site);
        form.addComponents(boxGroup, saveButton);

        root.addComponent(form);
    }
}
