import model.FileHandler;
import view.LoginView;
import view.View;

public class App extends Thread{
    public static void main(String[] args) {
        View view = new LoginView();
        FileHandler.loadDataDat();

        while (view != null) {
            view = view.index();
        }
    }


//    private static View currentView = null;
//    private static Thread thread;
//
//    public static void main(String[] args) {
//        FileHandler.createData();
//        FileHandler.loadAccounts();
//
//        currentView = new LoginView();
//        thread = new App();
//        while (true) {
//            if (currentView == null) break;
//
//            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public void run() {
//        currentView.index();
//    }
//
//    public static void switchView(View view) {
//        currentView = view;
//        thread.interrupt();
//        thread = new App();
//    }
}
