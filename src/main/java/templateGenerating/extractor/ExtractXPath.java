package templateGenerating.extractor;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import templateGenerating.beans.Record;
import templateGenerating.beans.Template;

import java.io.File;
import java.util.List;

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
    protected String getExpression(Node n) {
        return null;// TODO: 2016/11/15
    }

    @Override
    public Template getTemplate(List<Record> records) {
        return null;
    }
}
