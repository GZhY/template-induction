package templateGenerating.extractor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.File;
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

    @Override
    protected String getTemplate(Node n) {
        if (n == null) return null;
        String expression = getExpression(n);
        while ((n = n.parent()) != null && !Objects.equals(n.nodeName(), "body"))
            expression = getExpression(n) + ">" + expression;
        return expression;
    }

    private String getExpression(Node n) {
        String attribute = n.attributes().get("class").replace(" ", ".");
        return Objects.equals(attribute, "") ? n.nodeName() : n.nodeName() + "." + attribute;
    }

}
