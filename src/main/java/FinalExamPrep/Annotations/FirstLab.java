package FinalExamPrep.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CanSendMessage {
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresPermission {
    String level() default "admin";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserPermission {
    String level() default "user";
}


abstract class User {
    String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}


@UserPermission(level = "admin")
class AdminUser extends User {
    public AdminUser(String username) {
        super(username);
    }
}

@UserPermission
class RegularUser extends User {
    public RegularUser(String username) {
        super(username);
    }
}

class MessagingSystem {

    @CanSendMessage
    @RequiresPermission(level = "admin")
    public void sendMessage(User user) throws NoSuchMethodException {
        Method method = this.getClass().getMethod("sendMessage",User.class);
        if(!method.isAnnotationPresent(CanSendMessage.class)) {
            System.out.println("This method is not allowed to send message.");
            return;
        }

        UserPermission userPermission = user.getClass().getAnnotation(UserPermission.class);
        if(!userPermission.level().equals("admin")) {
            System.out.println("User " + user.getUsername() + " is not allowed to send messages");
        } else {
            System.out.println("Admin User " + user.getUsername() + " sent a message");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        RegularUser regularUser = new RegularUser("Haris");
        AdminUser adminUser = new AdminUser("Becir");

        MessagingSystem messagingSystem = new MessagingSystem();

        messagingSystem.sendMessage(regularUser);
        messagingSystem.sendMessage(adminUser);
    }
}


 */