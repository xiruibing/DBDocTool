package com.xiruibin;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

public final class Word2007 {

    /**
     * 生成word，表格
     * 
     * @param data
     * @throws Exception
     */
    public static void productWordForm(Map<String, LinkedHashMap<String, LinkedHashMap<String, String>>> data,
                                       Parameters parameters) throws Exception {
        XWPFDocument xDocument = new XWPFDocument();

        Iterator<String> tableNameIter = data.keySet().iterator();
        while (tableNameIter.hasNext()) {
            String table_name = tableNameIter.next();
            XWPFParagraph xp = xDocument.createParagraph();
            XWPFRun r1 = xp.createRun();
            r1.setText(table_name);
            r1.setFontSize(18);
            r1.setTextPosition(10);
            
            XWPFParagraph p = xDocument.createParagraph();
            p.setAlignment(ParagraphAlignment.CENTER);
            p.setWordWrap(true);
            
            LinkedHashMap<String, LinkedHashMap<String, String>> columns = data.get(table_name);
            int rows = columns.size();
            XWPFTable xTable = xDocument.createTable(rows + 1, 7);
            //表格属性
            CTTblPr tablePr = xTable.getCTTbl().addNewTblPr();
            //表格宽度
            CTTblWidth width = tablePr.addNewTblW();
            width.setW(BigInteger.valueOf(8600));

            int i = 0;
            
            xTable.getRow(i).setHeight(380);
            CTTcPr cellPr0 = xTable.getRow(i).getCell(0).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(1700));
            setCellText(xDocument, xTable.getRow(i).getCell(0), "代码", "CCCCCC");
            cellPr0 = xTable.getRow(i).getCell(1).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(3000));
            setCellText(xDocument, xTable.getRow(i).getCell(1), "注释", "CCCCCC");
            cellPr0 = xTable.getRow(i).getCell(2).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(1000));
            setCellText(xDocument, xTable.getRow(i).getCell(2), "类型", "CCCCCC");
            cellPr0 = xTable.getRow(i).getCell(3).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(700));
            setCellText(xDocument, xTable.getRow(i).getCell(3), "默认值", "CCCCCC");
            cellPr0 = xTable.getRow(i).getCell(4).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(350));
            setCellText(xDocument, xTable.getRow(i).getCell(4), "标识", "CCCCCC");
            cellPr0 = xTable.getRow(i).getCell(5).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(350));
            setCellText(xDocument, xTable.getRow(i).getCell(5), "主键", "CCCCCC");
            cellPr0 = xTable.getRow(i).getCell(6).getCTTc().addNewTcPr();
            cellPr0.addNewTcW().setW(BigInteger.valueOf(350));
            setCellText(xDocument, xTable.getRow(i).getCell(6), "空值", "CCCCCC");

            i = i + 1;// 下一行
            int j = 0;// 列column索引

            Map<String, LinkedHashMap<String, String>> keyColumnMap = keyColumns(columns);
            for (Iterator<String> columnNameIter = keyColumnMap.keySet().iterator(); columnNameIter.hasNext();) {
                String column_name = columnNameIter.next();
                LinkedHashMap<String, String> columnsAtt = keyColumnMap.get(column_name);

                setCellText(xDocument, xTable.getRow(i).getCell(j), column_name, "FFFFFF");
                ++j;

                Iterator<String> columnTypeIter = columnsAtt.keySet().iterator();

                while (columnTypeIter.hasNext()) {
                    String colum_type = columnTypeIter.next();
                    setCellText(xDocument, xTable.getRow(i).getCell(j),columnsAtt.get(colum_type), "FFFFFF");
                    j++;
                }

                ++i;// 下一行
                j = 0;// 恢复第一列
            }

            Iterator<String> cloumnsNameIter = columns.keySet().iterator();

            while (cloumnsNameIter.hasNext()) {
            	xTable.getRow(i).setHeight(380);
                String colum_name = cloumnsNameIter.next();
                LinkedHashMap<String, String> columnsAtt = columns.get(colum_name);
                if (xTable.getRow(i) == null) continue;
                setCellText(xDocument, xTable.getRow(i).getCell(j),colum_name, "FFFFFF");

                j++;

                Iterator<String> columnTypeIter = columnsAtt.keySet().iterator();

                while (columnTypeIter.hasNext()) {
                    String colum_type = columnTypeIter.next();

                    setCellText(xDocument, xTable.getRow(i).getCell(j),columnsAtt.get(colum_type), "FFFFFF");
                    j++;
                }
                j = 0;// 恢复第一列
                ++i; //下一行
            }
            
            XWPFTableRow row = xTable.insertNewTableRow(0);
            row.setHeight(380);
			row.addNewTableCell();
			row.getCell(0).setColor("CCCCCC");
			row.getCell(0).setText("中文名称");
			row.addNewTableCell();
			row.getCell(1).setText("");
			row.addNewTableCell();
			row.getCell(2).setColor("CCCCCC");
			row.getCell(2).setText("英文名称");
			row.addNewTableCell();
			CTTc cttc = row.getCell(3).getCTTc();
			CTTcPr ctPr = cttc.addNewTcPr();
			ctPr.addNewGridSpan().setVal(BigInteger.valueOf(4));
			ctPr.addNewHMerge().setVal(STMerge.CONTINUE);
			cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			cttc.getPList().get(0).addNewR().addNewT().setStringValue(table_name);
			
			row = xTable.insertNewTableRow(1);
			row.setHeight(380);
			row.addNewTableCell();
			row.getCell(0).setColor("CCCCCC");
			row.getCell(0).setText("功能描述");
			row.addNewTableCell();
			cttc = row.getCell(1).getCTTc();
			ctPr = cttc.addNewTcPr();
			ctPr.addNewGridSpan().setVal(BigInteger.valueOf(6));
			ctPr.addNewHMerge().setVal(STMerge.CONTINUE);
			cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.LEFT);
			cttc.getPList().get(0).addNewR().addNewT().setStringValue("");
        }

        FileOutputStream fos = new FileOutputStream(parameters.getPath() + parameters.getDatabase() + "_doc.docx");

        xDocument.write(fos);
        fos.close();
    }
    
    private static void spanCellsAcrossRow(XWPFTable table, int rowNum, int colNum, int span) {
    	try {
    		 XWPFTableCell cell = table.getRow(rowNum).getCell(colNum);
    		if (cell.getCTTc().getTcPr() != null) {
    			cell.getCTTc().getTcPr().addNewGridSpan();
    			if (cell.getCTTc().getTcPr().getGridSpan() == null) {
	    	        cell.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long)span));
    			}
    		}
    	} catch (Exception e) {
    		throw e;
    	}
    }
    
    private static void setCellText(XWPFDocument xDocument, XWPFTableCell cell, String text, String bgcolor) {
    	cell.setColor(bgcolor);
    	cell.setVerticalAlignment(XWPFVertAlign.CENTER);
        cell.setText(text);
    }

    /**
     * 检索出主键key相关的列
     * 
     * @param columnsMap
     * @return
     */
    private static Map<String, LinkedHashMap<String, String>> keyColumns(HashMap<String, LinkedHashMap<String, String>> columnsMap) {
        Map<String, LinkedHashMap<String, String>> keyColumnMap = new HashMap<String, LinkedHashMap<String, String>>();

        Iterator<String> cloumnsNameIter = columnsMap.keySet().iterator();
        while (cloumnsNameIter.hasNext()) {
            String colum_name = cloumnsNameIter.next();
            LinkedHashMap<String, String> columnsAtt = columnsMap.get(colum_name);
            if (columnsAtt.get("column_key").equals("是")) {
                keyColumnMap.put(colum_name, columnsAtt);
                cloumnsNameIter.remove();
            }
        }

        return keyColumnMap;
    }
}
