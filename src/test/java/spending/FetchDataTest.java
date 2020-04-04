package spending;

import org.junit.Test;

import java.util.List;

public class FetchDataTest {

    @Test
    public void fetchTest(){
        FetchData fetchData = new FetchData();
        List<Payment> fetchData.fetch(100,2020,2);
    }
}
