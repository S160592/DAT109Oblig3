package no.hvl.dat109.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import no.hvl.dat109.EAO.AvfallsplassEAO;
import no.hvl.dat109.Entity.Avfallsplass;
import no.hvl.dat109.hjelpeklasser.GPSUtils;

/**
 * Servlet implementation class NermasteLeveringsstad
 */
@WebServlet("/nermasteLeveringsstad")
public class NermasteLeveringsstad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	AvfallsplassEAO avfallsplassEAO;
	
	GPSUtils gps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NermasteLeveringsstad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		gps = new GPSUtils();
		
		double brukarLatitude = Double.parseDouble(request.getParameter("latitude"));
		double brukarLongitude = Double.parseDouble(request.getParameter("longitude"));
		List<Avfallsplass> avfallsplasser = avfallsplassEAO.hentAlleAvfallsplasser();
		
		//Finn nermaste Leveringssted(Alle innen 5 km)
		List<Avfallsplass> nermaste = gps.finnNermaste(brukarLatitude, brukarLongitude, avfallsplasser);
		
		
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		
		response.getWriter().append(gson.toJson(nermaste));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
