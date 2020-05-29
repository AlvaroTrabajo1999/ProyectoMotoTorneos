package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import modelo.ejb.AnadirEjb;
import modelo.ejb.MultimediaEjb;

/**
 * Servlet implementation class SubirImagen
 */
@WebServlet("/SubirImagenMoto")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class SubirImagenMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//variable que guarda donde se subira la imagen
	private static final String UPLOAD_DIRECTORY = "Vista/assets/img/moto";
	
	@EJB
	AnadirEjb anadirEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	
	/**
	 * do get, reenvia al servlet deseado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matriculaMoto = request.getParameter("id");
		request.setAttribute("motocicleta", matriculaMoto);
		
		if (multimediaEjb.getMultimediaMotocicletasById(matriculaMoto) != null) {
			//reenviamos al jsp de añadir moto holas
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=motos");
			rs.forward(request, response);
		} else {
			//reenviamos al jsp de añadir moto holas
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/SubirImagenMoto.jsp");
			rs.forward(request, response);
		}
		
	}

	/**
	 * do post, comprueba el archivo que se ha subido y la añade a las base de datos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Obtenemos una ruta en el servidor para guardar el archivo
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		// Si la ruta no existe la crearemos
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Lo utilizaremos para guardar el nombre del archivo
		String fileName = null;

		// Obtenemos el archivo y lo guardamos a disco
		for (Part part : request.getParts()) {
			fileName = getFileName(part);
			part.write(uploadPath + File.separator + fileName);
		}

		// Si es una imagen la mostramos
		if (fileName.matches(".+\\.(jpg|png)")) {
			HttpSession sesion = request.getSession(false);
			String moto = (String) sesion.getAttribute("moto");
			if (moto != null) {
				anadirEjb.insertMultimediaMoto(moto, fileName);
			} else {
				
			}
		}
		
		//terminamos reenviando a otro servlet
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=motos");
		rs.forward(request, response);
		
	}

	// Obtiene el nombre del archivo, sino lo llamaremos desconocido.txt
	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "desconocido.txt";
	}
	
}
