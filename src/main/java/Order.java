import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Order class represents an order with an order number and price.
 */
@Data
@AllArgsConstructor
@RootElement("order")
public class Order {

  @FieldMapping("orderNumber")
  private String orderNumber;

  @FieldMapping("price")
  private double price;
}