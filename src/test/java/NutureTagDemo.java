/**
 * Created by zhanghong on 2015/1/20.
 * failed！==nonepoint Exception
 */
import java.util.Arrays;
import java.util.List;
import org.ansj.domain.Term;
import org.ansj.recognition.NatureRecognition;
public class NutureTagDemo {
    public static void main(String[] args) {
        String[] strs = {"对", "非", "ansj", "的", "分词", "结果", "进行", "词性", "标注"} ;
        List<String> lists = Arrays.asList(strs) ;
        List<Term> recognition = NatureRecognition.recognition(lists, 0) ;
        System.out.println(recognition);
    }
}
