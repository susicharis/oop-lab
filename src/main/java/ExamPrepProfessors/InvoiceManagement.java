package ExamPrepProfessors;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

enum TextFormat {
    CAPITALIZE,LOWERCASE,PLAIN
}
enum CurrencyFormat {
    USD,EURO,INR
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFormat {
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default CurrencyFormat.USD;
}

class Invoice {
    @FieldFormat
    private Date invoiceDate;

    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String invoiceNumber;
    private int qtr;
    private int year;

    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String customerName;

    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double totalAmount;

    @FieldFormat(currency_format = CurrencyFormat.EURO)
    private double taxAmount;
    private double netAmount;

    public Invoice(InvoiceBuilder builder) {
        this.invoiceDate = builder.invoiceDate;
        this.invoiceNumber = builder.invoiceNumber;
        this.qtr = builder.qtr;
        this.year = builder.year;
        this.customerName = builder.customerName;
        this.totalAmount = builder.totalAmount;
        this.taxAmount = builder.taxAmount;
        this.netAmount = builder.netAmount;
    }

    static class InvoiceBuilder {
        private Date invoiceDate;
        private String invoiceNumber;
        private int qtr;
        private int year;
        private String customerName;
        private double totalAmount;
        private double taxAmount;
        private double netAmount;

        public InvoiceBuilder setInvoiceDate(Date invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }
        public InvoiceBuilder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }
        public InvoiceBuilder setQtr(int qtr) {
            this.qtr = qtr;
            return this;
        }
        public InvoiceBuilder setYear(int year) {
            this.year = year;
            return this;
        }
        public InvoiceBuilder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }
        public InvoiceBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
        public InvoiceBuilder setTaxAmount(double taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }
        public InvoiceBuilder setNetAmount(double netAmount) {
            this.netAmount = netAmount;
            return this;
        }
        public Invoice getResults() {
            return new Invoice(this);
        }

    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public int getQtr() {
        return qtr;
    }
    public int getYear() {
        return year;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public double getTaxAmount() {
        return taxAmount;
    }
    public double getNetAmount() {
        return netAmount;
    }

}

class InvalidInvoiceException extends RuntimeException {
    public InvalidInvoiceException(String message) {
        super(message);
    }

    public InvalidInvoiceException(String message, Throwable cause) {
        super(message,cause);
    }
}

class InvoiceProfessor {
    List<Invoice> invoiceList = new ArrayList<>();

    public InvoiceProfessor(String filename) {
        this.invoiceList = loadInvoices(filename);
    }

    public List<Invoice> getInvoiceList() {
        return this.invoiceList;
    }



    public List<Invoice> loadInvoices(String fileName) {
        List<Invoice> insideList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().collect(Collectors.toList());

            for(int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");

                if(parts[0] == "" || parts[1] == "" || parts[5] == "") {
                    throw new InvalidInvoiceException("Missing required field",new ClassCastException());
                }


                insideList.add(
                        new Invoice.InvoiceBuilder()
                                .setInvoiceDate(new SimpleDateFormat("MM/dd/yyyy").parse(parts[0]))
                                .setInvoiceNumber(parts[1])
                                .setQtr(Integer.parseInt(parts[2]))
                                .setYear(Integer.parseInt(parts[3]))
                                .setCustomerName(parts[4])
                                .setTotalAmount(Double.parseDouble(parts[5]))
                                .setTaxAmount(Double.parseDouble(parts[6]))
                                .setNetAmount(Double.parseDouble(parts[7]))
                                .getResults()
                );
            }





        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(ParseException pe) {
            pe.printStackTrace();
        }



        return insideList;
    }
}



class CSVReportGenerator {

    public static String capitalizeWords(String input) {
        if (input == null || input == "") {
            return input;
        }

        String[] words = input.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for(String word : words) {
            if(!word.isEmpty()) {
                capitalized.append(word.substring(0,1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return capitalized.toString().trim();
    }

    public static void generateReport(String outputFileName, List<Invoice> invoices) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            Class clazz = Invoice.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().concat("\n") :
                                field[i].getName().concat(";")
                );
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            for(Invoice invoice : invoices) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(FieldFormat.class)) {
                        if(field[i].get(invoice) instanceof String) {
                            TextFormat textFormat = field[i].getAnnotation(FieldFormat.class).text_format();

                            switch(textFormat) {

                                case LOWERCASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(invoice).toString().toLowerCase().concat("\n") :
                                                field[i].get(invoice).toString().toLowerCase().concat(";")
                                );

                                case CAPITALIZE -> writer.write(
                                        field.length - 1 == i ?
                                                capitalizeWords(field[i].get(invoice).toString()).concat("\n") :
                                                capitalizeWords(field[i].get(invoice).toString()).concat(";")
                                );

                                case PLAIN -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(invoice).toString().concat("\n") :
                                                field[i].get(invoice).toString().concat(";")
                                );

                            }


                        } else {

                            CurrencyFormat cf = field[i].getAnnotation(FieldFormat.class).currency_format();

                                if(field[i].get(invoice) instanceof Number && field[i].get(invoice) != null) {

                                    switch(cf) {
                                        case USD -> writer.write(
                                                field.length - 1 == i ?
                                                        "$".concat(field[i].get(invoice).toString()).concat("\n") :
                                                        "$".concat(field[i].get(invoice).toString()).concat(";")
                                        );

                                        case EURO -> writer.write(
                                                field.length - 1 == i ?
                                                        "€".concat(field[i].get(invoice).toString()).concat("\n") :
                                                        "€".concat(field[i].get(invoice).toString()).concat(";")
                                        );

                                        case INR -> writer.write(
                                                field.length - 1 == i ?
                                                        "₹".concat(field[i].get(invoice).toString()).concat("\n") :
                                                        "₹".concat(field[i].get(invoice).toString()).concat(";")
                                        );
                                    }
                                }

                                else if(field[i].get(invoice) instanceof Date) {
                                    String formattedDate = dateFormat.format((Date) field[i].get(invoice));
                                    writer.write(
                                            field.length - 1 == i ?
                                                    formattedDate.concat("\n") :
                                                    formattedDate.concat(";")
                                    );
                                }
                        }


                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(invoice).toString().concat("\n") :
                                        field[i].get(invoice).toString().concat(";")
                        );
                    }




                }
            }






        writer.close();
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}

class InvoiceManagement {
    public static void main(String[] args) {
        InvoiceProfessor invProf = new InvoiceProfessor("C:\\Users\\Haris\\Desktop\\invoicemanagement.csv");
        CSVReportGenerator report = new CSVReportGenerator();
        report.generateReport("C:\\Users\\Haris\\Desktop\\temporary.csv",invProf.getInvoiceList());
    }
}
