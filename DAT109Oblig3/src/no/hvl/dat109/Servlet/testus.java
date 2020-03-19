package no.hvl.dat109.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.Interfaces.Databehandling;

/**
 * Servlet implementation class testus
 */
@WebServlet("/testus")
public class testus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling databehandling;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		databehandling.getAlleProdukt().forEach(x -> {
			try {
				response.getWriter().append(x.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String barcode = request.getParameter("barcode");
		System.out.println(barcode);
		
		Produkt produkt = new Produkt();
		produkt.setBarcode(barcode);
		
		databehandling.lagreProdukt(produkt);
	}

}
