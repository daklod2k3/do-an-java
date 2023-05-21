package GUI;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

public class PDFViewerPanel extends JPanel {
    private File pdfFile;

    public PDFViewerPanel(File pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFRenderer renderer = new PDFRenderer(document);
            BufferedImage image = renderer.renderImage(0); // Render the first page as an image

            // Scale the image to fit the panel size
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            double scaleX = (double) panelWidth / imageWidth;
            double scaleY = (double) panelHeight / imageHeight;
            double scale = Math.min(scaleX, scaleY);

            int scaledWidth = (int) (imageWidth * scale);
            int scaledHeight = (int) (imageHeight * scale);

            // Calculate the position to center the image
            int x = (panelWidth - scaledWidth) / 2;
            int y = (panelHeight - scaledHeight) / 2;

            // Draw the image on the panel
            g.drawImage(image, x, y, scaledWidth, scaledHeight, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
