package DesginPatterns.Creational;

public class Singleton {

    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();

        JudgeAnalytics judgeAnalytics1 = JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}

//class JudgeAnalytics {
//    private int submit = 0;
//    private int run = 0;
//
//    public void countRun(){
//        run++;
//    }
//
//    public void countSubmit(){
//        submit++;
//    }
//
//    public int getSubmitCount(){
//        return submit;
//    }
//
//    public int getRunCount(){
//        return run;
//    }
//}

// EAGER LOADING
//class JudgeAnalytics {
//    private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//
//    private JudgeAnalytics(){
//
//    }
//
//    public static JudgeAnalytics getInstance(){
//        return judgeAnalytics;
//    }
//}


// LAZY LOADING
//class JudgeAnalytics {
//    private static JudgeAnalytics judgeAnalytics;
//
//    private JudgeAnalytics(){
//
//    }
//
//    public static JudgeAnalytics getInstance() {
//        if(judgeAnalytics == null){
//            judgeAnalytics = new JudgeAnalytics();
//            System.out.println("-------- INITIALIZED ---------");
//        }
//
//        return judgeAnalytics;
//    }
//}


//class JudgeAnalytics {
//    private static JudgeAnalytics judgeAnalytics;
//
//    private JudgeAnalytics(){
//
//    }
//
//    public static JudgeAnalytics getInstance() {
//        if(judgeAnalytics == null){
//            synchronized (JudgeAnalytics.class) {
//                if(judgeAnalytics == null) {
//                    judgeAnalytics = new JudgeAnalytics();
//                    System.out.println("-------- INITIALIZED ---------");
//                }
//            }
//        }
//
//        return judgeAnalytics;
//    }
//}

class JudgeAnalytics {

    private JudgeAnalytics() {

    }

    private static class Holder {
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }

    public static JudgeAnalytics getInstance() {
        return Holder.judgeAnalytics;
    }
}