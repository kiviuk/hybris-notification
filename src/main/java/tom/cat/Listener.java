package tom.cat;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

// https://stackoverflow.com/questions/5588064/how-do-i-make-a-mac-terminal-pop-up-alert-applescript
public class Listener implements LifecycleListener {

    public static void main(String[] args) {
        new Listener().beTrayMe();
    }

    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if (Lifecycle.AFTER_START_EVENT.equals(event.getType())) {
            beTrayMe();
        }
    }

    private void beTrayMe() {
        //String[] args = { "osascript", "-e", "display alert \"Hybris server is ready\" message \"Let's do some work.\""};
        //String[] args = { "osascript", "-e", "tell app \"System Events\" to display dialog \"Hello World\""};
        String[] args = { "osascript", "-e", "display notification \"Hybris server is ready!\" with title \"\""};
        try {
            Process process = Runtime.getRuntime().exec(args);
            process.waitFor();
            if (process.exitValue() == 0) {
                System.out.println("success");
            } else {
                InputStream is = process.getErrorStream();
                final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(is));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}