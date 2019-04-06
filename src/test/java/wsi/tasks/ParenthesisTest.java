package wsi.tasks;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParenthesisTest {
  Parenthesis testee;

  @Before
  public void setUp() throws Exception {
    testee = new Parenthesis();
  }

  @Test
  public void simple() {
    assertThat(testee.checkParenthesis("()")).isTrue();
  }

  @Test
  public void empty() {
    assertThat(testee.checkParenthesis("")).isTrue();
  }

  @Test
  public void twoPairs() {
    assertThat(testee.checkParenthesis("()()")).isTrue();
  }

  @Test
  public void notMatching() {
    assertThat(testee.checkParenthesis("(()")).isFalse();
  }

  @Test
  public void wrongOrder() {
    assertThat(testee.checkParenthesis(")(")).isFalse();
  }

  @Test
  public void tooManyClosedInBetween() {
    assertThat(testee.checkParenthesis("()))((")).isFalse();
  }

  @Test
  public void enclosedBrackets() {
    assertThat(testee.checkParenthesis("(()()()(()))")).isTrue();
  }




}
