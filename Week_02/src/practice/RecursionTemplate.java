package practice;

/**
 * @author DSH
 * @date 2021/2/2
 * @description 递归代码模板
 */
public class RecursionTemplate {

    int MAX_LEVEL = 999;
    int newParam;

    public void recur(int level, int param){
        // terminator  ①递归终结条件
        if (level > MAX_LEVEL) {
            // process result    
            return;
        }
        // process current logic  ②处理当前层逻辑
        process(level, param);
        // drill down  ③下探到下一层
        recur( level + 1, newParam);
        // restore current status  ④清理当前层
    }

    //处理当前层的代码
    private void process(int level, int param) {

    }
}
