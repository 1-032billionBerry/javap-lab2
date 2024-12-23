import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Product class represents a product with an id, title, and category.
 */
@Data
@AllArgsConstructor
@RootElement("product")
public class Product {

  @FieldMapping("id")
  private int id;

  @FieldMapping("title")
  private String title;

  @FieldMapping("category")
  private String category;
}

