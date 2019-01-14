import models.User;
import models.UserForm;
import models.reflectionUtils.ClassConverter;

public class Main {
    public static void main(String[] args) {
        User entity = new User();
        UserForm form = new UserForm();
        ClassConverter classConverter = new ClassConverter();

        classConverter.convertFromEntity(entity, form);

        System.out.println(form);
    }
}
