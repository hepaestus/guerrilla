package org.stripesbook.quickstart.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mably.cms.utils.zxing.ByteMatrixPngEncoder;

public class CreateQRCodeActionBean extends BaseActionBean {

    private String contents;
    private Integer height;
	private Integer width; 
	private boolean saveFileLocalFlag;
    
	@DefaultHandler
    public void view() {
	        
		if (width == null) {
            width = 100;
		}
		if (height == null) {
            height = 100;
		}

		if ( contents != null ) {
		    
            logger.debug("contents : " + contents);
            
            ActionBeanContext context = this.getContext();
            HttpServletResponse res = context.getResponse();
            
            QRCodeWriter bcWriter = new QRCodeWriter();
            ByteMatrix matrix = null;
    		try {			
    			matrix = bcWriter.encode(contents, BarcodeFormat.QR_CODE, width, height);
    		} catch (WriterException e) {			
    			e.printStackTrace();
    		}
    
            ByteMatrixPngEncoder pngEncoder = new ByteMatrixPngEncoder(matrix, 9);
            byte[] data = pngEncoder.pngEncode();
    	
            res.setContentType("image/png");       
            res.setContentLength(data.length);
    
            try {
                ServletOutputStream out = res.getOutputStream();        
                out.write(data);
                out.flush();
                out.close();    
            } catch (Exception e) {
                logger.error(e.toString(), e);            
            }
        				
		} else {
		    logger.debug("contents was null");		    
		}
	}	

	
	public static void saveImage(BufferedImage img, String ref) {  
	    try {  
	        String format = (ref.endsWith(".png")) ? "png" : "jpg";  
	        ImageIO.write(img, format, new File(ref));  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
		
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public boolean isSaveFileLocalFlag() {
		return saveFileLocalFlag;
	}

	public void setSaveFileLocalFlag(boolean saveFileLocalFlag) {
		this.saveFileLocalFlag = saveFileLocalFlag;
	}
}