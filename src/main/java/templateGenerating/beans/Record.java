package templateGenerating.beans;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Record() {

    }

    public Record(Object o, Class<?> c) {
        fields2Items(o, c);
    }

    public void fields2Items(Object o, Class<?> c) {
        items = new ArrayList<>();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            // 如果不为空，设置可见性，然后返回
            field.setAccessible(true);
            try {
                // 设置字段可见，即可用get方法获取属性值。
                items.add((String) field.get(o));
            } catch (Exception e) {
                System.out.println("error--------" + ".Reason is:" + e.getMessage());
            }
        }
    }
}
