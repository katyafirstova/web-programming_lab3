package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("yValidator")
public class YValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        UIInput y_coordinate= (UIInput) uiComponent.getAttributes().get("pictureClick");
        String str = (String) y_coordinate.getValue();
        double yVal = (Double) o;
        if (!"true".equals(str)) {
            if (yVal > 5 || yVal < -3) {
                throw new ValidatorException(new FacesMessage(((UIInput) uiComponent).getValidatorMessage()));
            }
        }

    }
}
