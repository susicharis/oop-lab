package FinalExamPrep.Annotations.Practices;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecution {
}

enum LogLevelEnum {
    INFO,DEBUG,ERROR
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface LogLevel {
    LogLevelEnum value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SensitiveData{
}

class Logger {

    public static void log(Object obj) throws IllegalAccessException {
        if(obj.getClass().isAnnotationPresent(LogLevel.class)) {
            LogLevel level = obj.getClass().getAnnotation(LogLevel.class);
            System.out.println("Log level: " + level.value());
        }

        for(Method method : obj.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(LogExecution.class)) {
                System.out.println("Method Executed: " + method.getName());
            }
        }

        for(Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(SensitiveData.class)) {
                System.out.println("Sensitive field: " + f.getName() + " is masked.");
            } else {
                System.out.println("Field: " + f.getName() + " = " + f.get(obj));
            }
        }

    }
}

class Transaction {

    @SensitiveData
    private String creditCardNumber;

    private double amount;

    public Transaction(String creditCardNumber, double amount) {
        this.creditCardNumber = creditCardNumber;
        this.amount = amount;
    }


    @LogExecution
    public void processTransaction() {
        System.out.println("Processing transaction of amount: " + amount);
    }

    @LogExecution
    public double getAmount() {
        return amount;
    }

    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }
}

class Real {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        Transaction transaction = new Transaction("1234-5678-9145-4142", 500.75);

        Logger.log(transaction);
        transaction.processTransaction();
    }
}