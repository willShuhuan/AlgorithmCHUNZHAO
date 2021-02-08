package practice;

/**
 * @author DSH
 * @date 2021/2/5
 * @description 分治算法代码模板
 */
public class DivideConquerTemplate {
    private static int divide_conquer(Problem problem){
        // recursion terminator 递归终止条件
        if (problem==null){
            int res = process_last_result();
            return res;
        }
        //prepare data  分割子问题
        Problem[] subProblems = split_problem(problem);

        //conquer subproblems 治理子问题
        int res0 = divide_conquer(subProblems[0]);
        int res1 = divide_conquer(subProblems[1]);

        // process and generate the final result 处理并生成最终结果
        int result = process_result(res0,res1);

        // revert the current level states

        return result;
    }

    private static int process_last_result() {
        return -1;
    }

    private static Problem[] split_problem(Problem problem) {
        return null;
    }

    private static int process_result(int res0, int res1) {
        return -1;
    }

}

class Problem{

}