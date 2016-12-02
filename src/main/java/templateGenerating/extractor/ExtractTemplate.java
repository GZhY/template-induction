package templateGenerating.extractor;

import crawler.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import templateGenerating.beans.Record;
import templateGenerating.beans.Template;

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

    protected Node text2Node(String text) {
        return text2NodeByJsoup(text);
    }

    public String getExpression(String text) {
        Node n = text2Node(text);
        return getExpression(n);
    }

    public abstract Template getTemplate(List<Record> records);

    /**
     * use jsoup selectors, such as:
     * :contains(text), :containsOwn(text), :matches(regex), :matchesOwn(regex),
     * to get <strong>first</strong> corresponding node
     */
    protected Node text2NodeByJsoup(String text) {
        if (text == null || document4Jsoup == null) return null;
        Elements elements = document4Jsoup.select(":containsOwn(" + text + ")");
        Node node = elements.first();
        return node;
    }

    private String findCommmonPrefix(String str1, String str2) {
        int index = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) index++;
            else break;
        }
        return str1.substring(0, index);
    }

    protected List<String> generalizeExpression(List<List<String>> recordExpressions) {
        if (recordExpressions == null || recordExpressions.size() == 0) return null;
        List<String> itemExpressions = new ArrayList<>();
        for (int j = 0; j < recordExpressions.get(0).size(); j++) {
            String str = null;
            for (int i = 0; i < recordExpressions.size(); i++) {
                if (str == null) str = recordExpressions.get(i).get(j);
                else str = findCommmonPrefix(str, recordExpressions.get(i).get(j));
            }
            itemExpressions.add(str);
        }
        return itemExpressions;
    }

    //protected Node text2NodeByXPath(String text) {
    //    // TODO: 2016/11/15 text2Node, Use XPath like //*[text()='text'],
    //    return null;
    //}

}
