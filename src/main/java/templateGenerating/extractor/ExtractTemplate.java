package templateGenerating.extractor;

import crawler.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public abstract class ExtractTemplate {

    //protected String html2Extract;
    //private Document document4w3c;
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

    protected abstract String getTemplate(final Node n);

    public String getTemplate(String text) {
        Node n = text2Node(text);
        return getTemplate(n);
    }

    protected Node text2Node(String text) {
        return text2NodeByJsoup(text);
    }

    /**
     * use jsoup selectors, such as:
     * :contains(text), :containsOwn(text), :matches(regex), :matchesOwn(regex),
     * to get <strong>first</strong> corresponding node
     */
    protected Node text2NodeByJsoup(String text) {
        if(text == null || document4Jsoup == null) return null;
        Elements elements = document4Jsoup.select(":containsOwn(" + text + ")");
        Node node = elements.first();
        return node;
    }

    //protected Node text2NodeByXPath(String text) {
    //    // TODO: 2016/11/15 text2Node, Use XPath like //*[text()='text'],
    //    return null;
    //}

}
