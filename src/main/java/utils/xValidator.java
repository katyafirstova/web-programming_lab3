package utils;

import model.HitTable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectOne;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;
import java.util.List;

@FacesValidator("xValidator")
public class xValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        UISelectOne x_coordinate = (UISelectOne) uiComponent.getAttributes().get("pictureClick");
        String str = (String) x_coordinate.getValue();
        double xVal = (Double) o;
        if (!"true".equals(str)) {
            if (xVal >= 5 || xVal <= -3) {
                throw new ValidatorException(new FacesMessage(((UIInput) uiComponent).getValidatorMessage()));
            }
        }
    }
}

