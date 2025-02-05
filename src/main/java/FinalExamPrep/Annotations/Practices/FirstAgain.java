package FinalExamPrep.Annotations.Practices;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// Applied to methods to grant users to send a message
@interface CanSendMessage {
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
// Applied to Classes or Methods - specifies the necessary permission level a user must posses to send messages
@interface RequiresPermission {
    String level() default "admin";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// Applied to Classes, to define specific permission level for different type of users
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

@RequiresPermission
class OnlyAdminUser extends User {
    public OnlyAdminUser(String username) {
        super(username);
    }
}

class MessagingSystem {

    @CanSendMessage
    @RequiresPermission
    public void sendMessage(User user) throws NoSuchMethodException {
        Method method = this.getClass().getMethod("sendMessage", User.class);
        if(!method.isAnnotationPresent(CanSendMessage.class)) {
            System.out.println("This method is not able to send messages! ");
        }

        UserPermission userPermission = user.getClass().getAnnotation(UserPermission.class);
        if(userPermission.level().equals("admin")) {
            System.out.println(user.getUsername() + " (ADMIN) can send a message");
        } else {
            System.out.println(user.getUsername() + " (USER) cannot send a message");
        }
    }

    @CanSendMessage
    public void send2Message(User user) throws NoSuchMethodException {
        if(user.getClass().isAnnotationPresent(RequiresPermission.class)) {
            RequiresPermission reqPer = user.getClass().getAnnotation(RequiresPermission.class);
            System.out.println("The level for Requires Permission only: " + reqPer.level());
        }

        Method method = this.getClass().getMethod("send2Message", User.class);
        if(method.isAnnotationPresent(CanSendMessage.class)) {
            CanSendMessage csm = user.getClass().getAnnotation(CanSendMessage.class);
            System.out.println("I have CanSendMessage Annotation!");
        }
    }





    public static void main(String[] args) throws NoSuchMethodException {
        RegularUser regUser = new RegularUser("Haris");
        AdminUser adminUser = new AdminUser("Becir");
        OnlyAdminUser oau = new OnlyAdminUser("Keco");

        MessagingSystem msg = new MessagingSystem();
        msg.sendMessage(regUser);
        msg.sendMessage(adminUser);

        msg.send2Message(oau);



    }
}



