package FinalExamPrep.Annotations.Practices;

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


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresPermission{
    String level() default "admin";
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserPermission{
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

@UserPermission
class RegularUser extends User {
    public RegularUser(String username) {
        super(username);
    }
}

@UserPermission(level = "admin")
class AdminUser extends User {
    public AdminUser(String username) {
        super(username);
    }
}

class MessagingSystem {

    @CanSendMessage
    @RequiresPermission
    public void sendMessage(User user) throws NoSuchMethodException {
        Method method = this.getClass().getMethod("sendMessage",User.class);
        if(!method.isAnnotationPresent(CanSendMessage.class)) {
            System.out.println("This method cannot be used to send messages.");
        }

        UserPermission userPermission = user.getClass().getAnnotation(UserPermission.class);
        if(userPermission.level().equals("admin")) {
            System.out.println(user.getUsername() + " (ADMIN) Can write.");
        } else {
            System.out.println(user.getUsername() + " (USER) cannot write.");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        RegularUser regUser = new RegularUser("Haris");
        AdminUser adminUser = new AdminUser("Becir");

        MessagingSystem msg = new MessagingSystem();
        msg.sendMessage(regUser);
        msg.sendMessage(adminUser);
    }
}

 */