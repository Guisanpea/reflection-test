package models.reflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassConverter {

    public void convertFromEntity(Object entity, Object form) {
        Field[] fields = entity.getClass().getDeclaredFields();
        String[] entityCapitalizedFields = getCapitalizedFields(fields);

        for (int i = 0; i < fields.length; i++) {
            copyField(entity, form, fields[i].getType(), entityCapitalizedFields[i]);
        }
    }

    private void copyField(Object entity, Object form, Class<?> fieldType, String fieldName) {
        try {
            form.getClass().getMethod("set" + fieldName, fieldType).invoke(
                  form
                  , fieldType.cast(entity.getClass().getMethod("get" + fieldName).invoke(entity))
            );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private String[] getCapitalizedFields(Field[] fields) {
        String[] capitalizedFields = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            capitalizedFields[i] = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        }

        return capitalizedFields;
    }

    private void copyField(Object entity, Object form, Field field) {
        try {
            Object entityField = field.get(entity);
            field.set(form, entityField);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
