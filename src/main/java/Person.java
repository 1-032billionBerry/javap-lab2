import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Person class represents a person with a name and age.
 */
@Data
@AllArgsConstructor
@RootElement("person")
public class Person {

  @FieldMapping("name")
  private String name;

  @FieldMapping("age")
  private int age;
}
