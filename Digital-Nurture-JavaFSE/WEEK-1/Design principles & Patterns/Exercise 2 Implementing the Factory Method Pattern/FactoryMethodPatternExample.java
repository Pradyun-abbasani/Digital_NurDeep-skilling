public class FactoryMethodPatternExample {
    interface Document {}

    static class WordDoc implements Document {
        public WordDoc() {
            System.out.println("Word Document created");
        }
    }

    static class PdfDoc implements Document {
        public PdfDoc() {
            System.out.println("PDF Document created");
        }
    }

    static class ExcelDoc implements Document {
        public ExcelDoc() {
            System.out.println("Excel Document created");
        }
    }

    static abstract class DocumentFactory {
        abstract Document createDocument();
    }

    static class WordFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDoc();
        }
    }

    static class PdfFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDoc();
        }
    }

    static class ExcelFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDoc();
        }
    }

    public static void main(String[] args) {
        new WordFactory().createDocument();
        new PdfFactory().createDocument();
        new ExcelFactory().createDocument();
    }
}
