package GUI;

import javax.swing.*;
import java.awt.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfViewerDialog extends JDialog {
    private JTextArea textArea;
    private String filePath;

    public PdfViewerDialog(Frame parent, String filePath) {
        super(parent, "PDF Viewer", true);
        this.filePath = filePath;

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(parent);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        displayPdfContent();
    }

    private void displayPdfContent() {
        try {
            PdfReader reader = new PdfReader(filePath);

            StringBuilder content = new StringBuilder();
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                content.append(PdfTextExtractor.getTextFromPage(reader, i)).append("\n");
            }

            textArea.setText(content.toString());

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String filePath = "path/to/pdf/file.pdf";
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame();
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(800, 600);
//            frame.setLocationRelativeTo(null);
//
//            JButton openButton = new JButton("Open PDF");
//            openButton.addActionListener(e -> {
//                JDialog dialog = new PdfViewerDialog(frame, filePath);
//                dialog.setVisible(true);
//            });
//
//            frame.getContentPane().add(openButton);
//            frame.setVisible(true);
//        });
//    }
}
