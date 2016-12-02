package templateGenerating.extractor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import templateGenerating.beans.Record;
import templateGenerating.beans.Template;
import templateGenerating.beans.TemplateType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class ExtractSelector extends ExtractTemplate {

    public ExtractSelector(String html2Extract) {
        super(html2Extract);
    }

    public ExtractSelector(File file2Extract) {
        super(file2Extract);
    }

    public ExtractSelector(Document document4Jsoup) {
        super(document4Jsoup);
    }

    private String getExpressionHelper(Node n) {
        String attribute = n.attributes().get("class").trim().replace(" ", ".");
        return Objects.equals(attribute, "") ? n.nodeName() : n.nodeName() + "." + attribute;
    }

    @Override
    protected String getExpression(Node n) {
        if (n == null) return null;
        String expression = getExpressionHelper(n);
        while ((n = n.parent()) != null && !Objects.equals(n.nodeName(), "body")) {
            expression = getExpressionHelper(n) + ">" + expression;
        }
        return expression;
    }

    @Override
    public Template getTemplate(List<Record> records) {
        Template template = new Template();
        template.setType(TemplateType.Selector);
        List<List<String>> recordExpressions = new ArrayList<>();
        records.forEach(record -> {
            List<String> itemExpressions = new ArrayList<>();
            record.getItems().forEach(s -> itemExpressions.add(getExpression(s)));
            recordExpressions.add(itemExpressions);
        });
        template.setExpressions(generalizeExpression(recordExpressions));
        return template;
    }

}
