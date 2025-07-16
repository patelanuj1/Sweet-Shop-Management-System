

import com.sweetshop.model.Sweet;
import java.util.*;
import java.util.stream.Collectors;

public class SweetService {
    private final Map<Integer, Sweet> inventory = new HashMap<>();

    public void addSweet(Sweet sweet) {
        if (inventory.containsKey(sweet.getId()))
            throw new IllegalArgumentException("Sweet with this ID already exists.");
        inventory.put(sweet.getId(), sweet);
    }

    public void deleteSweet(int id) {
        inventory.remove(id);
    }

    public List<Sweet> getAllSweets() {
        return new ArrayList<>(inventory.values());
    }

    public List<Sweet> searchByName(String name) {
        return inventory.values().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Sweet> searchByCategory(String category) {
        return inventory.values().stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Sweet> searchByPriceRange(double min, double max) {
        return inventory.values().stream()
                .filter(s -> s.getPrice() >= min && s.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public void purchaseSweet(int id, int quantity) {
        Sweet sweet = inventory.get(id);
        if (sweet == null || sweet.getQuantity() < quantity)
            throw new IllegalArgumentException("Not enough stock or sweet not found.");
        sweet.setQuantity(sweet.getQuantity() - quantity);
    }

    public void restockSweet(int id, int quantity) {
        Sweet sweet = inventory.get(id);
        if (sweet == null)
            throw new IllegalArgumentException("Sweet not found.");
        sweet.setQuantity(sweet.getQuantity() + quantity);
    }

    public List<Sweet> sortByPrice(boolean ascending) {
        return inventory.values().stream()
                .sorted(Comparator.comparingDouble(Sweet::getPrice)
                        .reversed().reversed())
                .collect(Collectors.toList());
    }
}
