

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SweetServiceTest {

    private SweetService sweetService;

    @BeforeEach
    void setUp() {
        sweetService = new SweetService();
    }

    @Test
    void testAddAndViewSweet() {
        Sweet sweet = new Sweet(1, "Kaju Katli", "Nut-Based", 50, 10);
        sweetService.addSweet(sweet);
        assertEquals(1, sweetService.getAllSweets().size());
    }

    @Test
    void testSearchByName() {
        sweetService.addSweet(new Sweet(1, "Kaju Katli", "Nut-Based", 50, 10));
        List<Sweet> results = sweetService.searchByName("Kaju Katli");
        assertEquals(1, results.size());
    }

    @Test
    void testPurchaseSweetSuccess() {
        Sweet sweet = new Sweet(1, "Gulab Jamun", "Milk-Based", 20, 10);
        sweetService.addSweet(sweet);
        sweetService.purchaseSweet(1, 5);
        assertEquals(5, sweetService.getAllSweets().get(0).getQuantity());
    }

    @Test
    void testRestockSweet() {
        Sweet sweet = new Sweet(1, "Rasgulla", "Milk-Based", 30, 5);
        sweetService.addSweet(sweet);
        sweetService.restockSweet(1, 10);
        assertEquals(15, sweetService.getAllSweets().get(0).getQuantity());
    }

    @Test
    void testDeleteSweet() {
        Sweet sweet = new Sweet(1, "Halwa", "Vegetable-Based", 25, 12);
        sweetService.addSweet(sweet);
        sweetService.deleteSweet(1);
        assertTrue(sweetService.getAllSweets().isEmpty());
    }
}
