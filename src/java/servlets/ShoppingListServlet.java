package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author lixia
 */
public class ShoppingListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");

		if (user == null || user.getUsername().trim().equals("")) {
			getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			return;
		}

		String action = request.getParameter("action");
		if (action != null && action.equals("logout")) {
			session.invalidate();
			getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			return;
		}


		getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String action = request.getParameter("action");

		if (action != null) {
		switch(action) {
			case "register":
				String username = request.getParameter("username");
				user = new User(username);

				session.setAttribute("user", user);

				break;
			case "add":
				user = (User) session.getAttribute("user");
				String item = request.getParameter("item");

				ArrayList<String> shoppinglist = (ArrayList<String>) user.getShoppinglist();
				shoppinglist.add(item);

				break;
			case "delete":
				item = request.getParameter("item");
				user = (User) session.getAttribute("user");

				shoppinglist = (ArrayList<String>) user.getShoppinglist().clone();
				shoppinglist.remove(item);
				user.setShoppinglist(shoppinglist);
	
				break;
			default:
				System.out.println("Unknown action type");
		}
		}

		String pageStr = request.getParameter("page");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		System.out.println(page);
		String pageSizeStr = request.getParameter("pagesize");
		int pagesize = pageSizeStr == null ? 2 : Integer.parseInt(pageSizeStr);
		System.out.println(pagesize);

		ArrayList<String> userShoppingList = user.getShoppinglist();
		System.out.println(userShoppingList);
		int startIndex = pagesize * (page - 1);
		int endIndex = Math.min(userShoppingList.size(),  startIndex + pagesize);
		endIndex = endIndex < 0 ? 0 : endIndex;
		List<String> displaylist = user.getShoppinglist().subList(startIndex, endIndex);

		request.setAttribute("displaylist", displaylist);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("lastpage", Math.round(user.getShoppinglist().size() / (double)pagesize));

		getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
	}

}
