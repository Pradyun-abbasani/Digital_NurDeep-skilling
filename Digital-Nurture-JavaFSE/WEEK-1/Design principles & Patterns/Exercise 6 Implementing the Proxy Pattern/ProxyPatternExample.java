public class ProxyPatternExample {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;
        public RealImage(String filename) {
            this.filename = filename;
            System.out.println("Loading " + filename);
        }
        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if(realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image img = new ProxyImage("nature.jpg");
        img.display();
        img.display();
    }
}
