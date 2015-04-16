/**
 * 
 */
package edu.rice.jz52.server.httpservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jz52@rice.edu
 *
 */
public class GameGUIServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8921931865557368174L;
	private Logger logger = Logger.getLogger("GameGUIServlet.class");
//	private Gson gson = new Gson();
	
	/**
	 * Reads the input stream into a string
	 * @param is
	 * @return
	 */
	private static String getStringFromInputStream(InputStream is) {
		 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line+"\n");
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Handles a get request and responds with the HTML of the game GUI
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException{
		// TODO change parameter data
//		String jsonString = URLDecoder.decode(req.getParameter("data"), "UTF-8");
//		JoinSubGameMessage request = gson.fromJson(jsonString, JoinSubGameMessage.class);
	    ServletContext context = getServletContext();
		String indexhtml = getStringFromInputStream(context.getResourceAsStream("/WEB-INF/test_witth_tictactoe_html/tic-tac-toe.html"));
//		indexhtml = indexhtml.replace("\"REPLACE_PLAYER_NAME\"", "\""+request.playerName+"\"");
//		indexhtml = indexhtml.replace("\"REPLACE_TOKEN\"", "\""+request.token+"\"");
//		indexhtml = indexhtml.replace("\"REPLACE_ENABLE_MOUSE\"", "false");
		resp.getWriter().println(indexhtml);
		logger.log(Level.INFO, "do get");
//		resp.setContentType("text/plain");
//		resp.getWriter().println("Hello, world");
	}
}
