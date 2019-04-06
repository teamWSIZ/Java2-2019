package wsi.various;


import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionXTest {
    SolutionX testee;

    @Before
    public void setUp() throws Exception {
        testee = new SolutionX();
    }

    @Test
    public void shouldAddSimpleNumbers() {
        //arrange
        int x = 11;
        int y = 12;
        //act
        int wynik = testee.add(x,y);

        //assert
        assertThat(wynik).isEqualTo(23);
    }

  @Test
  public void shouldAddNegativeNumbers() {
    int x = -10;
    int y = -1000;
    int wynik = testee.add(x,y);

    assertThat(wynik).isEqualTo(x+y);
  }

  @Test
  public void shouldComareDoubles() {
    double x = 1.009;
    double pi = 1.00;

    assertThat(x).isCloseTo(pi, Percentage.withPercentage(1));
  }

  @Test
  public void shouldCompareLists() {
    List<String> w = Arrays.asList("aa", "bb", "cc");

    assertThat(w).contains("bb");
    assertThat(w).containsExactlyInAnyOrder("cc", "bb", "aa");
  }

  @Test(expected = RuntimeException.class)
  public void expectException() {
    int x = 10;
    int y = 0;

    int wynik = x / y;
  }

  //Mock-owanie ... biblioteka mockito ...
}
