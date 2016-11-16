package templateGenerating.extractor;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.File;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class ExtractXPath extends ExtractTemplate{

    public ExtractXPath(String html2Extract) {
        super(html2Extract);
    }

    public ExtractXPath(File file2Extract) {
        super(file2Extract);
    }

    public ExtractXPath(Document document4Jsoup) {
        super(document4Jsoup);
    }

    @Override
    protected String getTemplate(final Node n) {
        return null;// TODO: 2016/11/15
    }
}
