import java.lang.reflect.Field;

/**
 * The ReflectionBasedSerializer class provides methods for serializing objects to JSON and XML formats
 * using reflection.
 */
public class ReflectionBasedSerializer {

  /**
   * Serializes an object to JSON format using reflection.
   *
   * @param obj the object to serialize
   * @return the JSON representation of the object
   * @throws IllegalAccessException if the reflection-based serialization encounters an illegal access
   */
  public static String serializeToJson(Object obj) throws IllegalAccessException {
    Class<?> clazz = obj.getClass();
    if (!clazz.isAnnotationPresent(RootElement.class)) {
      throw new IllegalArgumentException("Class must be annotated with @RootElement");
    }

    StringBuilder jsonBuilder = new StringBuilder("{");
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(FieldMapping.class)) {
        field.setAccessible(true);
        String key = field.getAnnotation(FieldMapping.class).value();
        Object value = field.get(obj);
        jsonBuilder.append(String.format("\"%s\": \"%s\",", key, value));
      }
    }
    if (jsonBuilder.charAt(jsonBuilder.length() - 1) == ',') {
      jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
    }
    jsonBuilder.append("}");
    return jsonBuilder.toString();
  }

  /**
   * Serializes an object to XML format using reflection.
   *
   * @param obj the object to serialize
   * @return the XML representation of the object
   * @throws IllegalAccessException if the reflection-based serialization encounters an illegal access
   */
  public static String serializeToXml(Object obj) throws IllegalAccessException {
    Class<?> clazz = obj.getClass();
    if (!clazz.isAnnotationPresent(RootElement.class)) {
      throw new IllegalArgumentException("Class must be annotated with @RootElement");
    }

    StringBuilder xmlBuilder = new StringBuilder();
    RootElement rootElement = clazz.getAnnotation(RootElement.class);
    xmlBuilder.append("<").append(rootElement.value()).append(">");

    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(FieldMapping.class)) {
        field.setAccessible(true);
        String tag = field.getAnnotation(FieldMapping.class).value();
        Object value = field.get(obj);
        xmlBuilder.append(String.format("<%s>%s</%s>", tag, value, tag));
      }
    }
    xmlBuilder.append("</").append(rootElement.value()).append(">");
    return xmlBuilder.toString();
  }
}
