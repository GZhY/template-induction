package templateGenerating.extractor;

import crawler.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import templateGenerating.beans.Record;
import templateGenerating.beans.Template;
import utils.SimilarityHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public abstract class ExtractTemplate {

    protected org.jsoup.nodes.Document document4Jsoup;
    private static final String LATERDISPOSETAG = " the-text-correspond-to-2-or-more-nodes;:";

    public ExtractTemplate(String html2Extract) {
        this.document4Jsoup = Parser.html2Document(html2Extract);
    }

    public ExtractTemplate(File file2Extract) {
        this.document4Jsoup = Parser.file2Document(file2Extract);
    }

    public ExtractTemplate(Document document4Jsoup) {
        this.document4Jsoup = document4Jsoup;
    }

    protected abstract String getExpression(Node n);

    private Elements text2Node(String text) {
        return text2NodeByJsoup(text);
    }

    public String getExpression(String text) {
        Elements elements = text2Node(text);
        if (elements == null || elements.size() == 0) return getExpression((Node) null);
        if (elements.size() == 1) return getExpression(elements.first());
        return LATERDISPOSETAG + text;
    }

    public abstract Template getTemplate(List<Record> records);

    /**
     * Use jsoup selectors, such as:
     * :contains(text), :containsOwn(text), :matches(regex), :matchesOwn(regex),
     * (Use XPath like //*[text()='text'])
     * to get <strong>all</strong> corresponding nodes
     */
    private Elements text2NodeByJsoup(String text) {
        if (text == null || document4Jsoup == null) return null;
        return document4Jsoup.select(":containsOwn(" + text + ")");
    }

    private String mostSimilarExpression(List<String> expressions, List<String> otherExpressions) {
        double maxSimilarity = 0;
        String result = "";
        for (String expression : expressions) {
            double sim = 0;
            for (String otherExpression : otherExpressions) {
                double temp = SimilarityHelper.pathSimilarity(expression, otherExpression);
                if (temp > sim) sim = temp;
            }
            if (sim > maxSimilarity) {
                maxSimilarity = sim;
                result = expression;
            }
        }
        return result;
    }

    // TODO: 2016/12/5 remove xpath
    protected List<String> generalizeExpression(List<List<String>> recordExpressions) {
        if (recordExpressions == null || recordExpressions.size() == 0) return null;

        for (List<String> recordExpression : recordExpressions) { //填充所有未唯一判断出的模板
            for (int i = 0; i < recordExpression.size(); i++) {
                String itemExpression = recordExpression.get(i);
                if (itemExpression != null && itemExpression.startsWith(LATERDISPOSETAG)) {
                    List<String> expressions = new ArrayList<>();
                    Elements elements = text2Node(itemExpression.replaceFirst(LATERDISPOSETAG, ""));
                    elements.forEach(element -> expressions.add(getExpression(element)));
                    recordExpression.set(i, mostSimilarExpression(expressions, recordExpression));
                }
            }
        }

        List<String> itemExpressions = new ArrayList<>();
        for (int j = 0; j < recordExpressions.get(0).size(); j++) {
            String str = null;
            for (int i = 0; i < recordExpressions.size(); i++) {
                String temp = recordExpressions.get(i).get(j);
                if (str == null) str = temp;
                else if (temp != null) str = SimilarityHelper.findCommmonPrefix(str, temp);
            }
            itemExpressions.add(str);
        }
        return itemExpressions;
    }
}
