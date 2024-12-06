package Week10LAB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
First - @CanSendMessage -> METHODS (Grant users to ability to send messages)
Second - @RequiresPermission -> CLASSES/METHODS (Necessary Permission Level a user MUST POSSES to User Classes -> RegularUser, AdminUser CLASS,
        to define specific permission levels for different types of users).

SYSTEM SHOULD HAVE
* abstract User Class -> String username (represents users in the messaging system)
* RegularUser & AdminUser CLASS (od gore) should have a DEFAULT permission level, while AdminUser should explicitly define the admin
permission level using the @UserPermission Annotation

METHODS
sendMessage -> prints which user sent a message if the user is admin, and if it is a regular user then it should print a message
                that the user is RESTRICTED. (Should apply the already created custom annotations to it)

MAIN METHOD -> INSIDE MessageSystem CLASS
Demonstrate the usage of the sendMessage method by creating instances of users with different permission levels
PRINT RESULTS TO SHOWCASE HOW THE IMPLEMENTED ANNOTATIONS ENFORCE/ALLOW MESSAGE SENDING BASED ON SPECIFIC PERMISSION LEVELS
 */



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CanSendMessage {
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresPermission {
    int requiredLevel();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserPermission {
    int userPermissionLevel();
}



abstract class User {
    String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    abstract void sendMessage();
}


@UserPermission(userPermissionLevel = 2)
class RegularUser extends User {
    int userLevel;

    public RegularUser(String username, int userLevel) {
        super(username);
        this.userLevel = userLevel;
    }

    public int getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    @CanSendMessage
    public void sendMessage() {
        if (this.userLevel >= 2) {
            System.out.println("The user's level is : " + this.userLevel + ", & User: " + getUsername() + " is allowed to send a message!");
        } else
            System.out.println("The user's level is : " + this.userLevel + ", & User: " + getUsername() + " is NOT allowed to send a message!");
    }

}

@UserPermission(userPermissionLevel = 3)
class AdminUser extends User {

    public AdminUser(String username) {
        super(username);
    }

    @Override
    @CanSendMessage
    public void sendMessage() {
        System.out.println("The user is " + getUsername() + " (ADMIN) , and he is ALWAYS Allowed.");
    }
}


class MessagingSystem {
    public static void main(String[] args) {

        RegularUser firstUser = new RegularUser("Haris",1);
        AdminUser secondUser = new AdminUser("Becir");
        RegularUser thirdUser = new RegularUser("Amila",4);

        firstUser.sendMessage();
        secondUser.sendMessage();
        thirdUser.sendMessage();

        System.out.println();
        System.out.println();
        // Additional

        for(Method m : secondUser.getClass().getDeclaredMethods()) {
            if(m.isAnnotationPresent(CanSendMessage.class)) {
                System.out.println("CanSendMessage annotation is present for the Admin!");
            }
        }

    }
}