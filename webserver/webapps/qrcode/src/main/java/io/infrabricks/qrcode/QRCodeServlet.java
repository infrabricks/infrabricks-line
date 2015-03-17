package io.infrabricks.qrcodes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.glxn.qrgen.javase.QRCode;
import net.glxn.qrgen.core.image.ImageType;

public class QRCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String qrtext = request.getParameter("code");
		ByteArrayOutputStream out = QRCode.from(qrtext).to(
				ImageType.PNG).stream();
		response.setContentType("image/png");
		response.setContentLength(out.size());
		OutputStream outStream = response.getOutputStream();
		outStream.write(out.toByteArray());
		outStream.flush();
	}
}
