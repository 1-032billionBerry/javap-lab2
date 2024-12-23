/**
 * The Main class demonstrates the serialization of objects to JSON and XML formats
 * using both reflection-based and manual serialization methods.
 */
public class Main {

  /**
   * Main entry point of the program.
   */
  public static void main(String[] args) throws IllegalAccessException {
    Person person = new Person("Elon", 53);
    Product product = new Product(100, "Smartphone", "Gadgets");
    Order order = new Order("ORD1234567890", 499.99);

    long start, end;

    start = System.nanoTime();
    System.out.println(ReflectionBasedSerializer.serializeToJson(person));
    System.out.println(ReflectionBasedSerializer.serializeToJson(product));
    System.out.println(ReflectionBasedSerializer.serializeToJson(order));
    System.out.println(ReflectionBasedSerializer.serializeToXml(person));
    System.out.println(ReflectionBasedSerializer.serializeToXml(product));
    System.out.println(ReflectionBasedSerializer.serializeToXml(order));
    end = System.nanoTime();
    System.out.println("Reflection serialization time: " + (end - start) / 1_000_000 + " ms");

    start = System.nanoTime();
    System.out.println(ManualSerializationHelper.toJson(person));
    System.out.println(ManualSerializationHelper.toJson(product));
    System.out.println(ManualSerializationHelper.toJson(order));
    System.out.println(ManualSerializationHelper.toXml(person));
    System.out.println(ManualSerializationHelper.toXml(product));
    System.out.println(ManualSerializationHelper.toXml(order));
    end = System.nanoTime();
    System.out.println("Manual serialization time: " + (end - start) / 1_000_000 + " ms");
  }
}
