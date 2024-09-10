package com.practice.java.DesignPatterns.Structural;

// Converts the interface of a class into another interface clients expect.
// Computer class that needs to work with a ModernPrinter, but you have an existing OldPrinter class that doesn’t match the expected interface.
// So basically we do this when the old interface is incompatible
public class AdapterDesign {
    public static void main(String[] args) {

        // Create an instance of LegacyPrinter
        LegacyPrinter legacyPrinter = new LegacyPrinter();

        // Create an adapter to make LegacyPrinter compatible with Printer
        Printer printer = new PrinterAdapter(legacyPrinter);

        // Use the printer
        printer.print("Hello, Adapter Pattern!");
    }
}

// Old interface (what the legacy system expects)
interface OldPrinterInterface {
    void printText(String text);
}

// LegacyPrinter class implementing the old interface
class LegacyPrinter implements OldPrinterInterface {
    @Override
    public void printText(String text) {
        System.out.println("Legacy Printer: " + text);
    }
}

// Target interface expected by the new system
interface Printer {
    void print(String text);
}

class PrinterAdapter implements Printer{

    private OldPrinterInterface oldPrinterInterface;

    public PrinterAdapter(OldPrinterInterface oldPrinterInterface) {
        this.oldPrinterInterface = oldPrinterInterface;
    }
    @Override
    public void print(String text) {
        // Translate the call to the old format
        oldPrinterInterface.printText(text);
    }
}


