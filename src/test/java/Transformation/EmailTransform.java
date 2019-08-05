// filename: Transformation/EmailTransform

package Transformation;

import cucumber.api.Transformer;

public class EmailTransform extends Transformer<String> {

  @Override
  public String transform(String username) {
    return username.concat("@ea.com");
  }
}
