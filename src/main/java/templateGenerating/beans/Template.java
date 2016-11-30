package templateGenerating.beans;

import java.util.List;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class Template {

    private TemplateType type;
    private List<String> expressions;

    public TemplateType getType() {
        return type;
    }

    public void setType(TemplateType type) {
        this.type = type;
    }

    public List<String> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        return "Template{" +
                "type=" + type +
                ", expressions=" + expressions +
                '}';
    }
}
