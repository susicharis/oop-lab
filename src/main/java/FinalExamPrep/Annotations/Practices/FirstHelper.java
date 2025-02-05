package FinalExamPrep.Annotations.Practices;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MessageSystem {
    public void sendMessage(User user) {
        System.out.println("MessagingSystem: Sending a message");
    }
}

class AdvancedMessageSystem extends MessageSystem {
    @Override
    public void sendMessage(User user) {
        System.out.println("AdvancedMessageSystem: Sending a message");
    }
}

class Mejn {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MessageSystem msg = new AdvancedMessageSystem();
        Method method = msg.getClass().getMethod("sendMessage", User.class);
        method.invoke(msg, new AdminUser("Haris"));
    }
}