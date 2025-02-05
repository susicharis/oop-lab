import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
        public Invoice build() {
            return new Invoice(this);
        }
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

class InvoiceProcessor {
    List<Invoice> invoiceList = new ArrayList<>();

    public InvoiceProcessor(String filename) {
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
                                .build()
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
        if(input.isEmpty() || input == "") {
            return input;
        }

        String words[] = input.split("\\s+");
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

    public static String formatText(String input, String category) {
    if(input == null || input.isEmpty()) {
        return input;
    }

    switch(category.toUpperCase()) {
        case "FICTION" :
            return input.toUpperCase();
        case "SCIENCE" :
            return input.toLowerCase();
        case "ARTS" :
            String[] words = input.split("\\s+");
            StringBuilder capitalized = new StringBuilder();

            for(String word : words) {
                if(!word.isEmpty()) {
                    capitalized.append(word.substring(0,1).toUpperCase())
                            .append(word.substring(0).toLowerCase())
                            .append(" ");
                }
            }
            return capitalized.toString().trim();
        default:
            return input;
    }

    }
}

