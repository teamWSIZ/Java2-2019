package wsi.tasks;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiverseStringTest {
  DiverseString testee;

  @Before
  public void setUp() throws Exception {
    testee = new DiverseString();
  }

  @Test
  public void simple() {
    assertThat(testee.checkString("abc")).isTrue();
  }
  @Test
  public void singleLetter() {
    assertThat(testee.checkString("a")).isTrue();
  }
  @Test
  public void twoLettersAtDistance() {
    assertThat(testee.checkString("ac")).isFalse();
  }
  @Test
  public void twoAdjacentLetters() {
    assertThat(testee.checkString("ba")).isTrue();
  }
  @Test
  public void threeAdjacentLetters() {
    assertThat(testee.checkString("cba")).isTrue();
  }
  @Test
  public void allLetters() {
    assertThat(testee.checkString("abcdefghijklmnopqrstuvwxyz")).isTrue();
  }
  @Test
  public void doubleLetter() {
    assertThat(testee.checkString("aa")).isFalse();
  }
  @Test
  public void various1() {
    assertThat(testee.checkString("fced")).isTrue();
  }
  @Test
  public void various2() {
    assertThat(testee.checkString("abczz")).isFalse();
  }
  @Test
  public void various3() {
    assertThat(testee.checkString("abcef")).isFalse();
  }
  @Test
  public void various4() {
    assertThat(testee.checkString("efhi")).isFalse();
  }
}
