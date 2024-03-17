package CollectionManager;

import Data.DataProvider;
import SpaceMarines.SpaceMarine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Отлавливает строку пользователя и выполняет команды
 */
public class CollectionManager {
    LinkedHashSet<SpaceMarine> collection;

    /**
     *
     */
    public CollectionManager() {
        this.collection = DataProvider.Load();
        if (this.collection == null)
            this.collection = new LinkedHashSet<>();
    }

    public LinkedHashSet<SpaceMarine> get() { return this.collection; }

    public String info() {
        LocalDate date;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size: ").append(this.collection.size()).append("\n");
        stringBuilder.append("Type: ").append(this.collection.getClass()).append("\n");
        SpaceMarine[] values = this.collection.toArray(SpaceMarine[]::new);

        if (!this.collection.isEmpty()) {
            LocalDate maxDate = values[0].getDate();

            for (SpaceMarine sp : values) {
                if (maxDate.isBefore(sp.getDate())) {
                    maxDate = sp.getDate();
                }
            }
            stringBuilder.append("Data of editing: ").append(maxDate).append("\n");

        }
        return String.valueOf(stringBuilder);
    }

    public SpaceMarine[] show() {
        return this.collection.toArray(SpaceMarine[]::new);
    }

    public void add() {
        this.collection.add(new SpaceMarine());
    }

    public void update_id(Integer id) {
        boolean flag = false;

        for (SpaceMarine sp: this.collection) {
            if (sp.getId() == id) {
                this.collection.remove(sp);
                this.collection.add(new SpaceMarine());
                flag = true;
                System.out.println("SpaceMarine обновлен!");
                break;
            }
        }
        if (!flag)
            System.out.println("SpaceMarine не обновлен!");
    }

    public void remove_by_id(Integer id) {
        boolean flag = false;
        for (SpaceMarine sp: this.collection) {
            if (sp.getId() == id) {
                this.collection.remove(sp);
                flag = true;
                System.out.println("SpaceMarine удален!");
                break;
            }
        }
        if (!flag)
            System.out.println("SpaceMarine не удален!");
    }

    public void clear() {
        this.collection.clear();
    }


}
