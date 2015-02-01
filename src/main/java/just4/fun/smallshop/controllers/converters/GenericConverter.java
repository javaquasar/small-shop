package just4.fun.smallshop.controllers.converters;

/**
 * Created by zinchenko on 01.02.15.
 */
public interface GenericConverter<Model, Form> {

    Model formToModel(Form form);

    Form modelToForm(Model model);

}
