package no.hvl.dat109.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import no.hvl.dat109.EAO.ProduktEAO;
import no.hvl.dat109.Entity.Produkt;
import no.hvl.dat109.hjelpeklasser.Melding;
import no.hvl.dat109.hjelpeklasser.Meldingstype;

/**
 * Servlet implementation class getProduct
 */
@WebServlet("/hentProdukt")
public class HentProdukt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	ProduktEAO produktEAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HentProdukt() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF8");
		
		String barcode = request.getParameter("barcode");
		Melding melding;
		
		Produkt produkt = produktEAO.hentProdukt(barcode);
		if(produkt == null) {
			melding = new Melding(Meldingstype.ProduktFinnastIkkje);
		}else {
			melding = new Melding(Meldingstype.ProduktOK); 
			melding.setProdukt(produkt);
		}
		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		

		//produkt.getAvfallstypeBean().getAvfallsplasses().forEach(p -> p.setAvfallstypes(null));
		
		response.getWriter().append(gson.toJson(melding));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
