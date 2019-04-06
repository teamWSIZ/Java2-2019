package wsi.various;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

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
        Assertions.assertThat(wynik).isEqualTo(23);
    }
}
