package interfaces;

interface DataExporter {
    void export();
    default void exportToJSON() { System.out.println("Exported to JSON"); }
}

class CSVExporter implements DataExporter {
    public void export() { System.out.println("Exported to CSV"); }
}

class PDFExporter implements DataExporter {
    public void export() { System.out.println("Exported to PDF"); }
}

public class DataExportFeature {
    public static void main(String[] args) {
        DataExporter d = new CSVExporter();
        d.export();
        d.exportToJSON();
    }
}

