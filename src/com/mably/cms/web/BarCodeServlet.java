/*
 * Copyright (C) 2009 Francois Masurel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mably.cms.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.inject.Singleton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mably.cms.utils.zxing.ByteMatrixPngEncoder;

/**
 * @author f.masurel
 *
 */
@Singleton
public class BarCodeServlet extends HttpServlet {

    /** serialVersionUID. */
    private static final long serialVersionUID = 7131942698661805870L;

    /** Logger. */
    //private static final Logger LOG =LoggerFactory(BarCodeServlet.class);
    protected static final Logger LOG = Logger.getLogger(BarCodeServlet.class);

    /**
     * {...@inheritdoc}
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * {...@inheritdoc}
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

                String contents = "http://www.google.com";;
                int width = 200;
                int height = 200;

                QRCodeWriter bcWriter = new QRCodeWriter();
                ByteMatrix matrix = bcWriter.encode(contents, BarcodeFormat.QR_CODE, width, height);

                ByteMatrixPngEncoder pngEncoder =
                        new ByteMatrixPngEncoder(matrix, 9);
                byte[] data = pngEncoder.pngEncode();

            res.setContentType("image/png");
            res.setContentLength(data.length);

            ServletOutputStream out = res.getOutputStream();
            out.write(data);
            out.flush();
            out.close();

        } catch (Exception e) {
                LOG.error(e.toString(), e);
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }
    }
}
