package templateGenerating.extractor;

import org.w3c.dom.Node;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public abstract class ExtractTemplate {

    public abstract String getTemplate(final Node n);

    public String getTemplate(String text){
        Node n = null;
        // TODO: 2016/11/15 text2Node, Use XPath like //*[text()='text'],
        // but the XPath can't resolve this problem that one text corresponds two nodes.
        // We can also use jsoup selectors, such as :contains(text), :containsOwn(text), :matches(regex), :matchesOwn(regex),
        // to get corresponding node.
        return getTemplate(n);
    }
}
