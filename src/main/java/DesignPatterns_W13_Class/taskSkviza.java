package DesignPatterns_W13_Class;

interface TextTransformation {
    String transform(String input);
}

class UppercaseTransformation implements TextTransformation {
    public String transform(String input) {
        return input.toUpperCase();
    }
}

class LowercaseTransformation implements TextTransformation {
    public String transform(String input) {
        return input.toLowerCase();
    }
}

class ReverseTransformation implements TextTransformation {
    public String transform(String input) {
        return new StringBuilder(input).reverse().toString();

    }
}

class TextProcessor {
    public TextTransformation transformation;

    public void setTransformation(TextTransformation transformation) {
        this.transformation = transformation;
    }

    public String process(String input) {
        if(input == null) {
            throw new IllegalStateException("Transformation strategy is not set!");
        }
        return transformation.transform(input);
    }
}






