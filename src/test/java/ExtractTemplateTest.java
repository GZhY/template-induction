import crawler.Parser;
import org.jsoup.nodes.Document;
import templateGenerating.extractor.ExtractSelector;
import templateGenerating.extractor.ExtractTemplate;

/**
 * This is a XXX class.
 * What is the function of this class?
 *
 * @author GZhY
 * @version 1.0
 */
public class ExtractTemplateTest {
    private static void test1() {
        ExtractTemplate extractTemplate = new ExtractSelector("<g class=\"G Zh Y\">　　各位嘉宾，各位朋友：</g>");
        System.out.println(extractTemplate.getExpression("各位嘉宾"));
    }

    private static void test2(String text) {
        Document document = Parser.url2Document("http://news.xinhuanet.com/politics/2016-11/16/c_1119925089.htm");
        ExtractTemplate extractTemplate = new ExtractSelector(document);
        System.out.println(extractTemplate.getExpression(text));
        System.out.println(document.select(extractTemplate.getExpression(text)).text());
    }

    private static void test3(){

    }

    public static void main(String[] args) {
        //test1();
        //test2("刘云山说，携手构建网络空间命运共同体，应在完善治理规则方面深化合作，尊重网络主权，维护各国在网络空间平等的发展权参与权治理权，推动建立多边民主透明的全球互联网治理体系；在促进互联网创新创造方面深化合作，坚持开放合作、互利共赢，在网络空间创造更多利益汇合点和合作新亮点；在加快网络普及方面深化合作");
        //test2("大家好！值此第三届世界互联网大会开幕之际");
    }
}
