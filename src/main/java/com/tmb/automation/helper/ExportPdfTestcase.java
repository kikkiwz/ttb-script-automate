package com.tmb.automation.helper;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExportPdfTestcase extends Reporter {
    public static void addCoverPage(Document document) throws DocumentException, IOException {

        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);

        Image img = Image.getInstance(logoTmb);
        img.scaleToFit(60, 160);

        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setBorder(0);
        table.getDefaultCell().setBorderWidth(0f);
        float[] anchoDeColumnas = new float[]{17, 83f};
        table.setWidths(anchoDeColumnas);
        table.setWidthPercentage(100f);

        PdfPCell r1 = new PdfPCell(Image.getInstance(img), true);
        r1.setBorder(Rectangle.NO_BORDER);
        table.addCell(r1);

        r1 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_TITLE, fontSukhumvit20));
        r1.setHorizontalAlignment(Element.ALIGN_CENTER);
        r1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r1.setBorder(Rectangle.NO_BORDER);
        r1.setPaddingBottom(10);
        table.addCell(r1);
        preface.add(table);

        PdfPTable table2 = new PdfPTable(1);
        table2.setWidthPercentage(100f);
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date());

        PdfPCell r2 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_REPORT_BY + Setting.TEAM_NAME + " , " + date, fontSukhumvit14));
        r2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        r2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(r2);


        PdfPCell r3 = new PdfPCell(new Paragraph(Setting.PROJECT_NAME, fontSukhumvit50));
        r3.setHorizontalAlignment(Element.ALIGN_RIGHT);
        r3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r3.setBorder(Rectangle.NO_BORDER);
        r3.setPaddingRight(15);
        r3.setPaddingTop(50);
        table2.addCell(r3);

        preface.add(table2);
        PdfPTable tableSignOff = new PdfPTable(1);
        tableSignOff.setWidthPercentage(90f);
        PdfPCell r4 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_SIGN_OFF, fontSukhumvit14));
        r4.setHorizontalAlignment(Element.ALIGN_LEFT);
        r4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r4.setBorder(Rectangle.NO_BORDER);
        r4.setPaddingTop(45);
        tableSignOff.addCell(r4);

        PdfPCell r5 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_SIGN_OFF_DETAIL, fontSukhumvit14));
        r5.setHorizontalAlignment(Element.ALIGN_LEFT);
        r5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r5.setBorder(Rectangle.NO_BORDER);
        r5.setPaddingLeft(5);
        r5.setPaddingRight(5);
        r5.setPaddingTop(15);
        r5.setPaddingBottom(20);
        tableSignOff.addCell(r5);

        r5 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_SIGN_OFF_CHECK_LIST, fontSukhumvit12));
        r5.setHorizontalAlignment(Element.ALIGN_LEFT);
        r5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r5.setBorder(Rectangle.NO_BORDER);
        r5.setPaddingLeft(5);
        r5.setPaddingRight(5);
        r5.setPaddingTop(15);
        r5.setPaddingBottom(30);
        tableSignOff.addCell(r5);

        preface.add(tableSignOff);

        PdfPTable table3 = new PdfPTable(3);
        table3.setWidthPercentage(90f);

        PdfPCell r6 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_SIGN_OFF_CHOICE_I, fontSukhumvit10));
        r6.setHorizontalAlignment(Element.ALIGN_LEFT);
        r6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r6.setBorderColor(BaseColor.GRAY);
        r6.setPadding(10);
        table3.addCell(r6);

        PdfPCell r7 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_SIGN_OFF_CHOICE_II, fontSukhumvit10));
        r7.setHorizontalAlignment(Element.ALIGN_LEFT);
        r7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r7.setBorderColor(BaseColor.GRAY);
        r7.setPadding(10);
        table3.addCell(r7);

        PdfPCell r8 = new PdfPCell(new Paragraph(Setting.ExportPdfKey.COVER_PAGE_SIGN_OFF_CHOICE_III, fontSukhumvit10));
        r8.setHorizontalAlignment(Element.ALIGN_LEFT);
        r8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r8.setBorderColor(BaseColor.GRAY);
        r8.setPadding(10);
        table3.addCell(r8);

        preface.add(table3);

        addEmptyLine(preface, 2);
        PdfPTable table4 = new PdfPTable(4);
        table4.setWidthPercentage(90f);
        anchoDeColumnas = new float[]{38, 22, 15, 15};
        table4.setWidths(anchoDeColumnas);
        PdfPCell t4r0c0 = new PdfPCell(new Paragraph("Business Delegate", fontSukhumvit12));
        t4r0c0.setHorizontalAlignment(Element.ALIGN_LEFT);
        t4r0c0.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0c0.setBorderColor(BaseColor.GRAY);
        t4r0c0.setPadding(5);
        table4.addCell(t4r0c0);

        PdfPCell t4r0c1 = new PdfPCell(new Paragraph("Approved/Rejected", fontSukhumvit12));
        t4r0c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        t4r0c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0c1.setBorderColor(BaseColor.GRAY);
        t4r0c1.setPadding(5);
        table4.addCell(t4r0c1);

        PdfPCell t4r0c2 = new PdfPCell(new Paragraph("Signature", fontSukhumvit12));
        t4r0c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        t4r0c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0c2.setBorderColor(BaseColor.GRAY);
        t4r0c2.setPadding(5);
        table4.addCell(t4r0c2);

        PdfPCell t4r0c3 = new PdfPCell(new Paragraph("Date", fontSukhumvit12));
        t4r0c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        t4r0c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0c3.setBorderColor(BaseColor.GRAY);
        t4r0c3.setPadding(5);
        table4.addCell(t4r0c3);


        for (int i = 0; i < 20; i++) {
            PdfPCell t4r0c4 = new PdfPCell(new Paragraph(" "));
            t4r0c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            t4r0c4.setVerticalAlignment(Element.ALIGN_BOTTOM);
            t4r0c4.setBorderColor(BaseColor.GRAY);
            t4r0c4.setPadding(5);
            table4.addCell(t4r0c4);
        }

        preface.add(table4);

        addEmptyLine(preface, 2);
        PdfPTable table5 = new PdfPTable(1);
        table5.setWidthPercentage(90f);
        PdfPCell t4r0 = new PdfPCell(new Paragraph("Project Owner: Kwanyukol Suebpong", fontSukhumvit14));
        t4r0.setHorizontalAlignment(Element.ALIGN_LEFT);
        t4r0.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0.setBorder(Rectangle.NO_BORDER);
        t4r0.setPadding(5);
        table5.addCell(t4r0);
        String changeNo = new SimpleDateFormat("yyyyMMddhhmmsss").format(new Date());
        t4r0 = new PdfPCell(new Paragraph("Reference: " + changeNo, fontSukhumvit14));
        t4r0.setHorizontalAlignment(Element.ALIGN_LEFT);
        t4r0.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0.setBorder(Rectangle.NO_BORDER);
        t4r0.setPadding(5);
        table5.addCell(t4r0);

        String dateTime = new SimpleDateFormat("yyyy MMMM dd").format(new Date());
        t4r0 = new PdfPCell(new Paragraph("Date: " + dateTime, fontSukhumvit14));
        t4r0.setHorizontalAlignment(Element.ALIGN_LEFT);
        t4r0.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t4r0.setBorder(Rectangle.NO_BORDER);
        t4r0.setPadding(5);
        table5.addCell(t4r0);


        preface.add(table5);

        addEmptyLine(preface, 1);
        PdfPTable table6 = new PdfPTable(1);
        table5.setWidthPercentage(90f);
        PdfPCell t5r0 = new PdfPCell(new Paragraph("Developed by TCS Quality Assurance Team", fontSukhumvit8));
        t5r0.setHorizontalAlignment(Element.ALIGN_CENTER);
        t5r0.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t5r0.setBorder(Rectangle.NO_BORDER);
        t5r0.setPadding(5);
        table6.addCell(t5r0);

        t5r0 = new PdfPCell(new Paragraph("Information Technology Services", fontSukhumvit8));
        t5r0.setHorizontalAlignment(Element.ALIGN_CENTER);
        t5r0.setVerticalAlignment(Element.ALIGN_MIDDLE);
        t5r0.setBorder(Rectangle.NO_BORDER);
        t5r0.setPadding(5);
        table6.addCell(t5r0);

        preface.add(table6);
        document.add(preface);
        document.newPage();
    }

    public static void addDemoStepImage(boolean isHeader, String testcaseDescription, byte[] imagePage) throws DocumentException, IOException {
        PdfPTable table = new PdfPTable(2);
        float[] anchoDeColumnas = new float[]{15f, 85f};
        table.setWidths(anchoDeColumnas);
        table.setWidthPercentage(100f);

        if (isHeader) {
            paragraphDemoStep = new Paragraph();
            addEmptyLine(paragraphDemoStep, 1);
            PdfPCell c1 = new PdfPCell(new Phrase("Testcase", fontSukhumvit16));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(BaseColor.GRAY);
            c1.setPadding(5);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Screenshot", fontSukhumvit16));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(BaseColor.GRAY);
            c1.setPadding(5);
            table.addCell(c1);
        }

        PdfPCell r1 = new PdfPCell(new Phrase(testcaseDescription, fontSukhumvit9));
        r1.setHorizontalAlignment(Element.ALIGN_LEFT);
        r1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r1.setBorderColor(BaseColor.GRAY);
        table.addCell(r1);
        r1 = new PdfPCell(Image.getInstance(imagePage), true);
        r1.setBorderColor(BaseColor.GRAY);
        table.addCell(r1);
        paragraphDemoStep.add(table);

    }

    public static void addDemonstratedCapabilityPage(Document document) throws DocumentException, IOException {

        Paragraph preface = new Paragraph();
        PdfPTable table2 = new PdfPTable(1);
        table2.setWidthPercentage(100f);
        PdfPCell r2 = new PdfPCell(new Paragraph("1. Summary & Conclusions", fontSukhumvit18));
        r2.setHorizontalAlignment(Element.ALIGN_LEFT);
        r2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(r2);

        r2 = new PdfPCell(new Paragraph("   1.1. Summary report", fontSukhumvit16));
        r2.setHorizontalAlignment(Element.ALIGN_LEFT);
        r2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(r2);

        preface.add(table2);
        document.add(preface);

    }

    public static void addSystemAcceptanceTitlePage(Document document) throws DocumentException, IOException {
        document.newPage();
        Paragraph subCatPart = new Paragraph();
        PdfPTable table2 = new PdfPTable(1);
        table2.setWidthPercentage(100f);
        PdfPCell r2 = new PdfPCell(new Paragraph("   1.2. Demonstrated Capability", fontSukhumvit16));
        r2.setHorizontalAlignment(Element.ALIGN_LEFT);
        r2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(r2);

        subCatPart.add(table2);
        PdfPTable table = new PdfPTable(3);
        float[] anchoDeColumnas = new float[]{8f, 80f, 12f};
        table.setWidths(anchoDeColumnas);
        table.setWidthPercentage(100f);

        subCatPart.add(table);
        document.add(subCatPart);
    }

    public static void addSystemAcceptancePage(Document document, String testcaseDescription, boolean isHeader, int index, Setting.RESULT_TYPE resultType) throws DocumentException, IOException {
        PdfPTable table = new PdfPTable(3);
        float[] anchoDeColumnas = new float[]{8f, 80f, 12f};
        table.setWidths(anchoDeColumnas);
        table.setWidthPercentage(100f);
        if (isHeader) {
            paragraphSummaryCase = new Paragraph();
            addEmptyLine(paragraphSummaryCase, 1);
            PdfPCell c1 = new PdfPCell(new Phrase("No", fontSukhumvit12));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(BaseColor.GRAY);
            c1.setPadding(5);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Testcase Name", fontSukhumvit12));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(BaseColor.GRAY);
            c1.setPadding(5);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Status", fontSukhumvit12));
            c1.setBorderColor(BaseColor.GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setPadding(5);
            table.addCell(c1);
            table.setHeaderRows(1);
        }

        PdfPCell r1 = new PdfPCell(new Phrase(String.valueOf(index), fontSukhumvit9));
        r1.setHorizontalAlignment(Element.ALIGN_CENTER);
        r1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r1.setBorderColor(BaseColor.GRAY);
        table.addCell(r1);
        r1 = new PdfPCell(new Phrase(testcaseDescription, fontSukhumvit9));
        r1.setBorderColor(BaseColor.GRAY);
        table.addCell(r1);

        switch (resultType) {
            case PASS:
                r1 = new PdfPCell(new Phrase("PASS", fontSukhumvit9Green));
                break;
            case FAILED:
                r1 = new PdfPCell(new Phrase("FAILED", fontSukhumvit9Red));
                break;
            case SKIP:
                r1 = new PdfPCell(new Phrase("SKIP", fontSukhumvit9Yellow));
                break;
        }

        r1.setHorizontalAlignment(Element.ALIGN_CENTER);
        r1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        r1.setBorderColor(BaseColor.GRAY);
        table.addCell(r1);
        paragraphSummaryCase.add(table);
    }

    public static void addSystemAcceptancePage2(Document document) throws DocumentException, IOException {
        PdfPTable table = new PdfPTable(3);
        float[] anchoDeColumnas = new float[]{8f, 80f, 12f};
        table.setWidths(anchoDeColumnas);
        table.setWidthPercentage(100f);

        paragraphSummaryCase = new Paragraph();
        addEmptyLine(paragraphSummaryCase, 1);
        PdfPCell c1 = new PdfPCell(new Phrase("No", fontSukhumvit12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBorderColor(BaseColor.GRAY);
        c1.setPadding(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Testcase Name", fontSukhumvit12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBorderColor(BaseColor.GRAY);
        c1.setPadding(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Status", fontSukhumvit12));
        c1.setBorderColor(BaseColor.GRAY);
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setPadding(5);
        table.addCell(c1);
        table.setHeaderRows(1);

        for (int i = 0; i < testcaseResultList.size(); i++) {
            PdfPCell r1 = new PdfPCell(new Phrase(String.valueOf(i+1), fontSukhumvit9));
            r1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r1.setBorderColor(BaseColor.GRAY);
            table.addCell(r1);
            r1 = new PdfPCell(new Phrase(testcaseResultList.get(i).description, fontSukhumvit9));
            r1.setBorderColor(BaseColor.GRAY);
            table.addCell(r1);

            switch (testcaseResultList.get(i).status) {
                case PASS:
                    r1 = new PdfPCell(new Phrase("PASS", fontSukhumvit9Green));
                    break;
                case FAILED:
                    r1 = new PdfPCell(new Phrase("FAILED", fontSukhumvit9Red));
                    break;
                case SKIP:
                    r1 = new PdfPCell(new Phrase("SKIP", fontSukhumvit9Yellow));
                    break;
            }

            r1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r1.setBorderColor(BaseColor.GRAY);
            table.addCell(r1);
        }
        paragraphSummaryCase.add(table);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
