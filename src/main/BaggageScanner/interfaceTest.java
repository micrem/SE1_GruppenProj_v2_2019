package BaggageScanner;

public class interfaceTest {

    static interface interfaceA {
        public void schalterUmlegen();
    }

    static class B implements interfaceA{

        @Override
        public void schalterUmlegen() {

        }

        public void methodB(){};
    }


    static class C implements interfaceA{

        @Override
        public void schalterUmlegen() {

        }

        public void methodC(){};
    }

    public static void main(String[] args) {

        interfaceA[] sammlungA = new interfaceA[2];

        B instanceB = new B();

        sammlungA[1] = instanceB;
        sammlungA[0] = new C();

        sammlungA[0].schalterUmlegen();
        sammlungA[1].schalterUmlegen();

        instanceB.methodB();
        instanceB.schalterUmlegen();



    }

}
