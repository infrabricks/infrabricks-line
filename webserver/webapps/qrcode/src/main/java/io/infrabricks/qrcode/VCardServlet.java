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
import net.glxn.qrgen.core.vcard.VCard;

public class VCardServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String title = request.getParameter("title");
		String company = request.getParameter("company");
		String phone = request.getParameter("phone");
		String website = request.getParameter("website");
		log( title + " " + name + " " + address + " " + company + " " + phone + " " + email + " " + website );

		// encode contact data as vcard using defaults
		VCard vcard = new VCard(name)
      .setEmail(email)
      .setAddress(address)
      .setTitle(title)
      .setCompany(company)
      .setPhoneNumber(phone)
      .setWebsite(website);
		log(vcard.toString());
		ByteArrayOutputStream out = QRCode.from(vcard)
			.withCharset("UTF-8")
			.to(ImageType.PNG)
			.withSize(250, 250)
			.stream();
		response.setContentType("image/png");
		response.setContentLength(out.size());
		OutputStream outStream = response.getOutputStream();
		outStream.write(out.toByteArray());
		outStream.flush();
	}
}
