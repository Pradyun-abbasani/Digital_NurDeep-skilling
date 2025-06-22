public class SingletonPattern{
    static class Logger {
        private static Logger instance;
        private Logger(){}
        public static Logger getInstance(){
            if(instance==null){
                instance=new Logger();
            }
            return instance;
        }
        public void log(String msg){
            System.out.println("LOG: "+msg);
        }
    }

    public static void main(String[] args){
        Logger logger1=Logger.getInstance();
        Logger logger2=Logger.getInstance();
        logger1.log("Start");
        logger2.log("loading");
        if(logger1==logger2){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
