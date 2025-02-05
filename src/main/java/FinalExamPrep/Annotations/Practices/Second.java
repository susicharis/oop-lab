package FinalExamPrep.Annotations.Practices;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CanEditContent {
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresRole {
    String role() default "master";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserRole {
    String role() default "user";
}

abstract class Users {
    String username;

    public Users(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}


@UserRole(role = "editor")
class Editor extends Users {
    public Editor(String username) {
        super(username);
    }
}

@UserRole(role = "viewer")
class Viewer extends Users {
    public Viewer(String username) {
        super(username);
    }
}

@UserRole(role = "admin")
class Admin extends Users {
    public Admin(String username) {
        super(username);
    }
}


class EditingSystem {

    @CanEditContent
    public void editContent(Users user) throws NoSuchMethodException {
        Method method = this.getClass().getMethod("editContent",Users.class);
        if(!method.isAnnotationPresent(CanEditContent.class)) {
            System.out.println("This method is not able to edit/write any content.");
        }

        UserRole userRole = user.getClass().getAnnotation(UserRole.class);
        if(userRole.role().equals("editor")) {
            System.out.println(user.getUsername() + " (EDITOR) is here!");
        } else if (userRole.role().equals("viewer")) {
            System.out.println(user.getUsername() + " (VIEWER) is here!");
        } else if (userRole.role().equals("admin")){
            System.out.println(user.getUsername() + " (ADMIN) is here!");
        } else {
            System.out.println(user.getUsername() + " has an uknown role.");
        }

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Editor editor = new Editor("Tarik");
        Viewer viewer = new Viewer("Haris");
        Admin admin = new Admin("Becir");

        EditingSystem es = new EditingSystem();
        es.editContent(editor);
        es.editContent(viewer);
        es.editContent(admin);
    }
}




